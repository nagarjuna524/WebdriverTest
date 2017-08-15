/**
 * 
 */
package api.tests.example;

import org.testng.Assert;
import org.testng.annotations.Test;

import edu.framework.base.APIBaseTest;

/**
 * @author nagarjuna
 * 
 */
public class ApiSmokeTest extends APIBaseTest {
	/**
	 * 
	 */
	public ApiSmokeTest() {
		// TODO Auto-generated constructor stub
	}

	@Test
	public void testSmokeTest1() throws Exception {
		String smokeTest = "SMOKETEST";
		Assert.assertTrue(smokeTest.contains("SMOKETEST"));
		System.out.println("APISMOKETEST1");
	}

	@Test
	public void testSmokeTest2() throws Exception {
		String smokeTest = "SMOKETEST";
		Assert.assertTrue(smokeTest.contains("SMOKETEST"));
		System.out.println("APISMOKETEST2");
	}

	@Test
	public void testSmokeTest3() throws Exception {
		String smokeTest = "SMOKETEST";
		Assert.assertTrue(smokeTest.contains("SMOKETEST"));
		System.out.println("APISMOKETEST3");
	}
}
