package Request;

import org.junit.Assert;

import io.restassured.response.Response;

public class Validate {
	
	
	Response response;
	 int actualresponseCode;
	 
	public void validation() {
		actualresponseCode = response.then().extract().statusCode();
		Assert.assertEquals(200, actualresponseCode);
	}

}
