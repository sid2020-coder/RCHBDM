	package payloads;

import java.util.Random;

import org.codehaus.groovy.runtime.GroovyCategorySupport.CategoryMethodList;

import com.github.javafaker.Faker;

import pojo.Product;
public class Payloads {
	
	private static final  Faker faker = new Faker();
	private static final String catageries[]= {"electronics","furniture","clothing","books","beauty"};
	
	private static final Random random = new Random();
	
	//Product pay-load using faker library
	public static Product productPayload() 
	{
		String name = faker.commerce().productName();
		double price = Double.parseDouble(faker.commerce().price());
		String description = faker.lorem().sentence();
		String imageUrl= "https://i.pravatar.cc/100";
		String category = catageries[random.nextInt(catageries.length)];
		return new Product(name,price,description,imageUrl,category);
	}
	
	//cart
	//user
	//login

}
