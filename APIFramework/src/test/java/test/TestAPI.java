package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Project.ValAssertion;
import Project.BaseTest;
import Project.RestCalls;
import Utility.TestUtil;
import Utility.URL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TestAPI {
	
	public String accesstoken;
	public String id;
	Response response;
	@BeforeTest
	public void setup() throws IOException
	{
		accesstoken = BaseTest.Login();		
	}
	
	@Test(priority=0)
	public void getallusers()
	{
		String endpointurl = URL.getEndpoint("/user");
		
		response = RestCalls.getRequestwithheader(endpointurl, accesstoken);
		
		String res = TestUtil.getresponsestring(response);
		JsonPath jsonres = TestUtil.jsonparser(res);
		System.out.println(res);
		
		String id = jsonres.getString("users[2]._id");
		System.out.println(id);
		
		ValAssertion.verifystatuscode(response, 200);		
	}
	
	@Test(dependsOnMethods="getallusers")
	public void deleteUser()
	{
		
		//when i try to delete with id gives null , so trying to fetch and delete in same method
		//check with sunil on this
		
		String geturl = URL.getEndpoint("/user");
		
		response = RestCalls.getRequestwithheader(geturl, accesstoken);
		
		String res = TestUtil.getresponsestring(response);
		JsonPath jsonres = TestUtil.jsonparser(res);
		
		String id1 = jsonres.getString("users[2]._id");
		ValAssertion.verifystatuscode(response, 200);
		
		//Delete method		
		String endpointurl = URL.getEndpoint("/user/" +id1);
		
		response = RestCalls.DeleteRequestwithheader(endpointurl, accesstoken);
		
		String res1 = TestUtil.getresponsestring(response);
		
		ValAssertion.verifystatuscode(response, 200);
	}

}
