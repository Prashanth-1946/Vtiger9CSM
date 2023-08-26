package hardcorded;

import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateEvent {

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
		
		WebElement QuitecreateDropdown=driver.findElement(By.id("qccombo"));
		Select s=new Select(QuitecreateDropdown);
		s.selectByValue("Events");
		
		WebElement createToDo=driver.findElement(By.xpath("//b[text()='Create To Do']"));
		if(createToDo.isDisplayed())
			System.out.println("Create to do window is displayed");
		else
			System.out.println("Create to do window is not displayed");
		
		Random random=new Random();
		int randomNum=random.nextInt(100);
		String subject="Meet"+randomNum;
		
		driver.findElement(By.name("subject")).sendKeys(subject);
		driver.findElement(By.id("jscal_trigger_date_start")).click();
		
		String reqDate="19";
		int reqMonth=10;
		int reqYear=2025;
		
		String commonPath="//div[@class='calendar' and contains(@style,'block',)]/descendant::td[%s]";
		//String actMonthYear=driver.findElement(By.xpath(formatPath(commonPath,"@class='title'"))).getText();
		//System.out.println(actMonthYear);
		
			
	}
}
