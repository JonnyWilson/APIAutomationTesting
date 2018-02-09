package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.*;

import models.TestCase;

public class TestCaseProvider {

	@DataProvider(name="Test Cases")
	  public static Object[][] testCases() throws IOException {
		
		TestCase[][] test;
		 
		FileInputStream file = new FileInputStream(new File("data.xlsx"));
		Workbook workbook = new XSSFWorkbook(file);
		
		Sheet sheet = workbook.getSheetAt(0);
		sheet.getPhysicalNumberOfRows();
		
		for(int i = 0; i <sheet.getPhysicalNumberOfRows(); i++)
		{
			TestCase tests;
			for (Row row : sheet) {
				tests = new TestCase();
				tests.setHttpMethod(row.getCell(0).getStringCellValue());
				tests.setEndPointName(row.getCell(1).getStringCellValue());
				tests.setBody(row.getCell(2).getStringCellValue());
			}
			
			// just need to assign this back to the multi dimensional array somehow???
		}
		
	
		
		file.close();
		
        return test; 
}
