package steps;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ContactUsPage;
import pages.HomePage;
import tests.TestBase;
public class E2ETests extends TestBase {

	HomePage homeObject;
	ContactUsPage contactObject;

	@Given("user is on home page")
	public void user_is_on_home_page() {
		homeObject = new HomePage(driver);
		homeObject.openContactUsPage();
	}
	@When("he go to contact us page")
	public void he_visit_contactuspage() {
		contactObject = new ContactUsPage(driver);
		Assert.assertTrue(driver.getCurrentUrl().contains("contactus"));
	}
	@And("user enterd Data {string},{string},{string}")
	public void chose_to_buy_Tow_items(String fullname, String email, String massage) throws InterruptedException {
		Thread.sleep(1000);
		contactObject = new ContactUsPage(driver);
		contactObject.ContactUs(fullname, email, massage);
	}
	@Then("he contacted us Successfuly")
	public void he_contacted_us_Successfuly() throws InterruptedException {
		contactObject = new ContactUsPage(driver);
		Thread.sleep(10000);
		Assert.assertTrue(contactObject.successMassege.getText().contains("successfully"));
	}
}
