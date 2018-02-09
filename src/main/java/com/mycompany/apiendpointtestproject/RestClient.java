/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apiendpointtestproject;

import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.hasSize;

import org.hamcrest.Matchers.*;
import org.junit.*;

/**
 *
 * @author Jonny
 */
public class RestClient {
 
    public void RestClient()
    {    	
        
    }
    
    public Response makeRequest(String httpMethod, String endpointName)
    {
        Response response = null;
        switch(httpMethod)
        {
            case "get":
                response = getRequest(endpointName);
                break;
            
            case "post":
                response = postRequest();
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
    
    public Response postRequest()
    {
        Response response = null;
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
