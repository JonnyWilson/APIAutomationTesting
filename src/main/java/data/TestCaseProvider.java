package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.*;

import models.TestCase;

public class TestCaseProvider {

	@DataProvider(name="Test Cases")
	  public static Object[][] testCases() throws IOException {
		
		//TestCase[][] test;
		
		ArrayList<Object[]> testsArrayList = new ArrayList<Object[]>();
		//Object[][] testObject = new Object[][];
		 
		FileInputStream file = new FileInputStream(new File("C:\\Users\\Jonny\\Documents\\APIAutomationTesting\\data.xlsx"));
		Workbook workbook = new XSSFWorkbook(file);
		
		Sheet sheet = workbook.getSheetAt(0);
		sheet.getPhysicalNumberOfRows();
		
		TestCase tests = null;
		for (Row row : sheet) {
			tests = new TestCase();
			tests.setHttpMethod(row.getCell(0).getStringCellValue());
			tests.setEndPointName(row.getCell(1).getStringCellValue());
			tests.setBody(row.getCell(2).getStringCellValue());
			testsArrayList.add(new Object[] { tests.getHttpMethod(), tests.getEndPointName(), tests.getBody() });
		}
		
		file.close();
		
		Object[][] testObject = new Object[testsArrayList.size()][];
		
		for (int i = 0; i < testsArrayList.size(); i++)
		{
			testObject[i] = testsArrayList.get(i);
		}
		
        return testObject;
	}
}
