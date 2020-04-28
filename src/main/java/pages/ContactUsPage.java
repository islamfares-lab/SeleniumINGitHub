package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase {

	public ContactUsPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id = "FullName")
	WebElement fullNameTxt;
	
	@FindBy(id = "Email")
	WebElement emailTxt;
	
	@FindBy(id = "Enquiry")
	WebElement enquiryTxt;
	
	@FindBy(css = "input.button-1.contact-us-button")
	WebElement submitBtn;
	
	@FindBy(css = "div.result")
	public WebElement successMassege;
	
	public void ContactUs(String fullName, String email, String massege) 
	{
		setTextElementText(fullNameTxt, fullName);
		setTextElementText(emailTxt, email);
		setTextElementText(enquiryTxt, massege);
		clickButton(submitBtn);
	}
}
