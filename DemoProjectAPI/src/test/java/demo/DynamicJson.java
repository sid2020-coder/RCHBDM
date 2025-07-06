package demo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.PayLoad1;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class DynamicJson {

@Test(dataProvider ="booksData")
public  void addBook(String isbn, String aisle) {		// add Book --POST
	RestAssured.baseURI = "http://216.10.245.166";
	String response= given().header("Content-Type","application/json")
	.body(PayLoad1.addBook(isbn,aisle))
	.when().post("/Library/Addbook.php")
	.then().assertThat().statusCode(200).extract().response().asString();
	System.out.println(response);
	JsonPath js1 = new JsonPath(response);
	String Id = js1.get("ID");
	System.out.println(Id);
}

@DataProvider
public Object[][] booksData() {
	 return new Object[][] {{"adas","123"},{"sqs","3232"},{"ada","2324"}};
}
	

}
