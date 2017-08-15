package api.tests.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import edu.framework.base.APIBaseTest;

public class DataProviderTest2 extends APIBaseTest {

	// This test method declares that its data should be supplied by the Data
	// Provider
	// "getdata" is the function name which is passing the data
	// Number of columns should match the number of input parameters
	@Test(dataProvider = "getData1")
	public void setData(String username, String password) {
		System.out.println("you have provided username as::" + username);
		System.out.println("you have provided password as::" + password);
	}

	@DataProvider
	public Object[][] getData1() {
		// Rows - Number of times your test has to be repeated.
		// Columns - Number of parameters in test data.
		Object[][] data = new Object[3][2];

		// 1st row
		data[0][0] = "sampleuser1";
		data[0][1] = "abcdef";

		// 2nd row
		data[1][0] = "testuser2";
		data[1][1] = "zxcvb";

		// 3rd row
		data[2][0] = "guestuser3";
		data[2][1] = "pass123";

		return data;
	}

	// This test method declares that its data should be supplied by the Data
	// Provider
	// "getdata" is the function name which is passing the data
	// Number of columns should match the number of input parameters
	@Test(dataProvider = "getData2")
	public void setData2(String username, String password, String uname) {
		System.out.println("you have provided username as::" + username);
		System.out.println("you have provided password as::" + password);
		System.out.println("you have provided password as::" + uname);
	}

	@DataProvider
	public Object[][] getData2() {
		// Rows - Number of times your test has to be repeated.
		// Columns - Number of parameters in test data.
		Object[][] data = new Object[3][3];

		// 1st row
		data[0][0] = "sampleuser1";
		data[0][1] = "abcdef";
		data[0][2] = "abcdef";

		// 2nd row
		data[1][0] = "testuser2";
		data[1][1] = "zxcvb";
		data[1][2] = "zxcvb";

		// 3rd row
		data[2][0] = "guestuser3";
		data[2][1] = "pass123";
		data[2][2] = "zxcvb";
		return data;
	}

	// This test method declares that its data should be supplied by the Data
	// Provider
	// "getdata" is the function name which is passing the data
	// Number of columns should match the number of input parameters
	@Test(dataProvider = "getData3")
	public void setData3(String username) {
		System.out.println("you have provided username as::" + username);
	}

	@DataProvider
	public Object[][] getData3() {
		Object[][] data = new Object[3][1];

		// 1st row
		data[0][0] = "sampleuser1";

		// 2nd row
		data[1][0] = "testuser2";

		// 3rd row
		data[2][0] = "guestuser3";
		return data;
	}
}