package testNGsample;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Day2 {


	@Test(groups={"smoke"})
	public void webLoginHomeLoan() {
		System.out.println("webLoginHomeLoan");
	}
	
	@Test
	public void mobileLoginHomelaon() {
		System.out.println("mobileLoginHomelaon");
	}
	
	@Test
	public void apiLoginHomeLaon() {
		System.out.println("apiLoginHomeLaon");
	}
}
