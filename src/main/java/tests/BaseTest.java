package tests;


import org.testng.annotations.*;

import Utils.RestClient;

public class BaseTest {
	protected static RestClient client;
	
	//For each test, client instance is created
	//This is useful for expanding tests beyond smoke tests
	@BeforeTest
	public void setup() {
		client = new RestClient();
	}
}
