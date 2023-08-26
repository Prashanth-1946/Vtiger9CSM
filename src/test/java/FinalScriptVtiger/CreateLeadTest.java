package FinalScriptVtiger;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import GenericLibraries.BaseClass;
import GenericLibraries.IConstantPath;

public class CreateLeadTest extends BaseClass
{
	
	@Test
	public void creatLeadtest()
	{
		SoftAssert soft=new SoftAssert();
		home.clickleads();
		soft.assertTrue(driver.getTitle().contains("Lead"));
		
		lead.clickPlusButton();
		soft.assertEquals(createLead.getPageHeader(),"Creating New Lead");
		
		Map<String,String> map=excel.readFromExcel("Lead","CREATE LEAD ");
		String lastName=map.get("Last Name")+jutil.generateRandomNum(100);
		
		excel.writetoexcel("Lead",11, 3, lastName, IConstantPath.EXCEL_PATH);
		
		createLead.setlastname(lastName);
		createLead.setcompanyname(map.get("Company Name"));
		createLead.clicksavebtn();
		soft.assertTrue(newLead.getPageHeader().contains(lastName));
		
		if(newLead.getPageHeader().contains(lastName))
			excel.writeToExcel("Leads", "CREATE LEAD ", "Pass",IConstantPath.EXCEL_PATH);
		else
			excel.writeToExcel("Leads", "CREATE LEAD ", "Fail",IConstantPath.EXCEL_PATH);
		
	
		soft.assertAll();		
	}
}
