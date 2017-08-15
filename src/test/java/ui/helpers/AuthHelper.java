package ui.helpers;

import org.openqa.selenium.WebDriver;

import edu.framework.base.ActionDriver;
import ui.pages.LoginPage;

public class AuthHelper {

	WebDriver driver;
	ActionDriver actionDriver;

	public AuthHelper() {
	}

	public AuthHelper(WebDriver driver) {
		this.driver = driver;
	}

	LoginPage loginPage = new LoginPage();

	public void signIn(String username, String password) throws Exception {
		actionDriver.type(loginPage.username(), username);
		actionDriver.type(loginPage.password(), password);
		
		actionDriver.type(loginPage.userName, username);
		

	}
}
