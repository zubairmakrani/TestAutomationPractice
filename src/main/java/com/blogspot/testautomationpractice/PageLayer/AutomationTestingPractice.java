package com.blogspot.testautomationpractice.PageLayer;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.blogspot.testautomationpractice.TestBase.TestBase;

public class AutomationTestingPractice extends TestBase {
	
	//Declaration and initialization of the web elements 
	

	//Object repository
	@FindBy(xpath="//h1[contains(text(),'Automation Testing Practice')]")
	private WebElement heading;
	
	@FindBy(xpath="//input[@id='name']")
	private WebElement name;
	
	@FindBy(xpath="//input[@id='email']")
	private WebElement email;
	
	@FindBy(xpath="//input[@id='phone']")
	private WebElement phone;
	
	@FindBy(xpath="//textarea[@class='form-control']")
	private WebElement address;
	
	@FindBy(xpath="//input[@id='male']")
	private WebElement radioBtnMale;
	
	@FindBy(xpath = "//div[@class='form-check form-check-inline']//input[@type='checkbox']")
	private List<WebElement> checkBoxes;
	
	@FindBy(xpath = "//select[@id='country']/option")
	private List<WebElement> countryDrpdown;
	
	@FindBy(xpath = "//input[@id='Wikipedia1_wikipedia-search-input']")
	private WebElement searchBar;
	
	@FindBy(xpath = "//input[@class='wikipedia-search-button']")
	private WebElement searchBtn;
	
	@FindBy(xpath = "//div[@id='wikipedia-search-result-link']/a")
	private List<WebElement> links;
	
	@FindBy(xpath = "//div[@id='Wikipedia1_wikipedia-search-results']//div[@id='wikipedia-search-result-link']/a")
	private List<WebElement> searchResult;
	
	//Constructor declaration should take place
	
	public AutomationTestingPractice(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	//Action methods or usage 
	
	public void varify_heading(String header) {
		header=heading.getAccessibleName();
		System.out.println(header);
		//log.info("Varify the Heading");
		Assert.assertEquals(header.trim(), "Automation Testing Practice");
		
	}
	
	public void varify_name(String username) {
		//log.info("Varify the Name Field is Enable");
		Assert.assertTrue(name.isEnabled());
		name.clear();
		name.sendKeys(username);
	}
	
	public void varify_email(String userEmail) {
	//	log.info("Varify the Email field is enable");
		Assert.assertTrue(email.isEnabled());
		email.clear();
		email.sendKeys(userEmail);
	}
	
	public void varify_phone(String userPhone) {
	//	log.info("Varify the Phone field is enable");
		Assert.assertTrue(phone.isEnabled());
	//	log.info("Clear the Phone field before providing the input");
		phone.clear();
		phone.sendKeys(userPhone);
		//log.info(userPhone+" is typed into the phone field");
	}
	
	public void varify_address(String userAddress) {
		Assert.assertTrue(address.isEnabled());
		address.clear();
		address.sendKeys(userAddress);
	}
	
	public void selectRadioBtn() {
		Assert.assertFalse(radioBtnMale.isSelected());
		radioBtnMale.click();
	}
	
	public void selectCheckBoxes() {
		int count=checkBoxes.size();
		System.out.println(count);
		for(WebElement checkbox:checkBoxes) {
			String day=checkbox.getAttribute("id");
			if(day.equalsIgnoreCase("Tuesday")||day.equalsIgnoreCase("Thursday")||day.equalsIgnoreCase("Saturday")) {
				System.out.println(day); 
				Assert.assertFalse(checkbox.isSelected());
				checkbox.click(); 
				System.out.println(day+" is selected successfully");
			}
			
		}
	}
	
	public void selectCountryDropdown(String specificCountry) {
		int countCountry=countryDrpdown.size();
		System.out.println(countCountry);
		for(WebElement country:countryDrpdown) {
			String countryName=country.getText();
			System.out.println(countryName);
			if(countryName.equalsIgnoreCase(specificCountry)) {
				Assert.assertFalse(country.isSelected());
				country.click();
				System.out.println(countryName+" is selected successfully");
				
			}
		}
	}
	
	public void varifySearchBar(String input) {
		searchBar.clear();
		searchBar.sendKeys(input);
	}
	public void clickOnSearchButton() {
		Assert.assertTrue(searchBtn.isDisplayed());
		searchBtn.click();
	}
	
	public void varifyBrokenLinks() throws IOException {
		int countLinks=links.size();
		System.out.println(countLinks);
		for(WebElement link:links) {
			String linkText=link.getAttribute("href");
			util.brokenLinkCheck(linkText);
		}
	}
	
	public void varifySearchResults() {
		int results=searchResult.size();
		System.out.println(results);
		
		for(WebElement searchres:searchResult) {
			String displayName=searchres.getText();
			String link=searchres.getAttribute("href");
			System.out.println(displayName+" is the search result Displayed with the hyperlink "+link);
			searchres.click();
			String currentPageTilte=driver.getTitle();
			System.out.println(currentPageTilte);
		}
		Set<String> childId=driver.getWindowHandles();
		for(String currentWindowId:childId) {
			driver.switchTo().window(currentWindowId);
			String CurrentPageTitle=driver.getTitle();
			System.out.println(CurrentPageTitle);
			if(!parentId.equalsIgnoreCase(currentWindowId)) {
				driver.close();
			}
		}
		
		
	}
	
}
