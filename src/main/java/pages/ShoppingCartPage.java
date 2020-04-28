package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class ShoppingCartPage extends PageBase {

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(name = "removefromcart")
	WebElement removeCheck;

	@FindBy(name = "updatecart")
	WebElement updateCartBtn;

	@FindBy(css = "td.quantity")
	public WebElement quantityTxt;

	@FindBy(css="td.product")
	public WebElement productCrump;
	
	@FindBy(id = "termsofservice")
	WebElement agreeCheckBox;

	@FindBy(id = "checkout")
	WebElement checkoutBtn;

	public void RemoveProductFromCart() 
	{
		clickButton(removeCheck);
		clickButton(updateCartBtn);
	}
	public void UpdateProductQuantityCart(String quantity) 
	{// Clear Quantity Box
		clearText(quantityTxt);
		setTextElementText(quantityTxt, quantity);
		clickButton(updateCartBtn);
	}
	public void openCheckoutPage() throws InterruptedException 
	{
		
		clickButton(agreeCheckBox);
		//Thread.sleep(1000);
		clickButton(checkoutBtn);
		
	}
}
