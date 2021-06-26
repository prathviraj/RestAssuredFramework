package Project;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestCalls {
	
	public static Response getRequest(String URI)
	{
		
		RequestSpecification requestspecification = RestAssured.given();
		requestspecification.contentType(ContentType.JSON);
		Response response = requestspecification.get(URI);
		return response;
	}
	
	public static Response getRequestwithheader(String URI, String accessToken)
	{
		
		RequestSpecification requestspecification = RestAssured.given();
		requestspecification.contentType(ContentType.JSON);
		requestspecification.header("Authorization","bearer "+accessToken);
		Response response = requestspecification.get(URI);
		return response;
	}
	
	public static Response postRequest(String URI, String strJson)
	{
		
		RequestSpecification requestspecification = RestAssured.given().body(strJson);
		requestspecification.contentType(ContentType.JSON);
		Response response = requestspecification.post(URI);
		return response;
	}
		
	
	public static Response putRequest(String URI, String strJson)
	{
		
		RequestSpecification requestspecification = RestAssured.given().body(strJson);
		requestspecification.contentType(ContentType.JSON);
		Response response = requestspecification.put(URI);
		return response;
	}
	
	public static Response DeleteRequest(String URI, String strJson)
	{
		
		RequestSpecification requestspecification = RestAssured.given().body(strJson);
		requestspecification.contentType(ContentType.JSON);
		Response response = requestspecification.delete(URI);
		return response;
	}
	
	public static Response DeleteRequestwithheader(String URI, String accessToken)
	{
		
		RequestSpecification requestspecification = RestAssured.given();
		requestspecification.contentType(ContentType.JSON);
		requestspecification.header("Authorization","bearer " + accessToken).log().all();
		Response response = requestspecification.delete(URI);
		return response;
	}
}
