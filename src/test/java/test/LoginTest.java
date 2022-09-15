package test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import common.BaseSelenium1;
import common.IInvokedMethodListenerImpl;
import pages.LoginPage;

@Listeners(IInvokedMethodListenerImpl.class)
public class LoginTest extends BaseSelenium1{
	
	@Test (dataProvider="ExcelDataProvider")
	public void verifyLogin(String strUserName, String strPassword, String strActualWelcomeText) {
		
		LoginPage lp= new LoginPage();
		
		lp.loginToOraneHrm(strUserName, strPassword)
		//.verifyWelcomeText(strActualWelcomeText)
		.printEmpolyeeDetails();
	}

}
	