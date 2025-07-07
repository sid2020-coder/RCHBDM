package apiDataDrivenTesting;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.annotations.Test;

public class DataDrivenTesting {

	private static final String AUTH_TOKEN = "Bearer cc3921bcd425129b1cc1bdd4b01fd544c27b842f01c188e8f3453c96a9126542";
	private static final String BASE_URL = "https://simple-books-api.glitch.me/orders";
	@Test(dataProvider="ExceldataProvider",dataProviderClass=DataProviders.class)
	public void testwithExceldata(String bookId,String customerName) {
		
		testSubmitandDeleteOrder(bookId,customerName);
	}
	
	
public void testSubmitandDeleteOrder(String bookId, String customerName) {
	JSONObject requestBody = new JSONObject();
	requestBody.put("bookId", Integer.parseInt(bookId) );
	requestBody.put("customerName", customerName);
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
