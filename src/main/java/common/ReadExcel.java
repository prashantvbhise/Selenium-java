package common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
	private static String path= "C:\\Users\\Pooja\\SeleniumClass\\OrangeHRMDemoPom\\TestData.xlsx";
	private static File file;
	private static FileInputStream fis;
	private static XSSFWorkbook excelWorkbook;
	private static XSSFSheet sheet;
	private static XSSFRow row;
	
	public static void main(String[] args) throws IOException {
		int noOfRows= getNumberOfRows();
		int noOfColoumn= getNumberOfColoumn();
		String[][] loginData= new String[noOfRows][noOfColoumn];
		file = new File(path);
		fis= new FileInputStream (file);
		excelWorkbook= new XSSFWorkbook(fis);
		sheet = excelWorkbook.getSheet("LoginTestData");
		row = sheet.getRow(1);
		
		for (Row myrow : sheet) {
		    for (Cell mycell : myrow) {
		    	
		    	System.out.println(myrow);
		    	System.out.println(mycell);
		    	
		    }
		    
		    }
	}

	private static int getNumberOfColoumn() throws IOException {
		file = new File(path);
		fis= new FileInputStream (file);
		excelWorkbook= new XSSFWorkbook(fis);
		sheet = excelWorkbook.getSheet("LoginTestData");
		return sheet.getRow(1).getLastCellNum();
	}

	private static int getNumberOfRows() throws IOException {
		file = new File(path);
		fis= new FileInputStream (file);
		excelWorkbook= new XSSFWorkbook(fis);
		sheet = excelWorkbook.getSheet("LoginTestData");
		return sheet.getPhysicalNumberOfRows();
	}

}
