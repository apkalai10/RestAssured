package api.utilities;

import java.io.IOException;
import java.util.Arrays;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviders {
	
	
	
	@DataProvider(name = "rawData")
	public String[][] getAllData() throws IOException
	{
		String path = "C:\\Users\\aravi\\eclipse-workspace\\RestAssured\\Documents\\sample.xlsx";
		//String path = System.getProperty("user.dir")+"//Documents//sample.xlsx";
		XlxUtility xlfile = new XlxUtility(path);
		int rownum = xlfile.getRowCount("Sheet1");
		int colcount = xlfile.getCellCount("Sheet1", 1);
		String[][] apidata = new String[rownum][colcount];
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				apidata[i-1][j]=	xlfile.getCellData("Sheet1", i, j);
				
			}
		}
		return apidata;
		
	}

}
