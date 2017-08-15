package examples.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	WebDriver driver;
	
	By loginLink = By.cssSelector(".js-login");
	By userEmail = By.cssSelector(".user-email");
	By userPassword = By.cssSelector(".user-pwd");
	By loginButton = By.cssSelector(".login-btn");
	By greetingElement = By.cssSelector(".greeting-link");
	By logoutLink = By.linkText("Logout");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickLoginLink() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(loginLink));
		driver.findElement(loginLink).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(userEmail));
	}
	
	public void setuserEmail(String struserEmail) {
		driver.findElement(userEmail).sendKeys(struserEmail);
	}
	
	public void setuserPassword(String struserPassword) {
		driver.findElement(userPassword).sendKeys(struserPassword);
	}
	public void clickOnLoginButton() {
		driver.findElement(loginButton).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(greetingElement));
	}
	public void clickOnLogout() {
		driver.findElement(logoutLink).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(loginLink));
	}
}
