package PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewContactInfoPage 
{
//Utilization
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement pageHeader;
	
//Initialization
	public NewContactInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
//Utilization
	public String getPageHeader()
	{
		return pageHeader.getText();
	}

}
