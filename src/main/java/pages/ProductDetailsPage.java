package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase {

	public ProductDetailsPage(WebDriver driver) {
		super(driver);	
	}
	@FindBy(css = "strong.current-item")
	public WebElement productNElementbreadCrumb;

	@FindBy(css ="input.button-2.email-a-friend-button")
	WebElement emailFriendBtn;

	@FindBy(css = "span.price-value-4")
	public WebElement productPreisLbl;
	
	@FindBy(linkText = "Add your review")
	WebElement addReviewBtn;
	
	@FindBy(id = "add-to-wishlist-button-4")
	WebElement addToWishListBtn;
	
	@FindBy(css = "span.wishlist-label")
	WebElement wishListLink;
	
	@FindBy(css = "input.add-to-compare-list-button:nth-child(1)")
	WebElement addToCompareBtn;
	
	@FindBy(id = "add-to-cart-button-4")
	WebElement addToCartBtn;
	
	@FindBy(css = "a.ico-cart")
	WebElement shoppingCartLink;

	public void openSendEmail() 
	{
		clickButton(emailFriendBtn);
	}
	public void openAddReviewPage() 
	{
		clickButton(addReviewBtn);
	}
	public void AddProductToWishList() 
	{
		clickButton(addToWishListBtn);
	}
	public void openWishListPage() 
	{
		clickButton(wishListLink);
	}
	public void AddProductToCompareList() 
	{
		clickButton(addToCompareBtn);
	}
	public void AddProductToShoppingCart() 
	{
		clickButton(addToCartBtn);
	}
	public void openShoppingCartPage() throws InterruptedException 
	{
		clickButton(shoppingCartLink);
	}
}
