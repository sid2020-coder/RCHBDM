package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
public WebDriver driver;

	public void webDriverMgr() {
		driver = new ChromeDriver();
	}
}
