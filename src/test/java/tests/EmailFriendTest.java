package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.UserRegistrationPage;

public class EmailFriendTest extends TestBase 
{
	HomePage homeObject; 
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	EmailPage EmailObject;

	// 1- UserRegistration 
	@Test(priority = 1,alwaysRun = true)
	public void UserCanRegisterSuccessfully() 
	{
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegistration("Islam","Fares","islamfaresfoxsas0359@gmail.com","12345678");
		Assert.assertTrue(registerObject.successnotification.getText().contains("Your registration completed"));
	}
	// 2- Search for Product 
	@Test(priority = 2)
	public void UserCanSearchWithAutoSuggest() 
	{
		try 
		{	
			searchObject = new SearchPage(driver);
			searchObject.ProductSearchUsingAutoSuggest("Macb");
			detailsObject = new ProductDetailsPage(driver);
			Assert.assertEquals(detailsObject.productNElementbreadCrumb.getText(), productName);	
		} catch (Exception e) {
			System.out.println("Error Occurred " + e.getMessage());
		}
	}
	// 3- Email to Friend
	@Test(priority = 3)
	public void RegisteredUserCanSendProductToFriend() 
	{
		detailsObject.openSendEmail();
		EmailObject = new EmailPage(driver);
		EmailObject.sendEmailToFriend("aaak@tte.com", "Hello Friend");
		Assert.assertTrue(EmailObject.messageNotification.getText().contains("Your message has been sent."));
	}
	// 4- User LogOut
	@Test(priority = 4)
	public void RegisterdUserCanLogout() 
	{
		registerObject.userLogout();
	}
}
