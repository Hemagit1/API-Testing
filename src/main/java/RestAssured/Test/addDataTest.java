package RestAssured.Test;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import techark.reusable.login_utils;

public class addDataTest {
	
	
	String token;
	
	@BeforeClass
	public void setup() {
		
	}
	
	@Test
	public void addData()
	{
		login_utils lu =  new login_utils();
		HashMap<String, String> header = new HashMap();
		header.put("token", token);
		header.put("content-Type", "application/json");
	
		String body = "{\"username\": \"mithun@ta.com\", \"password\": \"mithun\"}";
		
		lu.tech_post("/login", header, body);
		
	}
	

}
