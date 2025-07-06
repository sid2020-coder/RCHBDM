package files;

public class PayLoad1 {

	public static String addPayload() {
		
		return "{\r\n"
				+ "  \"location\": {\r\n"
				+ "    \"lat\": -38.383494,\r\n"
				+ "    \"lng\": 33.427362\r\n"
				+ "  },\r\n"
				+ "  \"accuracy\": 50,\r\n"
				+ "  \"name\": \"Frontline house\",\r\n"
				+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
				+ "  \"address\": \"29, side layout, cohen 09\",\r\n"
				+ "  \"types\": [\r\n"
				+ "    \"shoe park\",\r\n"
				+ "    \"shop\"\r\n"
				+ "  ],\r\n"
				+ "  \"website\": \"http://google.com\",\r\n"
				+ "  \"language\": \"French-IN\"\r\n"
				+ "}";
	}
	
	public static String coursesPrice() {
		
		return "{\r\n"
				+ "\"dashboard\": {\r\n"
				+ "\"purchaseAmount\": 910,\r\n"
				+ "\"website\": \"rahulshettyacademy.com\"\r\n"
				+ "},\r\n"
				+ "\"courses\": [\r\n"
				+ "{\r\n"
				+ "\"title\": \"Selenium Python\",\r\n"
				+ "\"price\": 50,\r\n"
				+ "\"copies\": 6\r\n"
				+ "},\r\n"
				+ "{\r\n"
				+ "\"title\": \"Cypress\",\r\n"
				+ "\"price\": 40,\r\n"
				+ "\"copies\": 4\r\n"
				+ "},\r\n"
				+ "{\r\n"
				+ "\"title\": \"RPA\",\r\n"
				+ "\"price\": 45,\r\n"
				+ "\"copies\": 10\r\n"
				+ "}\r\n"
				+ "]\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "";
	}
	
	public static String addBook(String aisle, String isbn) {
		
		String addpayload = "{\r\n"
				+ "\r\n"
				+ "\"name\":\"Learn Appium Automation with Java\",\r\n"
				+ "\"isbn\":\""+isbn+"\",\r\n"
				+ "\"aisle\":\""+aisle+"\",\r\n"
				+ "\"author\":\"John foe\"\r\n"
				+ "}\r\n"
				+ "";
				return addpayload;
	}
	
	public static String issueJiraPayload() {
		
		String issuepayload = "{\r\n"
				+ "\r\n"
				+ "  \"fields\": {\r\n"
				+ "\r\n"
				+ "    \"project\": {\r\n"
				+ "\r\n"
				+ "      \"key\": \"SCRUM\"\r\n"
				+ "\r\n"
				+ "    },\r\n"
				+ "\r\n"
				+ "    \"summary\": \"Dropdowns are not working\",\r\n"
				+ "\r\n"
				+ "    \"description\": {\r\n"
				+ "\r\n"
				+ "      \"type\": \"doc\",\r\n"
				+ "\r\n"
				+ "      \"version\": 1,\r\n"
				+ "\r\n"
				+ "      \"content\": [\r\n"
				+ "\r\n"
				+ "        {\r\n"
				+ "\r\n"
				+ "          \"type\": \"paragraph\",\r\n"
				+ "\r\n"
				+ "          \"content\": [\r\n"
				+ "\r\n"
				+ "            {\r\n"
				+ "\r\n"
				+ "              \"text\": \"Links not workng.\",\r\n"
				+ "\r\n"
				+ "              \"type\": \"text\"\r\n"
				+ "\r\n"
				+ "            }\r\n"
				+ "\r\n"
				+ "          ]\r\n"
				+ "\r\n"
				+ "        }\r\n"
				+ "\r\n"
				+ "      ]\r\n"
				+ "\r\n"
				+ "    },\r\n"
				+ "\r\n"
				+ "    \"issuetype\": {\r\n"
				+ "\r\n"
				+ "      \"name\": \"Bug\"\r\n"
				+ "\r\n"
				+ "    }\r\n"
				+ "\r\n"
				+ "  }\r\n"
				+ "\r\n"
				+ "}";
		return issuepayload;
	}

}
