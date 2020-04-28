package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.WishListPage;

public class AddProductToWishListTest extends TestBase {
/* 1- search for Product 
 * 2- Add Product to wishList
 * 3- remove Product from cart  
 */ SearchPage searchObject; 
	ProductDetailsPage detailsObject;
	WishListPage wishlistObject;
	String productName = "Apple MacBook Pro 13-inch";
	
	@Test(priority = 1)
	public void UserCanSearchForProdsuctWithAutoSuggest() 
	{
		searchObject = new SearchPage(driver);
		searchObject.ProductSearchUsingAutoSuggest("Mac");
		detailsObject = new ProductDetailsPage(driver);
		Assert.assertEquals(detailsObject.productNElementbreadCrumb.getText(), productName);
	}
	@Test(priority = 2)
	public void UserCanAddProductToWishList() 
	{
		detailsObject = new ProductDetailsPage(driver);
		detailsObject.AddProductToWishList();
		//driver.navigate().to("https://demo.nopcommerce.com" + "/wishlist");
		detailsObject.openWishListPage();
		wishlistObject = new WishListPage(driver);
		Assert.assertTrue(wishlistObject.wishListHeader.isDisplayed());
		Assert.assertTrue(wishlistObject.productCell.getText().contains(productName));
	}
	@Test(priority = 3)
	public void UserCanRemoveProductFromCart() throws InterruptedException 
	{
		wishlistObject = new WishListPage(driver);
		wishlistObject.removeProductFromCart();
		Assert.assertTrue(wishlistObject.emptyCartLbl.getText().contains("empty!"));
	}
}
