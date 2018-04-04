package models;

//Container class, used as model for test case to be worked from
public class TestCase {
	
	//return HTTP method
	public String getHttpMethod() {
		return httpMethod;
	}

	//set test case HTTP method
	public void setHttpMethod(String httpMethod) {
		this.httpMethod = httpMethod;
	}

	//get URL of API call
	public String getEndPointName() {
		return endPointName;
	}

	//set URL of API call for test case
	public void setEndPointName(String endPointName) {
		this.endPointName = endPointName;
	}

	//get body of request
	public String getBody() {
		return body;
	}

	//set body of request
	public void setBody(String body) {
		this.body = body;
	}

	private String httpMethod;
	private String endPointName;
	private String body;
	
	//Constructor
	public TestCase()
	{
		
	}
	
	
}
