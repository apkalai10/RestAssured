package api.endpoints;

public class Routes {
	
	
	//https://petstore.swagger.io/v2/user
	//http://localhost:3000/employee
	
	public static String base_url ="http://localhost:3000/employee/";
	
	public static String post_url = base_url;
	public static String get_url = base_url+"{username}";
	public static String put_url = base_url+"{username}";
	public static String delete_url = base_url+"{username}";
	
	

}
