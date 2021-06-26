package Utility;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TestUtil {
	
	public static String getresponsestring(Response response)
	{
		String res = response.getBody().asString();
		return res;
	}

	public static JsonPath jsonparser(String response)
	{
		JsonPath jsonres = new JsonPath(response);
		return jsonres;
	}
	
	public static int getstatuscode(Response response)
	{
		int status = response.getStatusCode();
		return status;
	}
	
	public static String getstatusmessage(Response response)
	{
		String message = response.getStatusLine();
		return message;
	}
}
