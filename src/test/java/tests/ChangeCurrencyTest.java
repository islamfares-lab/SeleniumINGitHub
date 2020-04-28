package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class ChangeCurrencyTest extends TestBase{

	HomePage homeObject;
	String productName ="Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;

	@Test (priority = 1)
	public void UserCanChangeCurrency() 
	{
		homeObject = new HomePage(driver);
		homeObject.ChangeCurrency();
	}
	@Test(priority = 2)
	public void UserCanSearchWithAutoSuggest() {
		try 
		{	
			searchObject = new SearchPage(driver);
			searchObject.ProductSearchUsingAutoSuggest("Macb");
			detailsObject = new ProductDetailsPage(driver);
			Assert.assertEquals(detailsObject.productNElementbreadCrumb.getText(), productName);
			Assert.assertTrue(detailsObject.productPreisLbl.getText().contains("Ђ"));
			System.out.println(detailsObject.productPreisLbl.getText());
		} catch (Exception e) {
			System.out.println("Error Occurred " + e.getMessage());
		}
	}
}
