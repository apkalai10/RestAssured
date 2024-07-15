package api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.ClientEndPoints;
import api.payloads.Employee;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDTest {
	
	Employee emppay;
	
	@Test(priority = 1,dataProvider = "rawData",dataProviderClass = DataProviders.class)
	public void postUser(String id,String name,String ft,String sex, String salary, String shifttype0, String shifttype1)
	{
		
		  emppay = new Employee(); 
		  emppay.setId(id); 
		  emppay.setName(name);
		  emppay.setFt(Boolean.parseBoolean(ft)); 
		  emppay.setSex(sex); 
		  emppay.setSalary(Double.parseDouble(salary)); 
		  String[] dod = {shifttype0,shifttype1}; 
		  emppay.setShifttype(dod); 
		  Response res = ClientEndPoints.createUser(emppay);
		  
		  System.out.println(res.getBody().asPrettyString());
		 
		
	}
	
	@Test(priority = 2,dataProvider = "rawData",dataProviderClass = DataProviders.class)
	public void deleteUser(String id,String name,String ft,String sex, String salary, String shifttype0, String shifttype1)
	{
		Response res = ClientEndPoints.deleteUser(id);
		Assert.assertEquals(res.getStatusCode(), 200);
		System.out.println(res.getBody().asPrettyString());
	}

}
