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
import org.testng.annotations.Test;

public class ProductTests extends BaseClass{
	
	//1) Test to retrieve all products
	@Test
	public void testGetAllProducts() 
	{
		given()
		
		.when()
			.get(Routes.GET_ALL_PRODUCTS)
		.then()
			.statusCode(200)
			.body("size()", greaterThan(0));
	}
	
	
	//2) test to retrieve a single product by ID
	@Test
	public void  testGetSingleProductById() 
	{
		int productId =configReader.getIntProperty("productId");
		given()
			.pathParam("id", productId)
			
		.when()
			.get(Routes.GET_PRODUCT_BY_ID)
		.then()
			.statusCode(200)
			.log().body();
		//	.body("size()", greaterThan(0));
	}
	
	//3)Test to retrieve  limited number of  products
	@Test
	public void testGetProductsWithLimt() {
		given()
			.pathParam("limit", 3)
		.when()
			.get(Routes.GET_PRODUCTS_WITH_LIMIT)
		.then()
			.statusCode(200)
			.body("size()", equalTo(3))
			.log().body();
	}
	
	//4)test to retrieve and sort in descendning order
	@Test
	public void testGetSortedProductsDescending() 
	{
		 Response response =
		given()
			.pathParam("order", "desc")
		.when()
			.get(Routes.GET_PRODUCT_SORTED)
		.then()
			.statusCode(200)
			.extract().response();
		 
		List<Integer> productsIds= response.jsonPath().getList("id", Integer.class);
		assertThat(isListSortedDescendingOrder(productsIds), is(true));
	}
	
	//5)test to retrieve and sort in ascendning order
	@Test
	public void testGetSortedProductsAsceding() 
	{
		 Response response =
		given()
			.pathParam("order", "asc")
		.when()
			.get(Routes.GET_PRODUCT_SORTED)
		.then()
			.statusCode(200)
			.extract().response();
		 
		List<Integer> productsId= response.jsonPath().getList("id", Integer.class);
		assertThat(isListSortedAscendingOrder(productsId), is(true));
	}
	
	//6) test to retrieve prodcts by all categories
	@Test
	public void testGetAllProductsCategories() 
	{
		given()
		
		.when()
			.get(Routes.GET_ALL_CATEGORIES)
		.then()
			.statusCode(200)
			.body("size()", greaterThan(0));
	}
	
	//7) test to retrieve product by category
	@Test
	public void testGetProductByCategory() 
	{
		given()
		.pathParam("category", "electronics")
		.when()
			.get(Routes.GET_PRODUCTS_BY_CATEGORY)
		.then()
			.statusCode(200)
			.body("size()", greaterThan(0))
			.body("category", everyItem(notNullValue()))  // verify category is not null in all products retrieved
			.body("category", everyItem(equalTo("electronics"))); // verify category equal to electronics in all products retrieved

	}
	
	//8) test to create product
	@Test
	public void testAdddNewProduct() 
	{
		Product newPorduct =Payloads.productPayload();
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
	
	//9) test to update product
	@Test
	public void testUpdateproduct() {
			 Product updatedPayload = Payloads.productPayload();
			given()
				.contentType(ContentType.JSON)
				.body(updatedPayload)
				.pathParam("id", configReader.getIntProperty("productId"))
			.when()
				.put(Routes.UPDATE_PRODUCT)
			.then()
				.log().body()
				.statusCode(200)
				.body("title", equalTo(updatedPayload.getTitle()));
	}
	
	//10 test to delete product
	@Test
	public void tetsDeleteProduct() {
		given()
			.pathParam("id", configReader.getIntProperty("productId"))	
		.when()
			.delete(Routes.DELETE_PRODUCT)
		.then()
			.statusCode(200)
			.log().body();
	}
	
}
