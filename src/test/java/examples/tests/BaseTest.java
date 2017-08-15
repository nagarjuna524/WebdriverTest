package examples.tests;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import examples.ConstantsValues;


public class BaseTest {
	
	protected WebDriver driver;
	
	@BeforeClass
	public void mandSetup() throws InterruptedException, IOException {
//		FirefoxProfile profile = new FirefoxProfile();
//		File addonpath = new File("/Users/NAGARJUNA/Downloads/firebug-2.0.13-fx.xpi");
//		profile.addExtension(addonpath);
//		driver = new FirefoxDriver(profile);
		driver = new FirefoxDriver();
		driver.get(ConstantsValues.SITE_URL);
		driver.manage().window().maximize();
		String mainWindow = driver.getWindowHandle();
		Assert.assertTrue(closeAllOtherWindows(mainWindow));
		Thread.sleep(3000L);
	}
	
	@AfterClass
	public void mandTearDown() {
		driver.quit();
	} 
	
	public String getCurrentWindowTitle() {
		String windowTitle = driver.getTitle();
		return windowTitle;
	}
	
	public boolean closeAllOtherWindows(String mainWindow) {
		Set<String> getAllWindows = driver.getWindowHandles();
		for(String currentWindowHandle: getAllWindows) {
			if(!currentWindowHandle.equals(mainWindow)) {
				driver.switchTo().window(currentWindowHandle);
				System.out.println(driver.getTitle());
				driver.close();
			}
			else {
				System.out.println(driver.getTitle());
			}
		}
		driver.switchTo().window(mainWindow);
		if (driver.getWindowHandles().size() == 1)
			return true;
		else
			return false;
		
	}
}
