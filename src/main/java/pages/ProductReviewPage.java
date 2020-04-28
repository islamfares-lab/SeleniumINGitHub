package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductReviewPage extends PageBase {

	public ProductReviewPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id = "AddProductReview_Title")
	WebElement reviewTitleTxt;
	
	@FindBy(id = "AddProductReview_ReviewText")
	WebElement reviewText;
	
	@FindBy(id = "addproductrating_4")
	WebElement rating4RadioBtn;
	
	@FindBy(css = "input.button-1.write-product-review-button")
	WebElement submitBtn;
	
	@FindBy(css = "div.result")
	public WebElement reviwenotification;
	
	public void AddProductReview(String reviweTitle, String reviewMessage) 
	{
		setTextElementText(reviewTitleTxt, reviweTitle);
		setTextElementText(reviewText, reviewMessage);
		clickButton(rating4RadioBtn);
		clickButton(submitBtn);
	}
}
