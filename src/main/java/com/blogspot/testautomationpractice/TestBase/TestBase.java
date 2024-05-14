package com.blogspot.testautomationpractice.TestBase;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.blogspot.testautomationpractice.utility.Utility;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static FileInputStream file;
	public static Utility util;
	public static String parentId;
	public static Logger log;
	
	@BeforeSuite
	public void startMethod() {
		log=Logger.getLogger("Test Automation Practice");
		PropertyConfigurator.configure("Log4j.properties");
		log.info("Framework execution is started");
	}
	
	@AfterSuite
	public void endMethod() {
		log.info("framework execution is ended");
	}
	
	@BeforeMethod
	public void setUp() throws IOException {
	    driver=new ChromeDriver();
	    util=new Utility();
	    util.readConfigFile();
	    driver.get(prop.getProperty("URL"));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		parentId=driver.getWindowHandle();
		
		
	}
	
	@AfterMethod
	public void teardown() {
		//driver.quit();
	}
	
}
