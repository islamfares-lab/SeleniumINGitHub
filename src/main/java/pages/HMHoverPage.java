package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HMHoverPage extends PageBase {

	public HMHoverPage(WebDriver driver) {
		super(driver);
	action = new Actions(driver);
	}
	@FindBy(xpath = ".//div[contains(text(),'Music')]\"")
	WebElement musicMenue;

	@FindBy(css=".//div[contains(text(),'Rock')]")
	WebElement rockMenue;
	
	@FindBy(xpath = ".//div[contains(text(),'Alternative')]")
	WebElement alternativMenue;

	public void selectMusicMenue() throws InterruptedException 
	{
		Thread.sleep(2000);
		action.moveToElement(musicMenue).perform();
		action.moveToElement(rockMenue).perform();
		Thread.sleep(2000);
		action.moveToElement(alternativMenue).perform();
	}
}
