package tests;


import org.testng.annotations.Test;

import data.TestCaseProvider;
import io.restassured.response.Response;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;

public class SmokeTest extends BaseTest {

	@Test
	public void checkAPIAvailable() {
		 Response res = null;
		 res = client.makeRequest("get", "https://jsonplaceholder.typicode.com/posts", "");
		 assertThat(res.getStatusCode(), is(equalTo(200)));
	}
	
	@Test(dataProvider = "Test Cases", dataProviderClass = TestCaseProvider.class)
	public void addNewPost() {
		Response res = null;
		res = client.makeRequest("post", "https://jsonplaceholder.typicode.com/posts", "{\"title\": \"jonnyalexfoo\", \"body\": \"bar\", \"userId\": 5 }");
		System.out.print(res.getBody().asString());
		assertThat(res.getStatusCode(), is(equalTo(201)));
	}
	
}
