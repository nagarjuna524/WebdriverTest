package ui.tests.example;

import org.testng.Assert;
import org.testng.annotations.Test;

import edu.framework.base.SessionManager;
import edu.framework.base.UIBaseTest;
import edu.framework.helpers.BrowserHelper;


public class SanityTest extends UIBaseTest {

	
	@Test(enabled=true)
	public void testEasy() throws Exception {
		
		BrowserHelper browserHelper = new BrowserHelper(SessionManager.getDriver());

		browserHelper.open("http://www.guru99.com/selenium-tutorial.html");
		String title = browserHelper.getTitle();
		Assert.assertTrue(title.contains("Selenium Tutorial for Beginners"));
		System.out.println("SANITYTEST1");
		System.out.println(SessionManager.getDriver().toString());
	}
	
	@Test(enabled=true)
	public void sanityTest2() throws Exception {
		
		Assert.assertTrue(true);
	}
	
	@Test(enabled=true)
	public void sanityTest3() throws Exception {
		
		Assert.assertTrue(false);
	}
}