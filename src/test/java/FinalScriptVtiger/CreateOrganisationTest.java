package FinalScriptVtiger;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import GenericLibraries.BaseClass;
import GenericLibraries.IConstantPath;

public class CreateOrganisationTest extends BaseClass
{
	@Test
	public void createOrgTest()
	{
		SoftAssert soft=new SoftAssert();
		home.organisationsclick();
		soft.assertTrue(driver.getTitle().contains("Organizations"));
		org.clickPlusButton();
		soft.assertTrue(createorg.getPageHeader().equals("Creating New Organization"));
		Map<String,String> map=excel.readFromExcel("Oraganisation", "Create Organisation");
		String orgname=map.get("Organization Name")+jutil.generateRandomNum(100);
		createorg.setorgname(orgname);
		createorg.clicksavebtn();
		
		soft.assertTrue(newOrg.getPageHeader().contains(orgname));
		if(newOrg.getPageHeader().contains(orgname))
			excel.writeToExcel("Oraganisation","Create Organization","True",IConstantPath.EXCEL_PATH);
		else
			excel.writeToExcel("Oraganisation","Create Organization","Fail",IConstantPath.EXCEL_PATH);
		
		soft.assertAll();
		
			
		
	}

}
