package com.automationn.stepdefination;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.internal.Utils;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class JLRStepdefination {
	WebDriver driver = new ChromeDriver();
	public static ExtentTest logger;

	@Given("User is navigate to JLR home page sucessfully")
	public void navigateJLRHomePage() {
		lunchHomePage();
	}

	@Given("User click on {string} tab")
	public void clickCompanyMenu(String menuItem) {
		
		try {
			// Store all Menu  Locators in list type 
		List<WebElement> mainMenu = driver.findElements(By.xpath("//a[@class='navigation__title navigation__title--padding']"));
		
		for (WebElement e : mainMenu)
		{
			if(e.getText().equalsIgnoreCase(menuItem))
				e.click();
		}
		logger.log(Status.INFO, "Clicked"+menuItem);
		}
		catch(Exception e)
		{
			logger.log(Status.FAIL, "Unable to click item: " + e.getMessage());
			e.printStackTrace();
		}
		
	}

	@When("User  click on the {string}  option")
	public void clickSubMenu(String subMenuItem) {
		try {
			// Store all Menu  Locators in list type 
		List<WebElement> subMenu = driver.findElements(By.xpath("//a[@class='navigation__title navigation__title--padding']"));
		
		for (WebElement e : subMenu)
		{
			//Check the condition
			if(e.getText().equalsIgnoreCase(subMenuItem))
				e.click();
		}
		logger.log(Status.INFO, "Clicked"+subMenuItem);
		}
		catch(Exception e)
		{
			logger.log(Status.FAIL, "Unable to click item: " + e.getMessage());
			e.printStackTrace();
		}
		
		
	}

	@Then("User should view the {string}  successfully")
	public void verifySubMenuTitle(String subMenuTitle) {
		try {
		WebElement menuTitle=driver.findElement(By.xpath("//div[text()='" +subMenuTitle + "']"));
		getTextofelement(driver,menuTitle);
		String ActualTitle = getTextofelement(driver,menuTitle);	
		Assert.assertEquals(ActualTitle, subMenuTitle);
		cleanUp();
		}
		catch(Exception e)
		{
			logger.log(Status.FAIL, "Unable to verify SubMenu: " + e.getMessage());
			e.printStackTrace();
		}
		
	}

	@Given("User click on search bar")
	public void user_click_on_search_bar() {
		WebElement searchBar=driver.findElement(By.xpath("//i[@class='desktop-search__icon']"));
		clickItem(driver,searchBar);
	}

	@When("User enter the search keyword {string}")
	public void searchkeyword(String SearchText) {
		try
		{
		WebElement searchtextField=driver.findElement(By.xpath("//li[@class='desktop-search__search']//input[@type='search']"));
		WebElement searchResult=driver.findElement(By.xpath("//a[text()='Accessories']"));
		enterText(driver,searchtextField,SearchText);
		clickItem(driver,searchResult);
		}catch(Exception e)
		{
			logger.log(Status.FAIL, "Unable to search item: " + e.getMessage());
			e.printStackTrace();
		}
		
	}

	@Then("User should sucessfully serch the product")
	public void user_should_sucessfully_serch_the_produc() {
		
	}
	

	public void lunchHomePage() {
		try {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Priya\\LocalGit\\BareGitRepo\\CucumberJava\\src\\test\\resources\\driver\\chromedriver.exe");
			// driver = new ChromeDriver();
			//Maximize the window
			driver.manage().window().maximize();
			//Implicitly wait
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//Navigate to URL
			driver.get("https://www.jaguarlandrover.com");
		} catch (Exception e) {
			logger.log(Status.FAIL, "Not selected Parent Entity: " + e.toString());
		}
	}

	public static Boolean clickItem(WebDriver driver, WebElement ele) {
		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(ele));
			Assert.assertTrue(ele.isDisplayed() && ele.isEnabled());
			ele.click();
			return true;
		} catch (Exception e) {
			logger.log(Status.FAIL, "Unable to click item: " + e.getMessage());
			e.printStackTrace();
			return false;
		}

	}
	public static String getTextofelement(WebDriver driver, WebElement ele)
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(ele));
			return ele.getText();
			
		}
		catch(Exception e)
		{
			logger.log(Status.FAIL, "Unable to get Text from element. "+e.getMessage());
			return null;
		}
	}
	
	public static Boolean enterText(WebDriver driver, WebElement ele,String text) throws AssertionError
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(ele));
			ele.click();
			ele.sendKeys(text);
			return true;
		}
		catch(Exception e)
		{
			logger.log(Status.FAIL, "Unable to enter text: "+e.getMessage());
			return false;
		}
		
	}
	 
	public void cleanUp(){    
	      driver.close(); 
	}
}
