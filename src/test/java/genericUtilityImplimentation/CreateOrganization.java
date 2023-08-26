package genericUtilityImplimentation;

import java.time.Duration;
import java.util.Map;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import GenericLibraries.Excel_Utility;
import GenericLibraries.IConstantPath;
import GenericLibraries.JavaUtility;
import GenericLibraries.PropertiesUtility;
import GenericLibraries.WebdriverUtility;

public class CreateOrganization {

	public static void main(String[] args) 
	{
		PropertiesUtility property=new PropertiesUtility();
		Excel_Utility excel=new Excel_Utility();
		JavaUtility jutil=new JavaUtility();
		WebdriverUtility wdutil=new WebdriverUtility();
		
		property.propertiesInitialization(IConstantPath.PROPERTIES_PATH);
		excel.excelInitialization(IConstantPath.EXCEL_PATH);
		
		
		
//		WebDriver driver=new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("http://localhost:8888/");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		WebDriver driver=wdutil.launchBrowser(property.readFromProperties("browser"));
		wdutil.maximizeBrowser();
		wdutil.navigateToUrl(property.readFromProperties("url"));
		wdutil.waitTillElementFound(Long.parseLong(property.readFromProperties("time")));
		
		if(driver.getTitle().contains("vtiger"))
			System.out.println("Login page is displayed");
		else
			System.out.println("login page is not displayed");
		driver.findElement(By.name("user_name")).sendKeys(property.readFromProperties("username"));
		driver.findElement(By.name("user_password")).sendKeys(property.readFromProperties("password"));
		
		driver.findElement(By.id("submitButton")).submit();
		
		if(driver.getTitle().contains("Home"))
			System.out.println("Home page is displayed");
		else
			System.out.println("Home page is not found");
		
		driver.findElement(By.xpath("//a[text()='Organizations' and \"action=index\"]")).click();
		
		if(driver.getTitle().contains("Organisations"))
			System.out.println("Oragnisations page is displayed");
		else
			System.out.println("Organisations is not found");
		
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		WebElement creatorg=driver.findElement(By.xpath("//span[@class='lvtHeaderText']"));
		if(creatorg.equals("Creating New Organisation"))
			System.out.println("Create New Oragnisation page is displayed");
		else
			System.out.println("Creating New Organisation is not found");
		
		
//		Random random=new Random();
//		int randomNum=random.nextInt(100);
		
		Map<String,String> map=excel.readFromExcel("Oragnisation", "Createorganisation");
		String orgName=map.get("Oragnistion Name")+jutil.generateRandomNum(100);
		
//		String orgName="TCS"+randomNum;
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.xpath("//input[normalize-space(@value)='Save']")).click();
		
		String newOrgInfo=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		if(newOrgInfo.contains(orgName)) {
			System.out.println("Organisation created successfully");
		    excel.writeToExcel("Oragnisation", "Createorganisation", "pass", IConstantPath.EXCEL_PATH);
		}
		else
		{
			System.out.println("Organisation not created");
			excel.writeToExcel("Oragnisation", "Createorganisation", "Fail", IConstantPath.EXCEL_PATH);
		}
		WebElement adminIcon=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		
//		Actions a=new Actions(driver);
//		a.moveToElement(adminIcon).perform();
		
		wdutil.mouseHover(adminIcon);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
//		driver.quit();		
		wdutil.quitAllWindows();
		excel.closeExcel();

	}

}
