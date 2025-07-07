package apiDataDrivenTesting;


import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.json.JSONObject;
import org.testng.ITestContext;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import java.util.List;
import org.testng.annotations.Test;
public class SubmitOrder {
		
	private static final String AUTH_TOKEN = "Bearer cc3921bcd425129b1cc1bdd4b01fd544c27b842f01c188e8f3453c96a9126542";
	private static final String BASE_URL = "https://simple-books-api.glitch.me/orders";
	@Test
	void SubmitOrderDeleteOrder() {
		
		JSONObject requestBody = new JSONObject();
		requestBody.put("bookId", 1);
		requestBody.put("customerName", "John");
		//submit
		String orderID=
		given()
			.contentType("application/json")
			.header("Authorization",AUTH_TOKEN)
			.body(requestBody.toString())
		.when()
			 .post(BASE_URL)
		.then()
			.log().body()	
			.extract().jsonPath().getString("orderId");
		System.out.println("OrderId is :"+orderID);
		
		//delete 
		given()
			.header("Authorization",AUTH_TOKEN)
			.pathParam("orderId", orderID)
		.when()
			.delete(BASE_URL+"/{orderId}")
		.then()
			.statusCode(204);
			
		
		
	}
}
