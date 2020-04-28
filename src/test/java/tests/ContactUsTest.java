package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends TestBase
{
	HomePage home; 
	ContactUsPage contactPage;
	String fullName = "Test User";
	String email = "test@test.com";
	String enquiry = "Hello fOx , this is for test";

	@Test
	public void UserCanUseContactUs() {
		home = new HomePage(driver);
		home.openContactUsPage();
		contactPage = new ContactUsPage(driver);
		contactPage.ContactUs(fullName, email, enquiry);
		Assert.assertTrue(contactPage.successMassege.getText()
				.contains("Your enquiry has been successfully sent to the store owner."));
	}
}
