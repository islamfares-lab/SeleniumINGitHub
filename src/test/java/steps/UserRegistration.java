package steps;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.UserRegistrationPage;
import tests.TestBase;
public class UserRegistration extends TestBase {

	HomePage homeObject; 
	UserRegistrationPage registerObject;

	@Given("the user in the home page")
	public void the_user_in_the_home_page() {
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
	}
	@When("i click on register link")
	public void i_click_on_register_link() {
		Assert.assertTrue(driver.getCurrentUrl().contains("register"));
	}
	@When("i entered the {string},{string},{string},{string}")
	public void i_entered_the(String firstname, String lastname, String email, String password) throws InterruptedException {
		registerObject = new UserRegistrationPage(driver);
		Thread.sleep(1000);
		registerObject.userRegistration(firstname,lastname,email,password);
	}
	@Then("The registration page displayed successfully")
	public void the_registration_page_displayed_successfully() throws InterruptedException {
		registerObject = new UserRegistrationPage(driver);
		registerObject.userLogout();
	}
}
