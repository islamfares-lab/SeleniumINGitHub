package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegistrationPage;

public class MyAccountTest extends TestBase 
{
	HomePage homeObject; 
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	MyAccountPage myAccountObject;
	String oldPassword= "1234567";
	String newPassword = "123456789";
	String firstName = "Islam";
	String lastName = "Fares";
	String email = "islamfaresfoxt1uf8@gmail.com";

	@Test(priority =1)
	public void UserCanRegisterSuccessfully() 
	{
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegistration(firstName, lastName, email, oldPassword);
		Assert.assertTrue(registerObject.successnotification.getText().contains("Your registration completed"));
	}
	@Test(dependsOnMethods = {"UserCanRegisterSuccessfully"})
	public void RegisteredUserCanChangePassword() 
	{
		myAccountObject = new MyAccountPage(driver);
		registerObject.openMyAccountPage();
		myAccountObject.openChangePasswordPage();
		myAccountObject.ChangePassword(oldPassword, newPassword);
		Assert.assertTrue(myAccountObject.resultLbl.getText().contains("Password was changed"));
	}
	@Test(dependsOnMethods = {"RegisteredUserCanChangePassword"})
	public void RegisterdUserCanLogout() 
	{
		registerObject.userLogout();
	}
	@Test(dependsOnMethods = {"RegisterdUserCanLogout"})
	public void RegisterdUserCanLogin() 
	{
		homeObject.openLoginPage();
		loginObject= new LoginPage(driver);
		loginObject.UserLogin(email,newPassword);
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
	}
}
