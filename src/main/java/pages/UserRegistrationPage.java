package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class UserRegistrationPage extends PageBase
{
	public UserRegistrationPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id = "gender-male")
	WebElement genderRadioBtn;

	@FindBy(id = "FirstName")
	WebElement fnTxtBox;

	@FindBy(id = "LastName")
	WebElement lnTxtBox;

	@FindBy(id = "Email")
	WebElement emailTxtBox;

	@FindBy(id = "Password")
	WebElement PasswordTxtBox;

	@FindBy(id = "ConfirmPassword")
	WebElement confirmPasswordTxtBox;

	@FindBy(id = "register-button")
	WebElement registerBtn;

	@FindBy(css = "div.result")
	public WebElement successnotification;

	@FindBy(css = "a.ico-logout")
	public WebElement logoutLink;
	
	@FindBy(linkText = "My account")
	WebElement myAccountLink;

	public void userRegistration(String firstName , String lastName , String email, String Password) 
	{
		clickButton(genderRadioBtn);
		setTextElementText(fnTxtBox, firstName);
		setTextElementText(lnTxtBox, lastName);
		setTextElementText(emailTxtBox, email);
		setTextElementText(PasswordTxtBox, Password);
		setTextElementText(confirmPasswordTxtBox, Password);
		clickButton(registerBtn);
	}
	public void userLogout () 
	{
		clickButton(logoutLink);
	}
	public void openMyAccountPage() 
	{
		clickButton(myAccountLink);
	}
}
