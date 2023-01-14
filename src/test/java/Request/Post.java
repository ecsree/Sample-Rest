package Request;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Post {

	public void createProgram() {
		//RestAssured.baseURI="https://lms-backend-service.herokuapp.com/lms/";
		String payload  ="{\r\n"
				+ "\"programName\": \"SDET566\",\r\n"
				+ "\"programDescription\": \"Learn SDET\",\r\n"
				+ "\"programStatus\": \"Active\",\r\n"
				+ "\"creationTime\": \"2023-01-07T04:13:00.000+00:00\",\r\n"
				+ "\"lastModTime\": \"2023-01-07T04:13:00.000+00:00\"\r\n"
				+ "}";
		RequestSpecification httprequest= RestAssured.given();
		httprequest.header("Content-Type","application/json");
		Response respon=httprequest.body(payload).post("/saveprogram");
		int statuscode=respon.getStatusCode();
		System.out.println("Responce status code is:"+statuscode);
		
	}
}
