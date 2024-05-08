package com.blogspot.testautomationpractice.TestBase;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.blogspot.testautomationpractice.utility.Utility;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static FileInputStream file;
	public static Utility util;
	public static String parentId;
	
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
