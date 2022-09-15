package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import common.WebDriverFactory;

public class HomePage {

	@FindBy(xpath = "//p[@class='oxd-userdropdown-name']")
	private WebElement welcomeMsg;
	
	@FindBy(xpath = "//span[text()='PIM']")
	private WebElement pimLink;
	
	@FindBy(xpath="//div[@class='oxd-table-row oxd-table-row--with-border oxd-table-row--clickable']")
	private List<WebElement> rowList;
	
	@FindBy(xpath="//div[@class='oxd-table-cell oxd-padding-cell']")
	private List<WebElement> empList;
	
	protected WebDriverWait wait;
	
	public HomePage() {
		
		PageFactory.initElements(WebDriverFactory.getDriver(), this);
		wait= new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(30));
	}
	
	public HomePage verifyWelcomeText(String strActualWelcomeText) {
		Assert.assertEquals(welcomeMsg.getText(), strActualWelcomeText);
		return this;
	}
	
	public HomePage printEmpolyeeDetails() {
		
		//pimLink.click();
		
		for (int i = 0; i < empList.size(); i++) {
			
			System.out.println(empList.get(i+1).getText());
					
			if(i==2) break;
			
		}return this;
		
	}
}
