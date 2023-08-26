package GenericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {

	private Workbook workbook;
	private DataFormatter df;

	public void excelInitialization(String excelPath) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(excelPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			workbook = WorkbookFactory.create(fis);

		} catch (EncryptedDocumentException | IOException e) {
			e.printStackTrace();
		}
	}

	public String readFromString(String sheetName, int rowNum, int cellNum) {
		df = new DataFormatter();
		return df.formatCellValue(workbook.getSheet(sheetName).getRow(rowNum).getCell(cellNum));

	}

	/**
	 * This Method is used to read data of specified test script at a time
	 * 
	 * @param sheetName
	 * @param exceptedTestName
	 * @return
	 */

	public Map<String, String> readFromExcel(String sheetName, String exceptedTestName) {
		Map<String, String> map = new HashMap<String, String>();
		df = new DataFormatter();
		Sheet sheet = workbook.getSheet(sheetName);
		for (int i = 0; i <= sheet.getLastRowNum(); i++) {
			if (df.formatCellValue(sheet.getRow(i).getCell(1)).equals(exceptedTestName)) {
				for (int j = i; j <= sheet.getLastRowNum(); j++) {
					String key = df.formatCellValue(sheet.getRow(j).getCell(2));
					String value = df.formatCellValue(sheet.getRow(j).getCell(3));
					map.put(key, value);
					if (df.formatCellValue(sheet.getRow(j).getCell(2)).equals("####"))
						break;
				}
				break;

			}
		}
		System.out.println(map);
		return map;
	}

	/**
	 * this method is used to write data to excel
	 * 
	 * @param sheetName
	 */

	public void writeToExcel(String sheetName, String expectedTestName, String status, String excelPath) {
		Sheet sheet = workbook.getSheet(sheetName);
		for (int i = 0; i <= sheet.getLastRowNum(); i++) {
			if (df.formatCellValue(sheet.getRow(i).getCell(1)).equals(expectedTestName)) {
				Cell cell = sheet.getRow(i).createCell(4);
				cell.setCellValue(status);
				break;

			}
		}
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(excelPath);
		    }
		catch (FileNotFoundException e) 
		   {
			e.printStackTrace();
		   }
		try {
			workbook.write(fos);
		}catch(EncryptedDocumentException | IOException e)
		{
			e.printStackTrace();
		}

	}
	
	public void writetoexcel(String sheetName,int rowNum,int cellNum,String value, String excelPath)
	{
		Sheet sheet=workbook.getSheet(sheetName);
		sheet.getRow(rowNum).createCell(cellNum).setCellValue(value);
		FileOutputStream fos=null;
		try {
			fos=new FileOutputStream(excelPath);
		    }
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		try {
			workbook.write(fos);	
		    }
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * this method is to close
	 */
	public void closeExcel() {
		try {
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
