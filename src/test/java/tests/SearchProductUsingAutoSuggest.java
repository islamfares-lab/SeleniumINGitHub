package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductUsingAutoSuggest extends TestBase
{
	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	
	@Test
	public void UserCanSearchWithAutoSuggest() 
	{
		try 
		{	
			searchObject = new SearchPage(driver);
			searchObject.ProductSearchUsingAutoSuggest("Mac");
			detailsObject = new ProductDetailsPage(driver);
			Assert.assertEquals(detailsObject.productNElementbreadCrumb.getText(), productName);	
		} catch (Exception e) {
			System.out.println("Error Occurred " + e.getMessage());
		}
	}
}
