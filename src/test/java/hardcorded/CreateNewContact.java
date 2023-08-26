package hardcorded;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateNewContact {

	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		if(driver.getTitle().contains("Vtiger"))
			System.out.println("Login page is Displayed");
		else
			System.out.println("Login page  not found");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		
		driver.findElement(By.id("submitButton")).submit();
		if(driver.getTitle().contains("Home"))
			System.out.println("Home is displayed");
		else
			System.out.println("Home is not found");
		
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		if(driver.getTitle().contains("Contacts"))
			System.out.println("Contacts page is displayed");
		else
			System.out.println("contacts page not found");
		
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		String newContact=driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		if(newContact.equals("Creating New Contact"))
			System.out.println("Create NEw Contact Page is displayed");
		else
			System.out.println("Create New contact not found");
		
		Random random=new Random();
		int randomNum=random.nextInt(100);
		
		String lastName="abc"+randomNum;
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		driver.findElement(By.xpath("//input[normalize-space(@value)='Save']")).click();
		
		String newcontactInfo=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(newcontactInfo.equals(lastName))
			System.out.println("NEw Contact Created successful");
		else
			System.out.println("new Contact not Created");
		
		 WebElement admininfo=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		    
		    Actions action=new Actions(driver);
		    action.moveToElement(admininfo).perform();
		    
		    driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		    driver.quit();
		    
		
	}

}
