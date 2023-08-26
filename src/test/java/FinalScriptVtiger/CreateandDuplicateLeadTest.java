package FinalScriptVtiger;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import GenericLibraries.BaseClass;
import GenericLibraries.IConstantPath;

public class CreateandDuplicateLeadTest extends BaseClass
{
	@Test
	public void createAndduplicateleadtest()
	{
		SoftAssert soft=new SoftAssert();
		home.clickleads();
		soft.assertTrue(driver.getTitle().contains("Leads"));
		
		lead.clickPlusButton();
		soft.assertEquals(createLead.getPageHeader(),"Creating New Lead");
		
		Map<String,String> map=excel.readFromExcel("Leads","Create and Duplicate Lead");
		String lastname=map.get("Last Name")+jutil.generateRandomNum(100);
		
		createLead.setlastname(lastname);
		createLead.setcompanyname(map.get("Company Name"));
		createLead.clicksavebtn();
		soft.assertTrue(newLead.getPageHeader().contains(lastname));
		
		newLead.clickDuplicateButton();
		soft.assertTrue(duplicateLead.getPageHeader().contains("Duplicating"));
		
		String newlastname=map.get("New Last Name")+jutil.generateRandomNum(100);
		duplicateLead.setlastname(newlastname);
		duplicateLead.clicksavebtn();
		
		if(newLead.getPageHeader().contains(lastname))
			excel.writeToExcel("Leads", "CREATE LEAD", "Pass",IConstantPath.EXCEL_PATH);
		else
			excel.writeToExcel("Leads", "CREATE LEAD", "Fail",IConstantPath.EXCEL_PATH);
	
		soft.assertAll();
		
	}
	

}
