package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTestWithDTTAndJSonFile extends TestBase 
{
	HomePage homeObject; 
	UserRegistrationPage registerObject;
	LoginPage loginObject;

	@Test(priority = 1,alwaysRun = true)
	public void UserCanRegisterSuccessfully() throws InterruptedException 
	{
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver);
		Thread.sleep(1000);
		registerObject.userRegistration("Islam","Fares","islamfaresfoxoat@gmail.com","012345678");
		Assert.assertTrue(registerObject.successnotification.getText().contains("Your registration completed"));
		registerObject.userLogout();
		homeObject.openLoginPage();
		loginObject= new LoginPage(driver);
		Thread.sleep(2000);
		loginObject.UserLogin("islamfaresfoxott@gmail.com","012345678");
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
		registerObject.userLogout();
	}
}
