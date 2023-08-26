package PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericLibraries.WebdriverUtility;

public class HomePage 
{
//Declaration
	@FindBy(xpath="//a[text()='Leads' and contains(@href,'action=index')]")
	private WebElement leadsTab;
	@FindBy(xpath="//a[text()='Organizations' and contains(@href,'action=index')]")
	private WebElement organTab;
	@FindBy(xpath="//a[text()='Contacts' and contains(@href,'action=index')]")
	private WebElement contactsTab;
	@FindBy(id="qccombo")
	private WebElement quickcreateTab;
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminIcon;
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signOutButton;
	
//Initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
//Utilization
	
	public void clickleads()
	{
		leadsTab.click();
	}
	public void organisationsclick()
	{
		organTab.click();
	}
	public void clickContacts()
	{
		contactsTab.click();
	}
	public void selectFromquiteCreate(WebdriverUtility web,String value)
	{
		web.selectFromDropdown(quickcreateTab,value);
	}
	
	public void signOutOfVtiger(WebdriverUtility web)
	{
		web.mouseHover(adminIcon);
		signOutButton.click();
	}

}
