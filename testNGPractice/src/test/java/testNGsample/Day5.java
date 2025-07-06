package testNGsample;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Day5 {

	//@Test(dependsOnMethods = "demo1")
	@Test(priority = 3)
	public void web() {
		System.out.println("web");
	}
	
	@Test(priority = 2)
	public void Api() {
		System.out.println("Api");
	}
	@Test(invocationCount = 3)
	public void demo1() {
		System.out.println("demo1");
	//	Assert.assertTrue(false);
	}
}
