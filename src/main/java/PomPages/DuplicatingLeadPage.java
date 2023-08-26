package PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DuplicatingLeadPage 
{

//Declaration
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement pageheader;
	@FindBy(name="lastname")
	private WebElement lastname ;
	@FindBy(xpath="//input[normalize-space(@value)='Save']")
	private WebElement savebutton;

//Initialization
	public DuplicatingLeadPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
//Utilization
	 public String getPageHeader()
		{
			return pageheader.getText();
		}
	    public void setlastname(String LN)
		{
	    	lastname.sendKeys(LN);
		}
	    public void clicksavebtn()
		{
	    	savebutton.click();
		}


}
