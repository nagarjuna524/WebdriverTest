package edu.framework.helpers;

import org.openqa.selenium.WebDriver;

import edu.framework.base.SessionManager;

public class BrowserHelper {
	private WebDriver _driver;

	/**
	 * Default constructor. Uses the current active session for interacting with
	 * the browser.
	 */
	public BrowserHelper() {
	}

	/**
	 * Create an instance that uses the supplied WebDriver for interacting with
	 * the browser.
	 *
	 * @param driver
	 *            WebDriver to execute commands against
	 */
	public BrowserHelper(WebDriver driver) {
		_driver = driver;
	}

	/**
	 * opens the link in the browser
	 *
	 * @param link
	 *            Link to be opened in the browser
	 * @throws Exception
	 * @throws HelperException
	 * @throws BaseException
	 */
	public void open(String link) throws Exception {
		getDriver().get(link);

	}
	

	  /**
	   * Get the title of the page.
	 * @throws Exception 
	   */
	  public String getTitle() throws Exception {
	    return getDriver().getTitle();
	  }

	/**
	 * Close the current window, quitting the browser if it's the last window
	 * currently open.
	 * 
	 * @throws Exception
	 */
	public void close() throws Exception {
		getDriver().close();
	}

	protected WebDriver getDriver() throws Exception {
		try {
			return _driver != null ? _driver : SessionManager.getDriver();
		} catch (Exception e) {
			throw new Exception("Error getting driver: " + e.getMessage());
		}
	}
}
