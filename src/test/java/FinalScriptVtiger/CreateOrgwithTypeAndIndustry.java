package FinalScriptVtiger;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import GenericLibraries.BaseClass;
import GenericLibraries.IConstantPath;
import PomPages.NewOrgInfoPages;

public class CreateOrgwithTypeAndIndustry extends BaseClass
{
	@Test
	public void createOrgWithIndustryandType()
	{
		SoftAssert soft=new SoftAssert();
		home.organisationsclick();
		soft.assertTrue(driver.getTitle().contains("Organizations"));
		org.clickPlusButton();
		soft.assertTrue(createorg.getPageHeader().equals("Creating New Organization"));
		Map<String,String> map=excel.readFromExcel("Organisations", "Create Organisation");
		String orgname=map.get("Organization Name")+jutil.generateRandomNum(100);
		createorg.setorgname(orgname);
		createorg.selectIndustry(web, map.get("Industry"));
		createorg.selectType(web, map.get("Type"));
		
		createorg.clicksavebtn();
		
		soft.assertTrue(newOrg.getPageHeader().contains(orgname));
		
		if(newOrg.getPageHeader().contains(orgname))
			excel.writeToExcel("Organisations","Create  Organization With Industry And Type","True",IConstantPath.EXCEL_PATH);
		else
			excel.writeToExcel("Organisations","Create  Organization With Industry And Type","Fail",IConstantPath.EXCEL_PATH);
		
		soft.assertAll();
	}

}
