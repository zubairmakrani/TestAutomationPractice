package com.blogspot.testautomationpractice.TestLayer;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.blogspot.testautomationpractice.PageLayer.AutomationTestingPractice;
import com.blogspot.testautomationpractice.TestBase.TestBase;

//@Listeners(com.blogspot.testautomationpractice.utility.ListenerSetup.class)
public class AutomationTestingPracticePageTest extends TestBase {

	
	@Test
	public void automationTestingPractice_functionality() throws IOException {
		
		AutomationTestingPractice ap=new AutomationTestingPractice(driver);
		ap.varify_heading("abd");
		ap.varify_name("spgji");
		ap.varify_email("zub@san.com");
		ap.varify_phone("5629814564");
		ap.varify_address("ashfuiawwic");
		ap.selectRadioBtn();
		ap.selectCheckBoxes();
		util.scrollBar(0,500);
		ap.selectCountryDropdown("India");
		util.scrollBar(0, -500);
		ap.varifySearchBar("Selenium");
		ap.clickOnSearchButton();
		ap.varifyBrokenLinks();
		ap.varifySearchResults();
	}

}

//Excel sheet BDD Git CI/CD 