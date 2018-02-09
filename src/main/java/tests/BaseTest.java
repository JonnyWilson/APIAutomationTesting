package tests;


import org.testng.annotations.*;

import Utils.RestClient;

public class BaseTest {
	protected static RestClient client;
	
	@BeforeTest
	public void setup() {
		client = new RestClient();
	}
}
