package api;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import org.json.simple.JSONObject;
import org.junit.Assert;

import Request.Get;
import Request.Post;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;



public class StepDefinition {
	
	
	private static final String BASE_URL = "https://lms-backend-service.herokuapp.com/lms/";
	RequestSpecification request;
	 public Response response;

	private int actualresponseCode;
	public int statuscode;
	
	
	@Given("API url")
	public void api_url() {
	RestAssured.baseURI = BASE_URL;
		
	}

	@When("Authorized User add program")
	public void authorized_user_add_program() {
		
		String payload  ="{\r\n"
				+ "\"programName\": \"API_LEARNER****\",\r\n"
				+ "\"programDescription\": \"Learn SDET\",\r\n"
				+ "\"programStatus\": \"Active\",\r\n"
				+ "\"creationTime\": \"2023-01-07T04:13:00.000+00:00\",\r\n"
				+ "\"lastModTime\": \"2023-01-07T04:13:00.000+00:00\"\r\n"
				+ "}";
		RequestSpecification httprequest= RestAssured.given();
		httprequest.header("Content-Type","application/json");
		Response response=httprequest.body(payload).post("/saveprogram");
		statuscode=response.getStatusCode();
		System.out.println("Responce status code is:"+statuscode);

	}

	@Then("program is added")
	public void program_is_added() {
//		statuscode=response.getStatusCode();
//		System.out.println("Responce status code is:"+statuscode);
//
//		actualresponseCode = response.then().extract().statusCode();
//		Assert.assertEquals(201, actualresponseCode);
	}

	
	@When("user submit get request")
	public void user_submit_get_request() {
		RequestSpecification rs = RestAssured.given();
		 response = rs.when().get("/allPrograms");
		System.out.println(response);
		//System.out.println("Response Body is =>  " + response.asString());
		statuscode=response.getStatusCode();
		System.out.println("Responce status code is:"+statuscode);
	}

	@Then("All programs is displayed")
	public void all_programs_is_displayed() {
		
		//status code validation
		actualresponseCode = response.then().extract().statusCode();
		Assert.assertEquals(200, actualresponseCode);
		//content type validation
		String contentType = response.header("Content-Type"); 
		System.out.println("Content-Type value: " + contentType); 
		Assert.assertEquals("application/json", contentType);

		//validate  servervalue
		String serverType = response.header("Server"); 
		System.out.println("Server value: " + serverType); 
		Assert.assertEquals("Cowboy", serverType);

		//validate stringbody
		ResponseBody body =response.getBody();
		String bodyAsString = body.asString();
		Assert.assertEquals(bodyAsString.contains("API_LEARNER****") /*Expected value*/, true /*Actual Value*/);
	
		
		 Headers allHeaders = response.headers(); 
		 // Iterate over all the Headers 
		 for(Header header : allHeaders) { 
		   System.out.println("Key: " + header.getName() + " Value: " + header.getValue()); 
	}
	}

}
