package tests;
import static org.testng.Assert.assertTrue;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.HomePage;
import pages.OrderDetailsPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;
public class GuestCanCheckoutProductFromCart extends TestBase {
	/*
	 *1- Search for Product 
	 *2- Add to Cart
	 *3- Check Out as Guest
	 */
	HomePage homeObject;
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	ShoppingCartPage cartObject;
	CheckoutPage checkoutObject;
	OrderDetailsPage orderObject;
	String productName = "Apple MacBook Pro 13-inch";

	@Test(priority=1)
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
	@Test(priority=2)
	public void UserCanAddProductToShoppingCart() throws InterruptedException 
	{
		detailsObject = new ProductDetailsPage(driver);
		detailsObject.AddProductToShoppingCart();
		detailsObject.openShoppingCartPage();
		cartObject = new ShoppingCartPage(driver);
		assertTrue(cartObject.productCrump.getText().contains(productName));
	}
	@Test(priority=3)
	public void UserCanCheckoutProduct() throws InterruptedException 
	{
		cartObject.openCheckoutPage();
		checkoutObject = new CheckoutPage(driver);
		Thread.sleep(2000);
		checkoutObject.OpenCheckoutAsGuestPage();
		checkoutObject.checkoutProductAsGuest
		("Islam","Fares","test.test441@gmail.com","fOx", productName, "Germany", "Hamburg", "Aid.Strasse", "11311", "01018114357", "136548");
		Assert.assertTrue(checkoutObject.productName.isDisplayed());
		Assert.assertTrue(checkoutObject.productName.getText().contains(productName));
		checkoutObject.confirmOrder();
		Assert.assertTrue(checkoutObject.ThankYouLbl.isDisplayed());
	}
	@Test(priority=4)
	public void UserCanViewOrderDetails() throws InterruptedException 
	{
		checkoutObject.oppenOrderPage();
		Assert.assertTrue(driver.getCurrentUrl().contains("orderdetails"));
		orderObject = new OrderDetailsPage(driver);
		orderObject.DownLoadPDFInvoice();
		Thread.sleep(3000);
		orderObject.PrintOrderDetails();
	}
}
