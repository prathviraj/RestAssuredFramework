package Project;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.annotations.Test;

import org.testng.annotations.Test;

import Utility.Payloadconvertor;
import Utility.URL;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class BaseTest {
	
	static Response response;
	
	@Test
	public static String Login() throws IOException
	{
		String endpointurl = URL.getEndpoint("/user/login");
		String Logingpaylod = Payloadconvertor.genericpayloadstring("Login.json");
				
		response = RestCalls.postRequest(endpointurl, Logingpaylod);
		String res = response.getBody().asString();
		
		//convert to json
		JsonPath jsonres = new JsonPath(res);
		String accesstoken = jsonres.getString("accessToken");
		System.out.println(accesstoken);
		return accesstoken;
		
	}

}
