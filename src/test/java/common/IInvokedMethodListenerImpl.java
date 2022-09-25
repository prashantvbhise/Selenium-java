package common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class IInvokedMethodListenerImpl implements IInvokedMethodListener {

	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		
		try {
			System.out.println("Browser cleaning process started");
			//Runtime.getRuntime().exec("TASKKILL /F /IM chrome.exe /T"); //Kill Chrome browser
			Runtime.getRuntime().exec("TASKKILL /F /IM firefox.exe /T"); //Kill FireFox browser
			Runtime.getRuntime().exec("TASKKILL /F /IM chromedriver.exe  /T");
			
		} catch (IOException e2) 
		{
			System.out.println(e2.getMessage());
			
		}
		
	//Use of Property files
		Properties obj = new Properties();
		
		FileInputStream objfile = null;
		try {
			objfile = new FileInputStream("C:\\Users\\Pooja\\ALL_GIT_REPO\\Selenium-java\\src\\test\\resources\\property.properties");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			obj.load(objfile);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String BrowserName = obj.getProperty("Browser");
		
		if(BrowserName.contains("Chrome")) {
		
//		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
//		WebDriverFactory.setDriver(new ChromeDriver());
			
			DesiredCapabilities cap=new DesiredCapabilities();
		 	cap.setBrowserName("chrome");
		 	//cap.setVersion("105");
		 	//cap.setPlatform(Platform.WIN8);
		 	
		 	WebDriver dr = null;
		 	
			try {
				dr = new RemoteWebDriver(new URL("http://192.168.1.3:4444/wd/hub"),cap);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 	
		 	WebDriverFactory.setDriver(dr);
		}else {
//			System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver.exe");
//			WebDriverFactory.setDriver(new FirefoxDriver());
			DesiredCapabilities cap=new DesiredCapabilities();
		 	cap.setBrowserName("firefox");
		 	//cap.setVersion("105");
		 	//cap.setPlatform(Platform.WIN8);
		 	WebDriver dr = null;
		 	
			try {
				dr = new RemoteWebDriver(new URL("http://192.168.1.3:4444/wd/hub"),cap);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 	
		 	WebDriverFactory.setDriver(dr);
		}
		WebDriverFactory.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		WebDriverFactory.getDriver().manage().window().maximize();
		
		WebDriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				 
	}

	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		
		WebDriverFactory.getDriver().quit();
		try {
			Runtime.getRuntime().exec("TASKKILL /F /IM firefox.exe /T");
			//Runtime.getRuntime().exec("TASKKILL /F /IM chromedriver.exe  /T");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}

}
