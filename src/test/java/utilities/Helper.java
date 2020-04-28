package utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {

	// Method to take Screenshot when test cases fail
	public static void captureScreenshot(WebDriver driver , String screenShotName) 
	{
		Path dest = Paths.get("./ScreenShots",screenShotName+".png");
		try {
			java.nio.file.Files.createDirectories(dest.getParent());
			FileOutputStream out = new FileOutputStream(dest.toString());
			out.write(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
			out.close();
		} catch (IOException e) {
			System.out.println("Expetion while taking ScreenShot" + e.getMessage());
		}
	}
}
