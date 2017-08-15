package examples.tests;

import org.testng.annotations.Test;

import examples.ConstantsValues;
import examples.helpers.ElectronicsHelper;
import examples.helpers.LoginHelper;

public class LoginTest extends BaseTest {
	
	@Test
	public void testLogin() {
		LoginHelper loginHelper = new LoginHelper(driver);
		ElectronicsHelper electronicsHelper = new ElectronicsHelper(driver);
		loginHelper.login(ConstantsValues.USER_EMAIL, ConstantsValues.USER_PASS);
		electronicsHelper.mouseOverOnElectronics();
		loginHelper.logout();
	}
}
