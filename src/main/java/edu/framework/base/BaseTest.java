package edu.framework.base;

import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

@Listeners(edu.framework.listeners.TestListener.class)
public class BaseTest {

	@BeforeSuite
	public void manditoryBeforeSuite(ITestContext context) {
		System.out.println("Before Suite");
	}

	@BeforeTest(alwaysRun = true)
	public final void mandatoryBeforeTest(ITestContext context) {
		System.out.println("Before Test");
	}

	@BeforeClass(alwaysRun = true)
	public void mandatoryBeforeClass(ITestContext context) {
		System.out.println("Before Class");
	}

	@AfterClass(alwaysRun = true)
	public void mandatoryAfterClass(ITestContext context) {
		System.out.println("After Class");
	}

	@AfterTest(alwaysRun = true)
	public void mandatoryAfterTest(ITestContext context) {
		System.out.println("After Test");
	}

	@AfterSuite(alwaysRun = true)
	public void manditoryAfterSuite(ITestContext context) {
		System.out.println("After Suite");
	}
}