package Utilities;

import java.util.HashMap;

import org.openqa.selenium.*;
import org.openqa.selenium.ie.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebBrowser {
	public static WebDriver driver = null;
	public static String browser = "Chrome";
	public static String baseURL = "https://www.google.co.uk";

	public static WebDriver getDriver() {
		if (driver == null) {

			if (browser.equals("Chrome")) {

				System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bhai\\Desktop\\chromedriver.exe");
				driver = new ChromeDriver();

			}

			else if (browser.equals("IE")) {

				DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
				capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
						true);
				System.setProperty("webdriver.ie.driver",
						"C:\\Users\\900010185\\Downloads\\Drivers\\IEDriverServer.exe");
				driver = new InternetExplorerDriver(capabilities);
			}

			else if (browser.equals("Firefox")) {

				System.setProperty("webdriver.gecko.driver",
						"C:\\Users\\900010185\\Downloads\\Drivers\\geckodriver.exe");
				driver = new FirefoxDriver();

			}
			
			driver.manage().window().maximize();
			driver.navigate().to(baseURL);
		}

	
		return driver;

	}
	
	

}