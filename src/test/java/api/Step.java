package api;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.json.simple.JSONObject;
import org.jsoup.Connection.Request;
import org.junit.Assert;


import Request.Get;
import Request.Post;
import Request.Validate;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ResponseBodyData;
import io.restassured.response.ResponseBodyExtractionOptions;
import io.restassured.specification.RequestSpecification;

public class Step {

//	private static final String BASE_URL = "https://lms-backend-service.herokuapp.com/lms/";
//	RequestSpecification request;
//	Response response;
//
//	private int actualresponseCode;
//	
//	
//	
//	@Given("API url")
//	public void api_url() {
//	RestAssured.baseURI = BASE_URL;
//		
//	}
//
//	@When("Authorized User add program")
//	public void authorized_user_add_program() {
//		
//		Post p = new Post();
//		p.createProgram();
//
//	}
//
//	@Then("program is added")
//	public void program_is_added() {
//	   
//	}
//
//	
//	@When("user submit get request")
//	public void user_submit_get_request() {
//	   Get g=new Get();
//	   g.getProgram();
//	   
//	}
//
//	@Then("All programs is displayed")
//	public void all_programs_is_displayed() {
////		Validate v=new Validate();
////		v.validation();
//	}
//	
//	

}
