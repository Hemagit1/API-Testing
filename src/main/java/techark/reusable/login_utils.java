package techark.reusable;

import java.util.HashMap;

import com.github.dockerjava.transport.DockerHttpClient.Response;
import com.google.gson.JsonObject;

import io.restassured.RestAssured;

public class login_utils {
	
	
	public io.restassured.response.Response tech_post (String endpoint, HashMap<String, String> header , String body)
	{
		RestAssured.baseURI = "https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net/";
		io.restassured.response.Response response =	RestAssured.given().headers(header).when().body(body).post(endpoint).andReturn();
		return response;
	}
	

	public io.restassured.response.Response tech_post (String endpoint, HashMap<String, String> header , JsonObject body, HashMap<String, String> queryparams)
	{
		io.restassured.response.Response response =	RestAssured.given().headers(header).when().body(body).params(queryparams).post(endpoint).andReturn();
		return response;
	}
	
	public io.restassured.response.Response tech_get (String endpoint, HashMap<String, String> header , String body)
	{
		io.restassured.response.Response response =	RestAssured.given().headers(header).when().body(body).get(endpoint).andReturn();
		return response;
	}
	
	public io.restassured.response.Response tech_delete (String endpoint, HashMap<String, String> header , String body)
	{
		io.restassured.response.Response response =	RestAssured.given().headers(header).when().body(body).delete(endpoint).andReturn();
		return response;
	}
	

}
