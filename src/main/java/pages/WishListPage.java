package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class WishListPage extends PageBase {

	public WishListPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(css = "a.product-name")
	public WebElement productCell;

	@FindBy(css = "h1")
	public WebElement wishListHeader;

	@FindBy(name = "removefromcart")
	WebElement removeFromCartCheck;

	@FindBy(name = "updatecart")
	WebElement updateWishListBtn;

	@FindBy(css = "div.no-data")
	public WebElement emptyCartLbl;

	public void removeProductFromCart() throws InterruptedException 
	{
		clickButton(removeFromCartCheck);
		Thread.sleep(1000);
		clickButton(updateWishListBtn);
	}
}
