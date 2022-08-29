package RestAssured.Test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class loginTest {
	
	public String token;
  
	
	@Test	
	public void Login_req()
	{
		RestAssured.baseURI = "https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net";
		Response response = RestAssured.given().header("content-type", "application/json").when().body("{\"username\": \"mithun@ta.com\", \"password\": \"mithun\"}").post("/login").andReturn();
		System.out.println(response.asString());
		
		if(response.statusCode()==201)
		{
			token = response.jsonPath().get("userid").toString().replaceAll("\\[","").replaceAll("]", "");
			System.out.println(token);

		}
		else
		{
			System.out.println("token couldn't found");
		}
		
		assertThat("Should match the status code", (response.getStatusCode()==201));
		
		
	}
	
	
	

	@Test(dependsOnMethods = "Login_req")
	public void addData()
	{
		RestAssured.baseURI = "https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net";
		Response response = RestAssured.given().header("Content-Type", "application/json").header("token", token).when().body("{\"accountno\" : \"TA-8888888\", \"departmentno\": \"8\", \"salary\": \"88888\", \"pincode\": \"123123\"}\r\n"
				+ "").post().andReturn();
		System.out.println(response.asString());

	}

}
