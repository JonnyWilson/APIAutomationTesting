package tests;


import org.testng.annotations.Test;
import io.restassured.response.Response;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;

public class SmokeTest extends BaseTest {

	@Test
	public void checkAPIAvailable() {
		 Response res = null;
		 res = client.makeRequest("get", "https://jsonplaceholder.typicode.com/posts");
		 res.getStatusCode();
		 assertThat(res.getStatusCode(), is(equalTo(200)));
	}
	
}
