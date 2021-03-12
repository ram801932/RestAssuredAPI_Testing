package request;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
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
		
		//System.out.println("Response body  is : \n"+responseBody );
		System.out.println(response.asString());
		
	}
}
