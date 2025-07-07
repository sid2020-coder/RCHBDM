package testcases;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.List;

import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import routes.Routes;
import utils.ConfigReader;

public class BaseClass {
	
	ConfigReader configReader;
	RequestLoggingFilter	requestLoggingFilter;
	ResponseLoggingFilter responseLoggingFilter;
	@BeforeClass
	public void setup() throws FileNotFoundException {
		RestAssured.baseURI=Routes.Base_URL;
		configReader =  new ConfigReader();
		
		
		//setup filters for logging
		FileOutputStream fos = new FileOutputStream(".\\logs\\test_logfile.txt");
		PrintStream log = new PrintStream(fos);
		requestLoggingFilter = new RequestLoggingFilter(log);
		responseLoggingFilter = new ResponseLoggingFilter(log);
		
		RestAssured.filters(requestLoggingFilter,responseLoggingFilter);
	}
	
	//common/ helper method to check if a list is sorted in descending order
	boolean isListSortedDescendingOrder(List<Integer> list)
	{
		
		for(int i=0;i<list.size()-1;i++) {
			if(list.get(i)<list.get(i+1)) {
				return false;
			}
		}
		
		return true;
		
	}
	//helper method to check if a list is sorted in ascending order
	boolean isListSortedAscendingOrder(List<Integer> list)
	{
		
		for(int i=0;i<list.size()-1;i++) {
			if(list.get(i)>list.get(i+1)) {
				return false;
			}
		}
		
		return true;
		
	}
}
