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
	
	@Test 
	public void UserCanSearchForProduct() 
	{
	searchObject = new SearchPage(driver);
	detailsObject = new ProductDetailsPage(driver);
	searchObject.ProductSearch(productName);
	searchObject.openProductDetailsPage();
	//Assert.assertTrue(detailsObject.productNElementbreadCrumb.getText().equalsIgnoreCase(productName));
	Assert.assertEquals(detailsObject.productNElementbreadCrumb.getText(), productName);
	}
}
