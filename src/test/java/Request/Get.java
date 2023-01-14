package Request;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Get  {
	Response response;
	public void getProgram() {
		
	RequestSpecification rs = RestAssured.given();
	 response = rs.when().get("/allPrograms");
	System.out.println(response);
	System.out.println("Response Body is =>  " + response.asString());
	}
}
