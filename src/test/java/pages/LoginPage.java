package pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import common.WebDriverFactory;

public class LoginPage {
	
	@FindBy(name = "username")
	private WebElement username;

	@FindBy(name = "password")
	private WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement loginButton;
	
	protected WebDriverWait wait;
	
	public LoginPage() {
		
		PageFactory.initElements(WebDriverFactory.getDriver(), this);
		wait= new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(30));
	}
	
	public HomePage loginToOraneHrm(String strUsername, String strPassword) {
		
		wait.until(ExpectedConditions.visibilityOf(username));
		username.sendKeys(strUsername);
		password.sendKeys(strPassword);
		wait.until(ExpectedConditions.elementToBeClickable(loginButton));
		loginButton.click();
		HomePage hp = new HomePage();
		return hp;
		
	}

}
