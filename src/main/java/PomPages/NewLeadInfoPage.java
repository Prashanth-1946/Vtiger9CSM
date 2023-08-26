package PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewLeadInfoPage
{
//Declaration
		@FindBy(xpath="//span[@class='dvHeaderText']")
		private WebElement pageheader;
		@FindBy(name="Duplicate")
		private WebElement dButton;
		
//Initialization
	    public NewLeadInfoPage(WebDriver driver) 
	    {
		PageFactory.initElements(driver, this);
	    }
	    
//Utilization
	    public String getPageHeader()
		{
			return pageheader.getText();
		}
	    public void clickDuplicateButton()
	    {
	    	dButton.click();
         }    
	    
}
