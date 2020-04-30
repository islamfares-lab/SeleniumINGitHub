package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegistrationPage;

public class MyAccountParallelTest extends TestBase2 {
	HomePage homeObject; 
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	MyAccountPage myAccountObject;
	Faker fakeData = new Faker();
	String firstName = fakeData.name().firstName();
	String lastName = fakeData.name().lastName();
	String email = fakeData.internet().emailAddress();
	String oldPassword= fakeData.number().digits(8).toString();
	String newPassword = fakeData.number().digits(8).toString();

	@Test(priority = 1)
	public void UserCanRegisterSuccessfully() throws InterruptedException 
	{
		homeObject = new HomePage(getDriver());
		homeObject.openRegistrationPage();
		Thread.sleep(1000);
		registerObject = new UserRegistrationPage(getDriver());
		registerObject.userRegistration(firstName, lastName, email, oldPassword);
		Assert.assertTrue(registerObject.successnotification.getText().contains("Your registration completed"));
	}
	@Test(priority = 2)
	public void RegisteredUserCanChangePassword() throws InterruptedException 
	{
		myAccountObject = new MyAccountPage(getDriver());
		Thread.sleep(1000);
		registerObject.openMyAccountPage();
		myAccountObject.openChangePasswordPage();
		myAccountObject.ChangePassword(oldPassword, newPassword);
		Assert.assertTrue(myAccountObject.resultLbl.getText().contains("Password was changed"));
	}
	@Test(priority = 3)
	public void RegisterdUserCanLogout() 
	{
		registerObject.userLogout();
	}
	@Test(priority = 4)
	public void RegisterdUserCanLogin() throws InterruptedException 
	{
		Thread.sleep(1000);
		homeObject.openLoginPage();
		loginObject= new LoginPage(getDriver());
		loginObject.UserLogin(email,newPassword);
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
	}

}
