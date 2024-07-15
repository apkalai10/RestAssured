package api.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XlxUtility {
	FileInputStream fis;
	Workbook book;
	Sheet sheet;
	Row row;
	Cell cell; 
	
	String path;
	public XlxUtility(String path)
	{
	this.path = path;
	}
	
	public int  getRowCount(String sheetname) throws IOException
	{
		 fis = new FileInputStream(path);
		 book = new XSSFWorkbook(fis);
		 sheet = book.getSheet(sheetname);
		int rowcount = sheet.getLastRowNum();
		book.close();
		fis.close();
		return rowcount;
	}
	
	public int getCellCount(String sheetname,int rownum) throws IOException
	{
		fis = new FileInputStream(path);
		 book = new XSSFWorkbook(fis);
		 sheet = book.getSheet(sheetname);
		 row = sheet.getRow(rownum);
		 int cellcount = row.getLastCellNum();
		 book.close();
		fis.close();
		return cellcount;
	}
	
	public String getCellData(String sheetname, int rownum, int colnum) throws IOException
	{
		fis = new FileInputStream(path);
		 book = new XSSFWorkbook(fis);
		 sheet = book.getSheet(sheetname);
		 row = sheet.getRow(rownum);
		  cell = row.getCell(colnum);
		  
		  DataFormatter formatter = new DataFormatter();
		  String data ;
		  try {
		  data = formatter.formatCellValue(cell);
		  }
		  catch(Exception e)
		  {
			 data  = ""; 
		  }
			 book.close();
			fis.close();
			return data;
	}

}
