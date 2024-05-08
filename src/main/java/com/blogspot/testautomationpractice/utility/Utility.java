package com.blogspot.testautomationpractice.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;
import org.openqa.selenium.JavascriptExecutor;

import com.blogspot.testautomationpractice.TestBase.TestBase;

public class Utility extends TestBase {
	
	
	
	public void readConfigFile() {
		
		prop=new Properties();
		try {
			
			
			file=new FileInputStream(System.getProperty("user.dir")+"\\config.properties");
			
			prop.load(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void scrollBar(int x, int y) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("scrollBy("+x+","+y+")");
	}
	
	public void brokenLinkCheck(String link) throws IOException {
		URL url=new URL(link);
		HttpURLConnection httpConn=(HttpURLConnection)url.openConnection();
		httpConn.connect();
		
		int resCode=httpConn.getResponseCode();
		if(resCode>=400) {
			System.out.println(url+" is a broken link");
		}
		else {
			System.out.println(url+" is a valid link");
		}
	}

}
