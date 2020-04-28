package pages;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class AddProductToComparePage extends PageBase {

	public AddProductToComparePage(WebDriver driver) {
		super(driver);
	}
	@FindBy(css = "table.compare-products-table")
	WebElement compareTable;

	@FindBy(tagName = "tr")
	List<WebElement> allRows;

	@FindBy(tagName = "td")
	List<WebElement> allCol;

	@FindBy(linkText = "Apple MacBook Pro 13-inch")
	public WebElement firstProductName;

	@FindBy(linkText = "Asus N551JK-XO076H Laptop")
	public WebElement secoundProductName;

	@FindBy(css = "a.clear-list")
	WebElement clearListLink;

	@FindBy(css = "div.no-data")
	public WebElement noDataLbl;

	public void clearCompareList() 
	{
		clickButton(clearListLink);
	}
	public void CompareProduct() 
	{
		// Get All Rows
		System.out.println(allRows.size());
		// Get Data from each Row
		for(WebElement row : allRows) 
		{
			System.out.println(row.getText()+"\t");
			// Get Data from each Colum
			for(WebElement col : allCol) 
			{
				System.out.println(col.getText()+"\t");
			}
		}
	}
}
