package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
public class CheckoutPage extends PageBase {

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(css = "input.button-1.checkout-as-guest-button")
	WebElement guestBtn;

	@FindBy(id = "BillingNewAddress_FirstName")
	WebElement fnTxt;

	@FindBy(id = "BillingNewAddress_LastName")
	WebElement lnTxt;

	@FindBy(id = "BillingNewAddress_Email")
	WebElement emailTxt;

	@FindBy(id = "BillingNewAddress_Company")
	WebElement companyTxt;

	@FindBy(id = "BillingNewAddress_CountryId")
	WebElement countryList;

	@FindBy(id = "BillingNewAddress_City")
	WebElement cityTxt;

	@FindBy(id = "BillingNewAddress_Address1")
	WebElement addressTxt1;

	@FindBy(id = "BillingNewAddress_Address2")
	WebElement addressTxt2;

	@FindBy(id = "BillingNewAddress_ZipPostalCode")
	WebElement postalCodeTxt;

	@FindBy(id = "BillingNewAddress_PhoneNumber")
	WebElement phoneNumberTxt;

	@FindBy(id = "BillingNewAddress_FaxNumber")
	WebElement faxNumberTxt;

	@FindBy(css = "input.button-1.new-address-next-step-button")
	WebElement firstStepcontinueBtn;

	@FindBy(id = "shippingoption_1")
	WebElement shippMethodRdo;

	@FindBy(css = "input.button-1.shipping-method-next-step-button")
	WebElement shippContinueBtn;

	@FindBy(css = "input.button-1.payment-method-next-step-button")
	WebElement paymentMethodContinueBtn;

	@FindBy(css = "input.button-1.payment-info-next-step-button")
	WebElement paymentInfoContinueBtn;

	@FindBy(css = "a.product-name")
	public WebElement productName;

	@FindBy(css = "input.button-1.confirm-order-next-step-button")
	WebElement confirmOrderBtn;

	@FindBy(css = "h1")
	public WebElement ThankYouLbl;

	@FindBy(css = "div.title")
	public WebElement successfulMessage;

	@FindBy(linkText = "Click here for order details.")
	WebElement orderDetailsLink;

	public void RegisterdUserCheckoutProduct(String companyName, String productName,
			String countryName,String cityName, String address,String postalCode, String phoneNumber, String faxNumber) throws InterruptedException 
	{
	select = new Select(countryList);
	select.selectByVisibleText(countryName);
	setTextElementText(companyTxt, companyName);
	setTextElementText(cityTxt, cityName);
	setTextElementText(addressTxt1, address);
	setTextElementText(addressTxt2, address);
	setTextElementText(postalCodeTxt, postalCode);
	setTextElementText(phoneNumberTxt, phoneNumber);
	setTextElementText(faxNumberTxt, faxNumber);
	clickButton(firstStepcontinueBtn);
	clickButton(shippMethodRdo);
	clickButton(shippContinueBtn);
	Thread.sleep(1000);
	clickButton(paymentMethodContinueBtn);
	Thread.sleep(1000);
	clickButton(paymentInfoContinueBtn);
	}
	public void confirmOrder() throws InterruptedException 
	{
		Thread.sleep(1000);
		clickButton(confirmOrderBtn);
	}
	public void oppenOrderPage() 
	{
		clickButton(orderDetailsLink);
	}
	public void checkoutProductAsGuest(String firstName, String lastName , String email, String companyName, String productName,
			String countryName,String cityName, String address,String postalCode, String phoneNumber, String faxNumber) throws InterruptedException 
	{setTextElementText(fnTxt, firstName);
	setTextElementText(lnTxt, lastName);
	setTextElementText(emailTxt, email);
	setTextElementText(companyTxt, companyName);
	select = new Select(countryList);
	select.selectByVisibleText(countryName);
	setTextElementText(cityTxt, cityName);
	setTextElementText(addressTxt1, address);
	setTextElementText(addressTxt2, address);
	setTextElementText(postalCodeTxt, postalCode);
	setTextElementText(phoneNumberTxt, phoneNumber);
	setTextElementText(faxNumberTxt, faxNumber);
	clickButton(firstStepcontinueBtn);
	clickButton(shippMethodRdo);
	clickButton(shippContinueBtn);
	Thread.sleep(1000);
	clickButton(paymentMethodContinueBtn);
	Thread.sleep(1000);
	clickButton(paymentInfoContinueBtn);
	}
	public void OpenCheckoutAsGuestPage() 
	{
		clickButton(guestBtn);
	}
}
