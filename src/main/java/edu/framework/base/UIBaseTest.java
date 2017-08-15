package edu.framework.base;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class UIBaseTest extends BaseTest {

	private Map<String, Object> _customCapabilities;

	@BeforeMethod(alwaysRun = true)
	public void mandatoryBeforeTestMethod(Method testMethod, ITestContext context) throws Exception {
		System.out.println("Before Method");
		SessionManager.startWebSession(testMethod, context, _customCapabilities);
	}

	@AfterMethod(alwaysRun = true)
	public void mandatoryAfterTestMethod() throws Exception {
		System.out.println("After Method");
		boolean DEBUG_MODE = false;
		SessionManager.killAllSessions(!DEBUG_MODE);
	}
}