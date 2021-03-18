package sampleBookAPI;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostOrderBook {

	@Test
	public void OrderABook() {
		RestAssured.baseURI = "https://simple-books-api.glitch.me";
		
		RequestSpecification httpRequest = RestAssured.given();

		JSONObject jsonobj = new JSONObject();
		jsonobj.put("bookId", 3);
		jsonobj.put("customerName", "Dhanush");

		httpRequest.header("Authorization", "Bearer 8c7c1522a39ac12b0cc67ac08f1f5c36b14ad2aab04d120d2b51a2c426040d1a");
		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(jsonobj.toJSONString());

		Response response = httpRequest.request(Method.POST, "/orders");

		System.out.println("=> Prettyprint Response : \n"+ response.asPrettyString());
		Assert.assertEquals(response.statusCode(), 201);

		Assert.assertEquals(response.statusLine(), "HTTP/1.1 201 Created");

		Assert.assertEquals(response.jsonPath().get("created"), true);

		String payload = "{\r\n" + 
				"    \"created\": true,\r\n" + 
				"    \"orderId\": \"L5Om8fpF32p4wfQlz4z2r\"\r\n" + 
				"}";
		//L5Om8fpF32p4wfQlz4z2r orderId
	}
}
