package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.*;

import models.TestCase;

public class TestCaseProvider {

	@DataProvider(name="Test Cases") public static Object[][] testCases() throws IOException
	{
		//To import a spreadsheet of objects, a 2D array must be used. This is composed of an arraylist holding an object
		ArrayList<Object[]> testsArrayList = new ArrayList<Object[]>();
		 
		//Set file location to run from (Could be made more portable for future testing)
		FileInputStream file = new FileInputStream(new File("C:\\Users\\Jonny\\Documents\\APIAutomationTesting\\data.xlsx"));
		Workbook workbook = new XSSFWorkbook(file);
		
		//Get number of rows for for loop
		Sheet sheet = workbook.getSheetAt(0);
		sheet.getPhysicalNumberOfRows();
		
		TestCase tests = null;
		//Using arraylist, dynamically create as many rows of test case objects as provided from sheet
		for (Row row : sheet) {
			tests = new TestCase();
			tests.setHttpMethod(row.getCell(0).getStringCellValue());
			tests.setEndPointName(row.getCell(1).getStringCellValue());
			tests.setBody(row.getCell(2).getStringCellValue());
			testsArrayList.add(new Object[] { tests.getHttpMethod(), tests.getEndPointName(), tests.getBody() });
		}
		
		//close file readers
		file.close();
		workbook.close();
		
		//Given provider must work with known number of rows, 2D array using array list
		//is converted into 2D array with fixed and defined number of rows
		Object[][] testObject = new Object[testsArrayList.size()][];
		//All values are read into new 2D array to be returned
		for (int i = 0; i < testsArrayList.size(); i++)
		{
			testObject[i] = testsArrayList.get(i);
		}
        return testObject;
	}
}
