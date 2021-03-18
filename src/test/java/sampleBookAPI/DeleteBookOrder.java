package sampleBookAPI;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class DeleteBookOrder {

	@Test
	public void DelBookOder() {
		RestAssured.baseURI = "https://simple-books-api.glitch.me";

		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.header("Authorization", "Bearer 8c7c1522a39ac12b0cc67ac08f1f5c36b14ad2aab04d120d2b51a2c426040d1a");
		
		Response response = httpRequest.request(Method.DELETE,"/orders/qWf0jP9GPEUhD7zsH-aWC");
		
		Assert.assertEquals(204,response.statusCode());
		
		System.out.println("=> Response body is : \n"+response.getBody().asPrettyString());
		
	}
}
