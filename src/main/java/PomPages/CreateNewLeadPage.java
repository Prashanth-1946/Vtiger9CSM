package PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewLeadPage 
{
	
//Declaration
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement pageheader;
	
	@FindBy(name="firstname")
	private WebElement lastname ;
	
	@FindBy(name="company")
	private WebElement companyname;
	
	@FindBy(xpath="//input[normalize-space(@value)='Save']")
	private WebElement savebutton;
	
//Initialization
	public CreateNewLeadPage(WebDriver driver)
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
	    public void setcompanyname(String CN)
		{
	    	companyname.sendKeys(CN);
		}
	    public void clicksavebtn()
		{
	    	savebutton.click();
		}



}
