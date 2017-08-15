package edu.framework.base;

import java.lang.reflect.Method;

import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class APIBaseTest extends BaseTest {
	
	@BeforeMethod(alwaysRun = true)
	public final void mandatoryBeforeTestMethod(Method testMethod, ITestContext context) throws Exception {
		System.out.println("Before Method");
	}

	@AfterMethod(alwaysRun = true)
	public final void mandatoryAfterTestMethod() throws Exception {
		System.out.println("After Method");
	}
}