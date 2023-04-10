package com.cucmber.assignment.driverFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverFactory {
	
	private static final Logger logger = LogManager.getLogger(WebDriverFactory.class);
	
	private static WebDriver driver=null;
	
	public static WebDriver getWebDriverForBrowser(String browser) throws Exception{
		switch(browser.toLowerCase()) {
		
		case "chrome":
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		logger.info("browser got invoked:->"+browser);
		break;
		
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			logger.info("Browser got invoked:->"+browser);
			break;
			
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
			default:
				logger.info("NO such browser exist"+browser);
				throw new Exception("NO such browser exist");
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		return driver;
	}
	
	public static void navigateToURL(String URL) {
		driver.get(URL);
		logger.info("navigating to:->"+URL);
	}
	
	public static void closeBrowser() {
		driver.quit();
		
	}
	
	public static String getBrowserName() {
		String defaultBrowser = "chrome";
		String browserFromCMD= System.getProperty("browser");
		if(browserFromCMD==null) {
			return defaultBrowser;
		}
		else {
			return browserFromCMD;
		}
		
	}

}
