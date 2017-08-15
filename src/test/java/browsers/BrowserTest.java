package browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import edu.framework.base.UIBaseTest;

public class BrowserTest extends UIBaseTest {

	String path = System.getProperty("user.dir");

	@Test
	public void testFirefox() {

		System.out.println("SanityTest1");
		System.setProperty("webdriver.gecko.driver", path + "/drivers/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.toolsqa.com");
	}

	@Test
	public void testChrome() {

		System.out.println("SanityTest2");
		System.setProperty("webdriver.chrome.driver", path + "/drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.toolsqa.com");
	}
}