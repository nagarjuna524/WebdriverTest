package edu.framework.base;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionDriver {

	WebDriver driver;
	WebDriverWait webDriverWait;

	public ActionDriver() {
	}

	public ActionDriver(WebDriver driver) {
		this.driver = driver;
	}

	public boolean type(WebElement element, String testdata) throws Exception {
		try {
			element.clear();
			element.sendKeys(testdata);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public boolean type(By by, String testdata) throws Exception {
		return false;
	}
	
	public void click(WebElement element) throws Exception {
		webDriverWait = new WebDriverWait(driver, 60);
		webDriverWait.until(ExpectedConditions.visibilityOf(element));
		element.click();
	}
}