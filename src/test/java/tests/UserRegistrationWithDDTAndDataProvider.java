package tests;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;
public class UserRegistrationWithDDTAndDataProvider extends TestBase {
	HomePage homeObject; 
	UserRegistrationPage registerObject;
	LoginPage loginObject;

	@DataProvider(name="testData")
	public static Object [][] userData()
	{return new Object[][] {
		{"fOx","Magnito","testxhxf9@gmail.com","1234567"},
		{"Islam","Fares","fadytest@yahoo.com","123456789"}
	};
	}
	@Test(priority = 1,alwaysRun = true,dataProvider="testData")
	public void UserCanRegisterSuccessfully(String fname, String lname, String email, String password) throws InterruptedException 
	{
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver);
		Thread.sleep(1000);
		registerObject.userRegistration(fname,lname,email,password);
		Assert.assertTrue(registerObject.successnotification.getText().contains("Your registration completed"));
		registerObject.userLogout();
		homeObject.openLoginPage();
		loginObject= new LoginPage(driver);
		Thread.sleep(2000);
		loginObject.UserLogin(email,password);
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
		registerObject.userLogout();
	}
}
