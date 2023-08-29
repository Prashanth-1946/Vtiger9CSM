package GenericLibraries;
//This is pre and post condition
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import PomPages.ContactsPage;
import PomPages.CreateNewContactPage;
import PomPages.CreateNewEventPage;
import PomPages.CreateNewLeadPage;
import PomPages.CreateNewOrganizationPage;
import PomPages.DuplicatingLeadPage;
import PomPages.HomePage;
import PomPages.LeadsPage;
import PomPages.LoginPage;
import PomPages.NewContactInfoPage;
import PomPages.NewEventInfopage;
import PomPages.NewLeadInfoPage;
import PomPages.NewOrgInfoPages;
import PomPages.OrganizationPage;

public class BaseClass 
{
	
	protected PropertiesUtility property;
	protected JavaUtility jutil;
	protected Excel_Utility excel;
	protected WebdriverUtility web;
	protected WebDriver driver;
	
	protected LoginPage login;
	protected HomePage home;
	protected LeadsPage lead;
	protected ContactsPage contact;
	protected OrganizationPage org;
	protected CreateNewContactPage createContact;
	protected CreateNewOrganizationPage createorg;
	protected CreateNewLeadPage createLead;
	protected CreateNewEventPage createEvent;
	protected NewLeadInfoPage newLead;
	protected NewContactInfoPage newContact;
	protected NewOrgInfoPages newOrg;
	protected NewEventInfopage newEvent;
	protected DuplicatingLeadPage duplicateLead;
	
	public static WebDriver sdriver;
	public static JavaUtility sjutil;
	 
	//@BeforeSuite
	//@BeforeTest
	
	@BeforeClass
	public void classSetup()
	{
		property=new PropertiesUtility();
		jutil=new JavaUtility();
		excel=new Excel_Utility();
		web=new WebdriverUtility();
		
		property.propertiesInitialization(IConstantPath.PROPERTIES_PATH);
		
		driver=web.launchBrowser(property.readFromProperties("browser"));
		
		web.maximizeBrowser();
		web.waitTillElementFound(Long.parseLong(property.readFromProperties("time")));
		
		sdriver=driver;
		sjutil=jutil;
		
	}
	
	@BeforeMethod
	
	public void methodSetup()
	{
		excel.excelInitialization(IConstantPath.EXCEL_PATH);
		
		login=new LoginPage(driver);
		home=new HomePage(driver);
		lead=new LeadsPage(driver);
		contact=new ContactsPage(driver);
		org=new OrganizationPage(driver);
		createorg=new CreateNewOrganizationPage(driver);
		createLead=new CreateNewLeadPage(driver);
		createContact=new CreateNewContactPage(driver);
		createEvent=new CreateNewEventPage(driver);
		newLead=new NewLeadInfoPage(driver);
		newContact=new NewContactInfoPage(driver);
		newOrg=new NewOrgInfoPages(driver);
		newEvent =new NewEventInfopage();
		duplicateLead=new DuplicatingLeadPage(driver);
		
		web.navigateToUrl(property.readFromProperties("url"));
		Assert.assertTrue(driver.getTitle().contains("vtiger"));
		login.loginToApp(property.readFromProperties("username"),
				property.readFromProperties("password"));
		Assert.assertTrue(driver.getTitle().contains("Home"));
		
	}
	
	@AfterMethod
	public void methodTearDown()
	{
		home.signOutOfVtiger(web);
		excel.closeExcel();
		
	}
	@AfterClass
	public void classTearDown()
	{
		web.quitAllWindows();
	}
	//@AfterTest
	//@AfterSuite

}
