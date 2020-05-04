package com.usa.basepage;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;


public class SupperClass {
	public static WebDriver driver;
	public static Properties prop;
	public static Logger logger;
	
	public  SupperClass() { 
		logger = Logger.getLogger("QA Testing"); 
		PropertyConfigurator.configure("Log4j.properties");
		prop = new Properties();
		try {
			FileInputStream file = new FileInputStream(
					System.getProperty("user.dir") + "/Config.properties");
			prop.load(file);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	public final  void initialization() {
		String browser = prop.getProperty("browser");

		if (browser.equalsIgnoreCase("Firefox")) {
			logger.info("******** I am a firefox browser*********");
			System.setProperty("webdriver.gecko.driver", "/Users/mohammedalam/geckodriver");
			System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
			System.out.println("getFirefoxDriver Method is running on Thread :: " + Thread.currentThread().getId());
			driver = new FirefoxDriver();
			

		} else if (browser.equalsIgnoreCase("IE")) {
			logger.info("******** I am a ie browser*********");
			System.setProperty("webdriver.ie.driver", "./Driver/IEDriverServer.exe");
			System.out.println("getIEDriver Method is running on Thread : " + Thread.currentThread().getId());
			driver = new InternetExplorerDriver();

		} else if (browser.equalsIgnoreCase("Edge")) {
			logger.info("******** I am a edge browser*********");
			System.setProperty("webdriver.edge.driver", "./Driver/MicrosoftWebDriver.exe");
			System.out.println("GetEdgeMethod is running on Thread : " + Thread.currentThread().getId());
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("Safari")) {
			logger.info("******** I am a safari browser*********");
			System.out.println("getSafariDriver Method is running on Thread : " + Thread.currentThread().getId());
			driver = new SafariDriver();
		} else if (browser.equalsIgnoreCase("Chrome")) {
			logger.info("******** I am a Chrome browser*********");
			System.setProperty("webdriver.chrome.driver", "/Users/mdhaque/Downloads/chromedriver");
			
			System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
			Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
			System.out.println("getChormeDriver Method is running on Thread : " + Thread.currentThread().getId());
			driver = new ChromeDriver();
		} else if (browser.equals("headless")) {
			logger.info("******** I am a headless browser*********");
			System.setProperty("webdriver.chrome.driver", "/Users/mdhaque/Downloads/chromedriver");
			//System.setProperty("webdriver.chrome.driver", "/Users/mdhaque/Downloads/chromedriver");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200",
					"--ignore-certificate-errors", "--silent");
			driver = new ChromeDriver(options);
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("URL"));
	}

	public static void InitializeCucumberBDD() {
		logger.info("******** I am a chrome browser *********");
		System.setProperty("webdriver.chrome.driver", "/Users/mdhaque/Downloads/chromedriver");
		//System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
		Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
		System.out.println(" getChormeDriver Method is running on Thread : " + Thread.currentThread().getId());
		driver = new ChromeDriver();
		logger.info("******** I am maximaize the browser *********");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		
	}
	
	
}
