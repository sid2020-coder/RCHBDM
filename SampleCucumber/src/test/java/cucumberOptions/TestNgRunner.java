package cucumberOptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

	@CucumberOptions(features="src/test/java/faetures",
			glue="stepdefinitions",
			monochrome=true,
			tags="@PlaceOrder or @offersPage",
			plugin={"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
			"rerun:target/failed_scenarios.txt"}
					)
			public class TestNgRunner extends AbstractTestNGCucumberTests {
			
}
