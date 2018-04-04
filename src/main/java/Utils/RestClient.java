/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 *
 * @author Jonny
 */
public class RestClient {
 
	//Constructor
    public RestClient()
    {    	
        
    }
    
    //Method to determine which http verb to use, and call appropriate function
    public Response makeRequest(String httpMethod, String endpointName, String body)
    {
        Response response = null;
        switch(httpMethod)
        {
            case "get":
            	//GET request doesn't take body, given a body is not needed to be sent
                response = getRequest(endpointName);
                break;
            
            case "post":
                response = postRequest(endpointName, body);
                break;
                
            case "put":
                response = putRequest(endpointName, body);
                break;
                
            case "delete":
            	//DELETE request doesn't take body, given a body is not needed to be sent
                response = deleteRequest(endpointName);
                break;
        }               
        return response;
    }
    
    public Response getRequest(String endpointName)
    {
        //Response is returned, once GET request is made
    	Response response = get(endpointName);
        return response;
    }
    
    public Response postRequest(String endpointName, String body)
    {
	    //Response is returned with POST request successful
    	//Parser instantiated to get body as JSON object
		JsonParser parser = new JsonParser();
		JsonObject o = parser.parse(body).getAsJsonObject();
        //Then Response is created from request, and is also logged to console for analytical purposes
		Response response =
                given().log().all()
        		.contentType("application/json")
        		.body(o)
        		.when()
        		.post(endpointName);
        return response;
    }
    
    public Response putRequest(String endpointName, String body)
    {
    	//Response is returned with PUT request successful
    	//Response is returned with POST request successful
    	//Parser instantiated to get body as JSON object
		JsonParser parser = new JsonParser();
		JsonObject o = parser.parse(body).getAsJsonObject();
		//Then Response is created from request, and is also logged to console for analytical purposes
		Response response =
                given().log().all()
        		.contentType("application/json")
        		.body(o)
        		.when()
        		.put(endpointName);
        return response;
    }
    
    public Response deleteRequest(String endpointName)
    {
    	//Response is returned with DELETE request successful	
    	Response response = delete(endpointName);
        return response;
    }
}
