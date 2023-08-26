package PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewEventInfopage 
{
//Declaration
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement pageHeader;
	
	
//Initialization
	public void NewEvent(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
//Utilization
	public String getPageHeader()
	{
		return pageHeader.getText();
	}
}
