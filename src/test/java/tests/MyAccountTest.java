package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegistrationPage;

import java.util.concurrent.TimeUnit;

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
	String email = "afadifoihgoi8@gmail.com";

	@Test(priority = 1)
	public void UserCanRegisterSuccessfully() throws InterruptedException {
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver);
		Thread.sleep(1000);
		registerObject.userRegistration(firstName, lastName, email, oldPassword);
		Assert.assertTrue(registerObject.successnotification.getText().contains("Your registration completed"));
	}
	@Test(priority = 2)
	public void RegisteredUserCanChangePassword() throws InterruptedException {
		myAccountObject = new MyAccountPage(driver);
		registerObject.openMyAccountPage();
		Thread.sleep(1000);
		myAccountObject.openChangePasswordPage();
		Thread.sleep(1000);
		myAccountObject.ChangePassword(oldPassword, newPassword);
		Assert.assertTrue(myAccountObject.resultLbl.getText().contains("Password was changed"));
	}
	@Test(priority = 3)
	public void RegisterdUserCanLogout() throws InterruptedException {
		registerObject.userLogout();
	}
	@Test(priority = 4)
	public void RegisterdUserCanLogin() throws InterruptedException {
		Thread.sleep(1000);
		homeObject.openLoginPage();
		loginObject= new LoginPage(driver);
		Thread.sleep(1000);
		loginObject.UserLogin(email,newPassword);
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
	}
}
