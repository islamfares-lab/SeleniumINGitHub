package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductTest extends TestBase 
{
	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	
	@Test(alwaysRun = true)
	public void UserCanSearchForProduct() throws InterruptedException {
	searchObject = new SearchPage(driver);
	detailsObject = new ProductDetailsPage(driver);
	searchObject.ProductSearch(productName);
	searchObject.openProductDetailsPage();
	Thread.sleep(1000);
	//Assert.assertTrue(detailsObject.productNElementbreadCrumb.getText().equalsIgnoreCase(productName));
	//Assert.assertEquals(detailsObject.productNElementbreadCrumb.getText(), productName);
	}
}
