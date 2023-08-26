package FinalScriptVtiger;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import GenericLibraries.BaseClass;
import GenericLibraries.IConstantPath;

public class DeleteLeadTest extends BaseClass
{
	@Test
	public void deleteleadTest()
	{
		SoftAssert soft=new SoftAssert();
		
		home.clickleads();
		soft.assertTrue(driver.getTitle().contains("Leads"));
		Map<String,String> map=excel.readFromExcel("Lead", "Delete lead");
		lead.traverseToRequiredLead(web, map.get("Lead Name"));
		lead.clickDelete();
		
		web.handleAlert("ok");
		List<WebElement> leadNameList=lead.getLeadNamesList();
		boolean status=false;
		for(WebElement leads:leadNameList)
		{
			if(!(leads.getText().equals("LEA1")))
			{
				status=true;
			}
		}
	
		soft.assertTrue(status);
		if(status)
			excel.writeToExcel("Lead", "Delete Lead", "Pass", IConstantPath.EXCEL_PATH);
		else
			excel.writeToExcel("Lead", "Delete lead", "Fail", IConstantPath.EXCEL_PATH);
		
		
		soft.assertAll();
			
	}
}
