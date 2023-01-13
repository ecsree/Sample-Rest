package api;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class testSteps {
	private static final String BASE_URL = "https://lms-backend-service.herokuapp.com/lms"; 
	private static Response response;
	private static String jsonString;
	private static String programId;
	
	@Given("list of batch is available")
	public void list_of_batch_is_available() {
		
		RestAssured.baseURI = BASE_URL;
		RequestSpecification request = RestAssured.given();
		response = request.get("/batches");
		jsonString = response.asString();
		List<Map<String, String>> batches = JsonPath.from(jsonString).get("books");
		Assert.assertTrue(batches.size()>0);
		//programId = batches.get(0).get("190");
	    
	}

	@When("I send a request with programId")
	public void i_send_a_request_with_program_id() {
		RestAssured.baseURI = BASE_URL;
		RequestSpecification request = RestAssured.given();
		response = request.get("/batches/program/(ProgramId)");
		jsonString = response.asString();
		List<Map<String, String>> batches = JsonPath.from(jsonString).get("batches");
		//Assert.assertTrue(batches.size()>0);
	    
	}

	@Then("the batch details shoulde be displayed")
	public void the_batch_details_shoulde_be_displayed() {
	    //BASE_URL.assertEquals(200, response.getStatusCode());
	    System.out.println(response.getStatusCode());
	}

@Given("API url {string}")
public void api_url(String string) {
    
}

@When("Authorized  user create a program")
public void authorized_user_create_a_program() {
   
}

@Then("Validate the Program is added")
public void validate_the_program_is_added() {
    
}

}
