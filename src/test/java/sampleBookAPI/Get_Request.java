package sampleBookAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Get_Request {

	@Test
	public void Get_ListofBooks()
	{
		RestAssured.baseURI = "https://simple-books-api.glitch.me";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		Response response = httpRequest.request(Method.GET,"/books");
		
		String responseBody = response.getBody().asString();
		
		System.out.println("=> Status Code is: "+response.statusCode());
		
		System.out.println("=> Response body  is : \n"+responseBody );
		
		JsonPath jsonpath = response.jsonPath();
		
		System.out.println("=> Get all the names in json format: "+jsonpath.get("name"));
		
		System.out.println("=> Get only first name in json format: "+jsonpath.get("name[0]"));
		
		Assert.assertEquals(responseBody.contains("The Russian"), true);
		
		System.out.println("=> Response in pretty string format : "+ response.asPrettyString());
		
		//Assert.assertEquals(jsonpath.get("name"), "The Russian");
		
	}
}
