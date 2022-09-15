package common;

import org.openqa.selenium.WebDriver;

public class WebDriverFactory {
	
	private static ThreadLocal<WebDriver> threadLocalStorage = new ThreadLocal<WebDriver>();
	
	public static WebDriver getDriver() {
		
		return threadLocalStorage.get();
		//Added
			
	}
	
	public static void setDriver(WebDriver localDriver) {
		
		threadLocalStorage.set(localDriver);		
		
	}
	

}
