package tests;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddProductToComparePage;
import pages.ProductDetailsPage;
import pages.SearchPage;
public class AddProductToCompareListTest extends TestBase {
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	AddProductToComparePage compareObject;
	/*1- Search for Product number 1 
	 *2- Search for Product number 2 
	 *3- Add Product to CompareList
	 *4- Clear list
	 */
	String firstProductName ="Apple MacBook Pro 13-inch";
	String secoundProductName ="Asus N551JK-XO076H Laptop";

	@Test(priority = 1)
	public void UserCanCompareProducts() throws InterruptedException 
	{
		searchObject = new SearchPage(driver);
		detailsObject = new ProductDetailsPage(driver);
		compareObject = new AddProductToComparePage(driver);

		searchObject.ProductSearchUsingAutoSuggest("Mac");
		Assert.assertTrue(detailsObject.productNElementbreadCrumb.getText().contains(firstProductName));
		detailsObject.AddProductToCompareList();

		searchObject.ProductSearchUsingAutoSuggest("Asus");
		Assert.assertTrue(detailsObject.productNElementbreadCrumb.getText().contains(secoundProductName));
		detailsObject.AddProductToCompareList();
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.navigate().to("https://demo.nopcommerce.com" + "/compareproducts");
		Assert.assertTrue(compareObject.firstProductName.getText().equals("Apple MacBook Pro 13-inch"));
		Assert.assertTrue(compareObject.secoundProductName.getText().equals("Asus N551JK-XO076H Laptop"));
		compareObject.CompareProduct();
	}
	@Test(priority = 2)
	public void UserCanClearCompareList() 
	{
		compareObject.clearCompareList();;
		Assert.assertTrue(compareObject.noDataLbl.getText().contains("You have no items to compare."));
	}
}
