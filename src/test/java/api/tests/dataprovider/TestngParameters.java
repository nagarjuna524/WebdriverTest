package api.tests.dataprovider;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestngParameters {

	@Test

	@Parameters({ "sUsername", "sPassword" })

	public void test(String sUsername, String sPassword) {

		System.out.println("testNg parameters");
		System.out.println(sUsername);
		System.out.println(sUsername);
	}
}