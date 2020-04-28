package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTest extends TestBase 
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
		registerObject.userRegistration("Islam","Fares","islamfaresfoxotgt@gmail.com","012345678");
		Assert.assertTrue(registerObject.successnotification.getText().contains("Your registration completed"));
	}
	@Test(dependsOnMethods = "UserCanRegisterSuccessfully")
	public void RegisterdUserCanLogout() 
	{
		registerObject.userLogout();
	}
	@Test(dependsOnMethods = "RegisterdUserCanLogout")
	public void RegisterdUserCanLogin() throws InterruptedException 
	{
		homeObject.openLoginPage();
		loginObject= new LoginPage(driver);
		Thread.sleep(2000);
		loginObject.UserLogin("islamfaresfoxotgt@gmail.com","012345678");
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
	}
}
