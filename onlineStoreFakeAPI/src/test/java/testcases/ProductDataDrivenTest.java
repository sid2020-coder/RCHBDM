package testcases;

import pojo.Product;
import routes.Routes;
import utils.ConfigReader;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payloads.Payloads;
import org.testng.ITestContext;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;


public class ProductDataDrivenTest extends BaseClass
{
	@Test(dataProvider = "jsonDataProvider" , dataProviderClass = utils.DataProviders.class)
	public void testAddnewProduct(Map<String,String> data) {
		
		String title = data.get("title");
		double price = Double.parseDouble(data.get("price"));
		String category = data.get("category");
		String description = data.get("description");
		String image = data.get("image");
		
		Product newPorduct = new Product(title, price, description, image, category);
		int productId =
		given()
			.contentType(ContentType.JSON)
			.body(newPorduct)
		.when()
			.post(Routes.CREATE_PRODUCT)
		.then()		
			.log().body()
			.statusCode(200)
			.body("id", notNullValue())
			.body("title", equalTo(newPorduct.getTitle()))
			.extract().jsonPath().getInt("id"); // extracting id from response body
			
		System.out.println(productId);
	}
}
