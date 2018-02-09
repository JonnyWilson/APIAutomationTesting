package tests;

import org.testng.annotations.BeforeSuite;

import com.mycompany.apiendpointtestproject.RestClient;

public class BaseTest {
	protected static RestClient client;
	
	@BeforeSuite
	public void setup() {
		RestClient client = new RestClient();
	}
}
