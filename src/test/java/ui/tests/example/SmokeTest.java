package src.test.java.ui.tests.example;

import org.testng.Assert;
import org.testng.annotations.Test;

import edu.framework.base.UIBaseTest;
import edu.framework.base.SessionManager;

public class SmokeTest extends UIBaseTest {

	@Test
	public void testSmokeTest1() throws Exception {
		String smokeTest = "SMOKETEST";
		Assert.assertTrue(smokeTest.contains("SMOKETEST"));
		System.out.println("SMOKETEST1");
		System.out.println(SessionManager.getDriver().toString());
	}

	@Test(enabled=true)
	public void testSmokeTest2() throws Exception {
		String smokeTest = "SMOKETEST";
		Assert.assertTrue(smokeTest.contains("SMOKETEST"));
		System.out.println("SMOKETEST2");
		System.out.println(SessionManager.getDriver().toString());
	}

	@Test(enabled=true)
	public void testSmokeTest3() throws Exception {
		String smokeTest = "SMOKETEST";
		Assert.assertTrue(smokeTest.contains("SMOKETEST"));
		System.out.println("SMOKETEST3");
		System.out.println(SessionManager.getDriver().toString());
	}
}