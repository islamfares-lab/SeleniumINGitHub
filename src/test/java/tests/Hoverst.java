package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HMHoverPage;

public class Hoverst extends TestBase{
	void InvocationTargetException(Throwable target) {
	}
	HMHoverPage Object;

	@Test
	public void notificationMassege() throws InterruptedException 
	{
		Object = new HMHoverPage(driver);
		Object.selectMusicMenue();
		Thread.sleep(1000);
		Assert.assertTrue(driver.getCurrentUrl().contains("bath"));
	}
}
