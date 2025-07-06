package demo;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.PayLoad1;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GraphQL {
 
	public static void main(String[] args) {
	
		//mutation response
		String repsonse=
		given().log().all().header("Content-Type","application/json")
		.body("\r\n"
				+ "{\"query\":\"mutation ($locationName: String!,$characterName: String!,$episodeName: String!)\\n{\\n  \\n  createLocation(location: {name: $locationName,type: \\\"south\\\",dimension: \\\"1232\\\"})\\n  {\\n    id\\n  }\\n  \\n  createCharacter(character: {name:$characterName,type:\\\"comedy\\\",status:\\\"alive\\\",species:\\\"fantacy\\\",gender:\\\"male\\\",image:\\\"png\\\",originId:22276,locationId:22276})\\n  {\\n    id\\n  }\\n  createEpisode(episode: {name:$episodeName,air_date:\\\"09-09-2020\\\",episode:\\\"adventures\\\"})\\n  {\\n    id\\n  }\\n\\n}\",\"variables\":{\"locationName\":\"India\",\"characterName\":\"ajit kumar s\",\"episodeName\":\"avenger\"}}")
		.when().post("https://rahulshettyacademy.com/gq/graphql")
		.then().extract().response().asString();
		
		System.out.println(repsonse);
		
		//query
		
		String repsonse1=
				given().log().all().header("Content-Type","application/json")
				.body("\r\n"
						+ "{\"query\":\"query($characterId: Int!, $episodeId: Int! ){\\n  \\n  character(characterId: $characterId)\\n  {\\n    name\\n    type\\n  }\\n  episode(episodeId: $episodeId){\\n   \\n    name\\n    air_date\\n  }\\n  \\n}\",\"variables\":{\"characterId\":15796,\"episodeId\":15295}}")
				.when().get("https://rahulshettyacademy.com/gq/graphql")
				.then().extract().response().asString();
				
				System.out.println(repsonse1);
		
	}
	
	
	
}
