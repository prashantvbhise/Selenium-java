package common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {

	public static void main(String[] args) throws IOException {
		
		String path= "C:\\Users\\Pooja\\SeleniumClass\\OrangeHRMDemoPom\\TestData.xlsx";
	
		File file = new File(path);
		
		FileInputStream fis= new FileInputStream (file);
		
		XSSFWorkbook excelWorkbook= new XSSFWorkbook(fis);
		
		XSSFSheet sheet = excelWorkbook.getSheet("LoginTestData");
		
		XSSFRow row = sheet.getRow(1);
		
		//System.out.println(row);
		
		XSSFCell cell= row.getCell(0);
		
		System.out.println(cell.getStringCellValue());
		
		System.out.println(row.getLastCellNum()); //No of Columns
		
		//System.out.println(sheet.getLastRowNum()+1); //No of Rows
		
		System.out.println(sheet.getPhysicalNumberOfRows()); //Another way for No of Rows
				

	}

}
