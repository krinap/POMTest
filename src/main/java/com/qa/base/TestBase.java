package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.utils.TestUtils;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	// redirect to the properties file
	public TestBase() {
		// call the driver and set the properties
		prop = new Properties();

		FileInputStream fi;
		try {
			fi = new FileInputStream("D:\\Learning_Selenium\\Selenium_Workspace"
					+ "\\POMTest\\src\\main\\java\\com\\qa\\configFiles\\Config.properties");
			prop.load(fi);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}

	// Initialize the driver
	public static void intilization() {
	

		String browserName = prop.getProperty("browser");

		if (browserName.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\Learning_Selenium\\Selenium_Jars\\geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Learning_Selenium\\Selenium_Jars\\chromedriver.exe");
			driver = new ChromeDriver();

		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	    driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));
	}

}
