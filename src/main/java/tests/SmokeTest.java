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
		 //Use this method to see if the API is available, making a simple GET request, and using the 200
		 res = client.makeRequest("get", "https://jsonplaceholder.typicode.com/posts", "");
		 assertThat(res.getStatusCode(), is(equalTo(200)));
	}
	
	@Test(dataProvider = "Test Cases", dataProviderClass = TestCaseProvider.class)
	public void postTests(String httpMethod, String endPointName, String body) {
		Response res = null;
		//Send contents from data provider to the API, using the RestClient instance
		//Also use Response to get status code, to determine success or failure
		res = client.makeRequest(httpMethod, endPointName, body);
		
		//Used to determine expected status code from API
		if (httpMethod.equals("post"))
		{
			//In these tests, only value expected to return 201 is http POST
			assertThat(res.getStatusCode(), is(equalTo(201)));
		}
		else
		{
			//All other tests are expected to return status code 200
			assertThat(res.getStatusCode(), is(equalTo(200)));
		}
		
	}
	
}
