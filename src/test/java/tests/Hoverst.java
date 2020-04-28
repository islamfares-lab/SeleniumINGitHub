package tests;

import org.testng.annotations.Test;

import pages.HMHoverPage;

public class Hoverst extends TestBase{
	void InvocationTargetException(Throwable target) {
	}
	HMHoverPage Object;

	@Test
	public void notificationMassege() throws InterruptedException 
	{
		Thread.sleep(3000);
		Object = new HMHoverPage(driver);
		Object.selectMusicMenue();
		

		//Assert.assertTrue(driver.getCurrentUrl().contains("bath"));
	}
}
