/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import io.restassured.RestAssured.*;
import io.restassured.internal.path.json.JSONAssertion;
import io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.hasSize;

import org.hamcrest.Matchers.*;
import org.json.JSONObject;
import org.junit.*;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 *
 * @author Jonny
 */
public class RestClient {
 
    public void RestClient()
    {    	
        
    }
    
    public Response makeRequest(String httpMethod, String endpointName, String body)
    {
        Response response = null;
        switch(httpMethod)
        {
            case "get":
                response = getRequest(endpointName);
                break;
            
            case "post":
                response = postRequest(endpointName, body);
                break;
                
            case "put":
                response = putRequest();
                break;
                
            case "delete":
                response = deleteRequest();
                break;
        }               
        return response;
    }
    
    public Response getRequest(String endpointName)
    {
        Response response = get(endpointName);
        return response;
    }
    
    public Response postRequest(String endpointName, String body)
    {

    
    		JsonParser parser = new JsonParser();
    		JsonObject o = parser.parse(body).getAsJsonObject();
        	System.out.print(o);
            Response response =
                    given().log().all()
            		.contentType("application/json")
            		.body(o)
            		.when()
            		.post(endpointName);
                    return response;
    
    }
    
    public Response putRequest()
    {
        Response response = null;
        return response;
    }
    
    public Response deleteRequest()
    {
        Response response = null;
        return response;
    }
}
