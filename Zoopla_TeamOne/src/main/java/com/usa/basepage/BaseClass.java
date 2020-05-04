package com.usa.basepage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.usa.Zooplapagefactory.MasterPagefactory;

public class BaseClass {
	protected WebDriver driver;
	protected MasterPagefactory pf;
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/Users/mdhaque/Downloads/chromedriver");
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		driver.get("http://www.zoopla.com");
//		pf=PageFactory.initElements(driver, MasterPagefactory.class);
//		
	}

}
