package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.ProductReviewPage;
import pages.SearchPage;
import pages.UserRegistrationPage;

public class AddProductReviewTest extends TestBase 
{
	/* 1- User Registration
	 * 2- Search for Product 
	 * 3- Add Review 
	 *  4- Log Out
	 */
	HomePage homeObject; 
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	ProductReviewPage reviewObject;

	// 1- UserRegistration 
	@Test(priority = 1,alwaysRun = true)
	public void UserCanRegisterSuccessfully() throws InterruptedException 
	{
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		Thread.sleep(1000);
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegistration("Islam","Fares","islamfaretuazu78@gmail.com","12345678");
		Assert.assertTrue(registerObject.successnotification.getText().contains("Your registration completed"));
	}
	// 2- Search for Product 
	@Test(priority = 2)
	public void UserCanSearchWithAutoSuggest() 
	{
		try {	
			searchObject = new SearchPage(driver);
			searchObject.ProductSearchUsingAutoSuggest("Macb");
			detailsObject = new ProductDetailsPage(driver);
			Assert.assertEquals(detailsObject.productNElementbreadCrumb.getText(), productName);	
		} catch (Exception e) {
			System.out.println("Error Occurred " + e.getMessage());
		}
	}
	// 3- Add Review 
	@Test(priority = 3)
	public void RegisteredUserCanReviewProduct() 
	{
		detailsObject.openAddReviewPage();
		reviewObject = new ProductReviewPage(driver);
		reviewObject.AddProductReview("new reviwe", "Good Product");
		Assert.assertTrue(reviewObject.reviwenotification
				.getText().contains("Product review is successfully added."));
	}
	// 4- User LogOut
	@Test(priority = 4)
	public void RegisterdUserCanLogout() 
	{
		registerObject.userLogout();
	}
}
