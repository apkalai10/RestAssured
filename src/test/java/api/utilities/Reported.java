package api.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reported implements ITestListener {
	
	ExtentReports extent; 
	ExtentSparkReporter spartRep;
	ExtentTest test;
	
	public void onStart(ITestContext context)
	{
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName = "Test-Report-"+timestamp+".html";
		spartRep = new ExtentSparkReporter(".\\Reports\\"+repName);
		
		spartRep.config().setDocumentTitle("RestAssuredAutomation Report");
		spartRep.config().setReportName("Employee API");
		spartRep.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(spartRep);
		extent.setSystemInfo("Application", "EMS");
		extent.setSystemInfo("OS", System.getProperty("os.name"));
		extent.setSystemInfo("username",System.getProperty("user.name"));	
	}
	public void onTestSuccess(ITestResult result) {
		
		 test = extent.createTest(result.getName());
		 test.createNode(result.getName());
		 test.assignCategory(result.getMethod().getGroups());
		 test.log(Status.PASS, "Test Pass");
	
		
		  
		  }
	public void onTestFailure(ITestResult result) {
		 test = extent.createTest(result.getName());
		 test.createNode(result.getName());
		 test.assignCategory(result.getMethod().getGroups());
		 test.log(Status.FAIL, "Test Failed");
		 test.log(Status.FAIL, result.getThrowable().getMessage());
		  }
	public void onTestSkipped(ITestResult result) {
		 test = extent.createTest(result.getName());
		 test.createNode(result.getName());
		 test.assignCategory(result.getMethod().getGroups());
		 test.log(Status.SKIP, "Test Failed");
		 test.log(Status.SKIP, result.getThrowable().getMessage());
		  }
	public void onFinish(ITestContext context) {
		  extent.flush();
		  }
}
