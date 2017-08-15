package edu.framework.utils;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

/*
 * Class is used to execute failed tests using testng.xml file
 */

public class TestRunner {

	public static void main(String[] args) {

		String failedTestsPath = System.getProperty("user.dir") + "/test-output/testng-failed.xml";
		TestNG testng = new TestNG();
		System.out.println(failedTestsPath);
		List<String> list = new ArrayList<String>();
		list.add(failedTestsPath);

		testng.setTestSuites(list);
		testng.run();
	}
}