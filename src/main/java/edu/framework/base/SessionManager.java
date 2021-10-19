package edu.framework.base;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.testng.ITestContext;

public class SessionManager {

	private static Map<Long, LinkedHashMap<SessionId, Session>> _sessions = new ConcurrentHashMap<>();
	private static Map<Long, Session> _activeSessions = new ConcurrentHashMap<>();
	private static Property configProps = new Property("config.properties");
	private static AtomicInteger _sessionCount = new AtomicInteger();

	public static void startWebSession(Method testMethod, ITestContext context, Map<String, Object> _customCapabilities)
			throws MalformedURLException {
		
		WebDriver driver = null;
		Session session = null;
		String browserName =  configProps.getProperty("browserName");
		String hostName = configProps.getProperty("hostName");
		String hostUrl = configProps.getProperty("hostUrl");

		String OSNAME = System.getProperty("os.name").toLowerCase();
		String path = System.getProperty("user.dir");
		
		
		switch (browserName) {

		case "firefox":

			if (OSNAME.contains("windows")) {
				System.setProperty("webdriver.gecko.driver", path + "/drivers/windows32/geckodriver.exe");
			} else {
				System.setProperty("webdriver.gecko.driver", path + "/drivers/linux32/geckodriver");
			}

			if (hostName.equals("localhost")) {
				driver = new FirefoxDriver();
				} else if (hostName.equals("supergrid")) {
				DesiredCapabilities capability = DesiredCapabilities.firefox();
				capability.setBrowserName("firefox");
				driver = new RemoteWebDriver(new URL(hostUrl), capability);	
			}
			break;

		case "chrome":
			
			if (OSNAME.contains("windows")) {
				System.setProperty("webdriver.chrome.driver", path + "/drivers/windows32/chromedriver.exe");
			} else {
				System.setProperty("webdriver.chrome.driver", path + "/drivers/linux32/chromedriver");	
			}
			
			if (hostName.equals("localhost")) {
				driver = new ChromeDriver();				
			} else if (hostName.equals("supergrid")) {
				DesiredCapabilities capability = DesiredCapabilities.chrome();
				capability.setBrowserName("chrome");
				driver = new RemoteWebDriver(new URL(hostUrl), capability);	
			}
			break;
		}

		driver.manage().window().maximize();

		session = addSession(driver);
		session.getDriver().manage().window().maximize();
		session.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	private static class Session {

		private WebDriver _driver;
		private SessionId _sessionId;
		private String _gridUrl;

		public Session(WebDriver driver) {

			_driver = driver;
			_sessionId = ((RemoteWebDriver) _driver).getSessionId();
		}

		public WebDriver getDriver() {
			return _driver;
		}

		public SessionId getSessionId() {
			return _sessionId;
		}

		@SuppressWarnings("unused")
		public void setGridUrl(String gridUrl) {
			_gridUrl = gridUrl;
		}

		@SuppressWarnings("unused")
		public String getGridUrl() {
			return _gridUrl;
		}
	}

	private static Session addSession(WebDriver driver) {

		long threadId = Thread.currentThread().getId();

		LinkedHashMap<SessionId, Session> sessions = _sessions.get(threadId);

		if (sessions == null) {

			sessions = new LinkedHashMap<>();

			_sessions.put(threadId, sessions);

		}

		Session session = new Session(driver);

		sessions.put(session.getSessionId(), session);

		_activeSessions.put(threadId, session);

		return session;

	}

	/**
	 * Gets the driver instance.
	 *
	 * @return driver Return the driver instance if exist
	 * @throws Exception if Driver instance is null
	 */

	public static WebDriver getDriver() throws Exception {
		return getSession().getDriver();
	}

	private static Session getSession() throws Exception {
		long threadId = Thread.currentThread().getId();
		LinkedHashMap<SessionId, Session> sessions = _sessions.get(threadId);
		if (sessions == null || sessions.isEmpty()) {
			throw new Exception("No valid session available");
		}
		return _activeSessions.get(threadId);
	}

	/**
	 * Kill all sessions associated with this thread.
	 *
	 * @param quitSession
	 *            Whether to quit the underlying session
	 */
	public static void killAllSessions(boolean DEBUG_MODE) {
		long threadId = Thread.currentThread().getId();
		LinkedHashMap<SessionId, Session> sessions = _sessions.get(threadId);
		if (sessions == null) {
			return;
		}

		while (!sessions.isEmpty()) {
			killSession(DEBUG_MODE);
		}
		_sessions.remove(threadId);

	}

	/**
	 * Kill this session. Switches to the last created session if available.
	 *
	 * @param quitSession
	 *            Whether to quit underlying session
	 */
	public static void killSession(boolean quitSession) {
		long threadId = Thread.currentThread().getId();
		LinkedHashMap<SessionId, Session> sessions = _sessions.get(threadId);
		if (sessions == null) {
			return;
		}
		if (!sessions.isEmpty()) {
			try {
				Session session = getSession();
				if (quitSession) {
					session.getDriver().quit();
				}
				sessions.remove(session.getSessionId());
				if (sessions.size() > 0) {
					List<Entry<SessionId, Session>> s = new ArrayList<>(sessions.entrySet());
					_activeSessions.put(threadId, s.get(s.size() - 1).getValue());
				} else {
					_activeSessions.remove(threadId);
				}
			} catch (Exception e) {
				e.printStackTrace(); // "Failed to get driver and quit session."
			}
			_sessionCount.decrementAndGet();
			if (sessions.isEmpty()) {
				_sessions.remove(threadId);
			}
		}
	}
}