package api.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payloads.Employee;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ClientEndPoints {
	
	
	
	public static Response createUser(Employee payload)
	{
		Response res = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
		.when()
		.post(Routes.post_url);
		return res;
	}
	
	public static Response retriveUser(String model)
	{
		Response res = given()
			.pathParam("username", model)	
		.when()
		.get(Routes.get_url);
		return res;
	}
	
	public static Response updateUser(Employee payload,String modelname)
	{
		Response res = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username", modelname)
				.body(payload)
		.when()
		.put(Routes.put_url);
		return res;
	}
	
	public static Response deleteUser(String modelname)
	{
		Response res = given()
			.pathParam("username", modelname)	
		.when()
		.delete(Routes.delete_url);
		return res;
	}

}
