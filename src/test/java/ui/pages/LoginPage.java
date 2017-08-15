package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Contains all the objects related to LoginPage
 * 
 * @author scherukuri
 * @Date 10/03/2015
 *
 */
public class LoginPage {

	public LoginPage(WebDriver driver) {
		this.driver = driver;

	}
	
	public LoginPage() {
	}

	WebDriver driver;
	long TIMEOUT_IN_SECS = 60;

	public static By userName = By.xpath("//div[contains(@id, 'row_public')]");
	public WebElement passWord = driver.findElement(By.xpath("//div[@id='password']"));

	public WebElement username() {
		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT_IN_SECS);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userName")));
		return element;
	}

	public WebElement password() {
		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT_IN_SECS);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userName")));
		return element;
	}

	// public static WebElement username(WebDriver driver) {
	// WebDriverWait wait = new WebDriverWait(driver, TIMEOUT_IN_SECS);
	// WebElement element = wait.until(
	// ExpectedConditions.visibilityOfElementLocated(By.id("userName")));
	// return element;
	// }
	//
	// public static WebElement usernameEmail(WebDriver driver) {
	// WebDriverWait wait = new WebDriverWait(driver, TIMEOUT_IN_SECS);
	// WebElement element = wait.until(
	// ExpectedConditions.visibilityOfElementLocated(By.id("emailAddress")));
	// return element;
	// }
	//
	// public static WebElement password(WebDriver driver) {
	// WebDriverWait wait = new WebDriverWait(driver, TIMEOUT_IN_SECS);
	// WebElement element = wait.until(
	// ExpectedConditions.visibilityOfElementLocated(By.id("passWord")));
	// return element;
	// }
	//
	// public static WebElement signIn(WebDriver driver) {
	// WebDriverWait wait = new WebDriverWait(driver, TIMEOUT_IN_SECS);
	// WebElement element = wait.until(
	// ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='signInButton1']/span")));
	// return element;
	// }
	//
	// public static WebElement btnContinue(WebDriver driver) {
	// WebDriverWait wait = new WebDriverWait(driver, TIMEOUT_IN_SECS);
	// WebElement element = wait.until(
	// ExpectedConditions.visibilityOfElementLocated(By.id("continueButton")));
	// return element;
	// }
}