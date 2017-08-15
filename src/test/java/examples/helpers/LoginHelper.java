package examples.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import examples.pages.LoginPage;

public class LoginHelper {
	WebDriver driver;
	
	public LoginHelper(WebDriver driver) {
		this.driver = driver;
	}
	
	public void login(String userEmail, String userPassword) {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickLoginLink();
		loginPage.setuserEmail(userEmail);
		loginPage.setuserPassword(userPassword);
		loginPage.clickOnLoginButton();  
	}
	
	public void logout() {
		LoginPage loginPage = new LoginPage(driver);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.cssSelector(".greeting-link"))).perform();
		loginPage.clickOnLogout();
	}
}
