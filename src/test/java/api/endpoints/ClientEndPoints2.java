package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payloads.Employee;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ClientEndPoints2 {
	
	static ResourceBundle getURL()
	{
		ResourceBundle routes = ResourceBundle.getBundle("routes");
		return routes;
	}
	
	public static Response createUser(Employee payload)
	{
		Response res = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
		.when()
		.post(getURL().getString("post_url"));
		return res;
	}
	
	public static Response retriveUser(String model)
	{
		Response res = given()
			.pathParam("username", model)	
		.when()
		.get(getURL().getString("get_url"));
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
		.put(getURL().getString("put_url"));
		return res;
	}
	
	public static Response deleteUser(String modelname)
	{
		Response res = given()
			.pathParam("username", modelname)	
		.when()
		.delete(getURL().getString("delete_url"));
		return res;
	}

}
