package tests;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.OrderDetailsPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;
import pages.UserRegistrationPage;
public class RegisterdUserCheckoutProduct extends TestBase {
	/*1- Register User
	 *2- Search for Product 
	 *3- Add to Cart
	 *4- Check Out
	 *5- Log Out
	 */
	HomePage homeObject;
	UserRegistrationPage registerdObject;
	LoginPage loginObject;
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	ShoppingCartPage cartObject;
	CheckoutPage checkoutObject;
	OrderDetailsPage orderObject;
	String productName = "Apple MacBook Pro 13-inch";

	@Test(priority=1, alwaysRun=true)
	public void UserCanRegisterSuccessfully() 
	{
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerdObject = new UserRegistrationPage(driver);
		registerdObject.userRegistration("Islam","Fares","tfev1595osnmmgist.tklqdzrzj8@gmail.com","12345678");
		Assert.assertTrue(registerdObject.successnotification.getText().contains("Your registration completed"));
	}
	@Test(priority=2)
	public void UserCanSearchForProductWithAutoSuggest() 
	{
		try { 
			searchObject = new SearchPage(driver);
			searchObject.ProductSearchUsingAutoSuggest("Mac");
			detailsObject = new ProductDetailsPage(driver);
			Assert.assertTrue(detailsObject.productNElementbreadCrumb.getText().contains(productName));
		} catch (Exception e) {
			System.out.println("Error Occourred " + e.getMessage());
		}
	}
	@Test(priority=3)
	public void UserCanAddProductToShoppingCart() throws InterruptedException 
	{
		detailsObject = new ProductDetailsPage(driver);
		detailsObject.AddProductToShoppingCart();
		detailsObject.openShoppingCartPage();
		cartObject = new ShoppingCartPage(driver);
		assertTrue(cartObject.productCrump.getText().contains(productName));
	}
	@Test(priority=4)
	public void UserCanCheckoutProduct() throws InterruptedException 
	{
		cartObject.openCheckoutPage();
		checkoutObject = new CheckoutPage(driver);
		Thread.sleep(2000);
		checkoutObject.RegisterdUserCheckoutProduct
		("fOx", productName, "Germany", "Hamburg", "Aid.Strasse", "11311", "01018114357", "136548");
		Assert.assertTrue(checkoutObject.productName.isDisplayed());
		Assert.assertTrue(checkoutObject.productName.getText().contains(productName));
		checkoutObject.confirmOrder();
		Assert.assertTrue(checkoutObject.ThankYouLbl.isDisplayed());
		checkoutObject.oppenOrderPage();
		Assert.assertTrue(driver.getCurrentUrl().contains("orderdetails"));
		orderObject = new OrderDetailsPage(driver);
		orderObject.DownLoadPDFInvoice();
		orderObject.PrintOrderDetails();
	}
	@Test(priority=5)
	public void RegisterdUserCanLogout() 
	{
		registerdObject = new UserRegistrationPage(driver);
		registerdObject.userLogout();
	}
}
