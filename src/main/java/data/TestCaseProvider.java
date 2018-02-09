package data;

import org.testng.annotations.*;

public class TestCaseProvider {

	@DataProvider(name="Test Cases")
	  public static Object[][] testCases() {
		 
        return new Object[][] { { "testuser_1", "Test@123" }, { "testuser_1", "Test@123" }};
 
  }
}
