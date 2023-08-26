package FinalScriptVtiger;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import GenericLibraries.BaseClass;
import GenericLibraries.IConstantPath;
import PomPages.NewContactInfoPage;

public class CreateContactTest extends BaseClass
{
	@Test
	public void createContacttest()
	{
		SoftAssert soft=new SoftAssert();
		home.clickContacts();
		soft.assertTrue(driver.getTitle().contains("Contacts"));
		contact.clickPlusButton();
		soft.assertEquals(createContact.getPageHeader(),"Creating New Contact");
		Map<String,String> map=excel.readFromExcel("Contact", "Create Contact");
		
		String lastName=map.get("Last Name")+jutil.generateRandomNum(100);
		
		createContact.setLastName(lastName);
		createContact.clickSaveButton();
		
		soft.assertTrue(newContact.getPageHeader().contains(lastName));
		
		if(newContact.getPageHeader().contains(lastName))
			excel.writeToExcel("Contact", "Create Contact", "Pass", IConstantPath.EXCEL_PATH);
		else
			excel.writeToExcel("Contact", "Create Contact","Fail",IConstantPath.EXCEL_PATH);
		soft.assertAll();
	
		
	}

}
