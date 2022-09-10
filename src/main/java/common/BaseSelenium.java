package common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;


@Listeners(IInvokedMethodListenerImpl.class)
public class BaseSelenium {
	
	public static String path= "C:\\Users\\Pooja\\SeleniumClass\\Selenium-automation-1-sept\\src\\main\\resources\\testdata.txt";
	
	@DataProvider(parallel = true, name="CSVDataProvider")
	public String[][] getLoginData() throws IOException {
		
		int noOfRows= getNumberOfRows();
		int noOfColoumn= getNumberOfColoumn();
		
		String[][] loginData= new String[noOfRows][noOfColoumn];
		
		File file = new File(path);
		
		FileReader fr = new FileReader(file);
		
		BufferedReader br= new BufferedReader(fr);
		
		String st;
		
		int i=0;
		while((st=br.readLine())!=null) {
			String[] lineArray= st.split(",");
			loginData[i]=lineArray;
			i=i+1;
					
		}return loginData;
				
	}

	private int getNumberOfRows() throws IOException {
		
		File file = new File(path);
		
		FileReader fr = new FileReader(file);
		
		BufferedReader br= new BufferedReader(fr);
		
		String st;
		
		int row=0;
		while((st=br.readLine())!=null) {
			row=row+1;
		} return row;
	}

	private int getNumberOfColoumn() throws IOException {	 
		File file = new File(path);
		
		FileReader fr = new FileReader(file);
		
		BufferedReader br= new BufferedReader(fr);
		
		int coloumns= br.readLine().split(",").length;
		
		return coloumns;
	}

}
