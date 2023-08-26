package FinalScriptVtiger;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import GenericLibraries.BaseClass;
import GenericLibraries.IConstantPath;
import io.reactivex.rxjava3.subjects.Subject;

public class CreateEventTest extends BaseClass
{
	@Test
	public void createEventtest()
	{
		SoftAssert soft=new SoftAssert();
		Map<String,String> map=excel.readFromExcel("Event", "Create New Event");
		home.selectFromquiteCreate(web, map.get("Quike Create"));
		soft.assertEquals(createEvent.getPageHeader(), "Create To Do");
		String subject=map.get("Subject")+jutil.generateRandomNum(100);
		createEvent.setSubject(subject);
		createEvent.clickOnStartDate();
		createEvent.chooseRequiredDate(web, map.get("Start Date"), jutil);
		createEvent.clickOnDueDate();
		createEvent.chooseRequiredDate(web,map.get("Due Date"), jutil);
		createEvent.clickSaveButton();
		soft.assertTrue(newEvent.getPageHeader().contains(subject));
		
		if(newEvent.getPageHeader().contains(subject))
			excel.writeToExcel("Event", "Create New Event", "Pass",IConstantPath.EXCEL_PATH);
		else
			excel.writeToExcel("Event", "Create New Event", "Fail",IConstantPath.EXCEL_PATH);
		
		
		soft.assertAll();
		
	}

}
