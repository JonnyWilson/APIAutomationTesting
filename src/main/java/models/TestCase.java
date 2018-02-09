package models;

public class TestCase {
	
	public String getHttpMethod() {
		return httpMethod;
	}


	public void setHttpMethod(String httpMethod) {
		this.httpMethod = httpMethod;
	}


	public String getEndPointName() {
		return endPointName;
	}


	public void setEndPointName(String endPointName) {
		this.endPointName = endPointName;
	}


	public String getBody() {
		return body;
	}


	public void setBody(String body) {
		this.body = body;
	}


	private String httpMethod;
	private String endPointName;
	private String body;
	

	public void TestCase()
	{
		
	}
	
	
}
