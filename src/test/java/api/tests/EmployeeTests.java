package api.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.ClientEndPoints;
import api.payloads.Employee;
import io.restassured.response.Response;

public class EmployeeTests {
	
	
	Faker fake;
	Employee emppayload;
	public Logger logger;
	
	@BeforeClass
	public void setUpData()
	{
		fake = new Faker();
		emppayload = new Employee();
		emppayload.setId(fake.number().digit());
		emppayload.setName(fake.name().fullName());
		emppayload.setFt(false);
		emppayload.setSex("Female");
		emppayload.setSalary(700.99);
		String[] dod = {"DR","RD"};
		emppayload.setShifttype(dod);
		logger = LogManager.getLogger(this.getClass());
		
	}
	@Test(priority = 1)
	public void testPostUser()
	{ 
		logger.info("**********User Creation-Start**********");
		Response res = ClientEndPoints.createUser(emppayload);
		Assert.assertEquals(res.getStatusCode(), 201);
		System.out.println(res.getBody().asPrettyString());
		logger.info("**********User Creation-End**********");
	}
	
	@Test(priority = 2)
	public void testgetUser()
	{
		logger.info("**********User Retrive-Start**********");
		Response res = ClientEndPoints.retriveUser(this.emppayload.getId());
		Assert.assertEquals(res.getStatusCode(), 200);
		System.out.println(res.getBody().asPrettyString());
		logger.info("**********User Retrive-End**********");
	}
	
	@Test(priority = 3)
	public void testPutUser()
	{
		logger.info("**********User Modification-Start**********");
		emppayload.setFt(true);
		Response res = ClientEndPoints.updateUser(emppayload, this.emppayload.getId());
		Assert.assertEquals(res.getStatusCode(), 200);
		System.out.println(res.getBody().asPrettyString());
		logger.info("**********User Modification-End**********");
	}
	
	@Test(priority = 4)
	public void testDeleteUser()
	{
		logger.info("**********User Deletion-Start**********");
		Response res = ClientEndPoints.deleteUser(this.emppayload.getId());
		Assert.assertEquals(res.getStatusCode(), 200);
		System.out.println(res.getBody().asPrettyString());
		logger.info("**********User Deletion-End**********");
	}
	


}
