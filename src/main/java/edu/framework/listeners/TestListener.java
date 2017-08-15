package edu.framework.listeners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import edu.framework.base.SessionManager;

public class TestListener implements ITestListener {

	WebDriver driver = null;
	String filePath = System.getProperty("user.dir") + "/screenshots/";
	

	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("***** Error " + result.getName() + " test has failed *****");
		String methodName = result.getName().toString().trim();
		takeScreenShot(methodName);
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("***** Success " + result.getName() + " test has passed *****");
		String methodName = result.getName().toString().trim();
		takeScreenShot(methodName);

	}

	public void takeScreenShot(String methodName) {
		// get the driver
		try {
			driver = SessionManager.getDriver();

			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			// The below method will save the screen shot in d drive with test
			// method name
			FileUtils.copyFile(scrFile, new File(filePath + methodName + System.currentTimeMillis() + ".png"));
			System.out.println("***Placed screen shot in " + filePath + " ***");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
