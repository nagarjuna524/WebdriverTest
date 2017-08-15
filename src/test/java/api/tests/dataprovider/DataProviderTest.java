package api.tests.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import edu.framework.base.APIBaseTest;

public class DataProviderTest extends APIBaseTest {

	@DataProvider(name = "Authentication1")
	public static Object[][] credentials1() {
		return new Object[][] { { "testuser_1", "Test@1234" }, { "testuser_2", "Test@5678" },
				{ "testuser_3", "Test@1357" } };
	}

	@Test(dataProvider = "Authentication1")
	public void testDataProvider1(String sUsername, String sPassword) {
		System.out.println("First data provider test");
		System.out.println(sUsername);
		System.out.println(sPassword);
	}
}