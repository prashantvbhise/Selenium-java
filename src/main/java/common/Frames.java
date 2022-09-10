package common;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frames {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		WebElement frame= driver.findElement(By.name("frame-top"));
		driver.switchTo().frame(frame);
		System.out.println("Driver Switched to top frame");
		WebElement frameLeft= driver.findElement(By.name("frame-left"));
		driver.switchTo().frame(frameLeft);
		System.out.println("Driver Switched to top- frame1");
		String title=driver.findElement(By.tagName("body")).getText();
		//String title= driver.findElement(By.name("frame-left")).getText();
		System.out.println(title);
		//String title= driver.switchTo().frame(0).getTitle();
		//WebElement frameMiddle= driver.findElement(By.name("frame-middle"));
		driver.switchTo().frame(driver.findElement(By.name("frame-middle")));
		//String title1=driver.findElement(By.tagName("body")).getText();
		System.out.println("title1");
		
		}

	}
