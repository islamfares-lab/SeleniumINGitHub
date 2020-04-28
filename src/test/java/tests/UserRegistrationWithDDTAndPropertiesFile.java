package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import data.LoadProperties;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationWithDDTAndPropertiesFile extends TestBase 
{
	HomePage homeObject; 
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	String firstname = LoadProperties.userData.getProperty("firstname");
	String lastname = LoadProperties.userData.getProperty("lastname");
	String email = LoadProperties.userData.getProperty("email");
	String password = LoadProperties.userData.getProperty("password");

	@Test(priority = 1,alwaysRun = true)
	public void UserCanRegisterSuccessfully() throws InterruptedException 
	{
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver);
		Thread.sleep(1000);
		registerObject.userRegistration(firstname,lastname,email,password);
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
		loginObject.UserLogin(email,password);
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
	}
}
