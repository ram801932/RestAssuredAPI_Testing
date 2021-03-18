package sampleBookAPI;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class GetAllHeaders {

	@Test
	public void GetHeaders()
	{
	   RestAssured.baseURI = "https://simple-books-api.glitch.me";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		Response response = httpRequest.request(Method.GET,"/status");
		
		System.out.println("=> Get all headers :\n"+response.getHeaders());
		
		System.out.println("=> Get header value of  \"Content-Type\" : "+ response.getHeader("Content-Type"));
	}
}
