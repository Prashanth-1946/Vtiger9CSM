package hardcorded;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateLead {

	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		if(driver.getTitle().contains("vtiger"))
			System.out.println("Login page is displayed");
		else
			System.out.println("login page is not displayed");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).submit();
		
		if(driver.getTitle().contains("Home"))
			System.out.println("Home page is displayed");
		else
			System.out.println("Home page is not found");
		
		if(driver.getTitle().contains("Leads"))
			System.out.println("Leads page is displayed");
		else
			System.out.println("leads page is not displayed");
		
		driver.findElement(By.xpath("//img[@alt='Create Lead...']")).click();
		WebElement createlead=driver.findElement(By.xpath("//span[@class='lvtHeaderText']"));
		if(createlead.equals("Creating New Lead"))
			System.out.println("Create New Lead page is displayed");
		else
			System.out.println("Create new lead page is not displayed");
		

		Random random=new Random();
		int randomNum=random.nextInt(100);
		
		String lastname="john"+randomNum;
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		
		String leadName="seimens"+randomNum;
		driver.findElement(By.name("company")).sendKeys(leadName);
		driver.findElement(By.xpath("//input[noramalize-space(@value)='Save']")).click();
		
	    String newleadinfo=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	    
	    if(newleadinfo.contains(lastname))
	    	System.out.println("lead created successfull");
	    else
	    	System.out.println("lead not created");
	    
	    WebElement admininfo=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	    
	    Actions action=new Actions(driver);
	    action.moveToElement(admininfo).perform();
	    
	    driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	    driver.quit();
		
	}

}
