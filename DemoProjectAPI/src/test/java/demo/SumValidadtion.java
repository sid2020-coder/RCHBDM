package demo;

import org.testng.Assert;
import org.testng.annotations.Test;

import files.PayLoad1;
import io.restassured.path.json.JsonPath;

public class SumValidadtion {


  @Test
  public void sumofCourses() {
	  JsonPath js1 = new JsonPath(PayLoad1.coursesPrice());
		int count =  js1.getInt("courses.size()");
		int sum = 0;
		for(int i=0;i<count;i++) {
			int price = js1.get("courses["+i+"].price");
			int copies = js1.get("courses["+i+"].copies");
			int total = (price * copies);
			System.out.println(total);
			sum = total +sum;
		}
		System.out.println(sum);
		int purchaseAmount = js1.getInt("dashboard.purchaseAmount");
		Assert.assertEquals(purchaseAmount, sum);
  }
}
