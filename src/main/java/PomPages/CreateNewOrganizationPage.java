package PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericLibraries.WebdriverUtility;

public class CreateNewOrganizationPage 
{
//Declaration
	
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement pageheader;
	@FindBy(name="accountname")
	private WebElement orgname ;
	@FindBy(name="industry")
	private WebElement industrydropdown;
	@FindBy(name="accounttype")
	private WebElement typedropdown ;
	@FindBy(xpath="//input[normalize-space(@value)='Save']")
	private WebElement savebutton;
	
//Initialization
	
	public CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
//Utilization
	    public String getPageHeader()
		{
			return pageheader.getText();
		}
	    public void setorgname(String ON)
		{
			orgname.sendKeys(ON);
		}
	    public void selectIndustry(WebdriverUtility web, String value)
	    {
	    	web.selectFromDropdown(industrydropdown, value);
	    }
	    public void clicksavebtn()
		{
	    	savebutton.click();
		}
	    public void selectType(WebdriverUtility web, String value)
	    {
	    	web.selectFromDropdown(typedropdown, value);
	    		
	    }
}

