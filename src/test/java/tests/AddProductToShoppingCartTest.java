package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;

public class AddProductToShoppingCartTest extends TestBase {
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	ShoppingCartPage cartObject;
	/*1- Search for Product
	 *2- Add Product to Shopping Cart
	 *3- remove Product from Shopping cart
	 */
	String productName = "Apple MacBook Pro 13-inch";
	@Test(priority = 1)
	public void UserCanSearchForProduct() 
	{
		searchObject = new SearchPage(driver);
		searchObject.ProductSearchUsingAutoSuggest("Mac");
		detailsObject = new ProductDetailsPage(driver);
		Assert.assertTrue(detailsObject.productNElementbreadCrumb.getText().contains(productName));
	}
	@Test(priority = 2)
	public void UserCanAddProductToCart() throws InterruptedException 
	{
		detailsObject = new ProductDetailsPage(driver);
		detailsObject.AddProductToShoppingCart();
		detailsObject.openShoppingCartPage();
		cartObject = new ShoppingCartPage(driver);
		Assert.assertTrue(cartObject.productCrump.getText().contains("Apple MacBook Pro 13-inch"));
	}
	@Test(priority = 3)
	public void UserCanRemoveProductFromCart() 
	{
		cartObject = new ShoppingCartPage(driver);
		cartObject.RemoveProductFromCart();
	}
}
