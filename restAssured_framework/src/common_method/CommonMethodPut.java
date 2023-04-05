package common_method;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;

public class CommonMethodPut
{
public static int responseStatuscode_Extractor(String baseuri,String resource, String requestBody)
	
	{
		// Declare base URI through arguments
	   RestAssured.baseURI=baseuri;
				
		// Configure and return the status code
		int responseStatuscode =given().header("Content-Type","application/json").body(requestBody).when().put(resource)
					.then().extract().statusCode();
		return responseStatuscode;
	}

public static String responseBodyExtractor(String baseuri,String resource, String requestBody)

{
	// Declare base URI through arguments
		RestAssured.baseURI=baseuri;
			
	// Configure and return the response body
		String responseBody =given().header("Content-Type","application/json").body(requestBody).when().put(resource)
				.then().extract().response().asString();
		return responseBody;
}

}
