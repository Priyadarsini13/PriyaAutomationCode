package com.automationn.stepdefination;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
	WebDriver driver ;
	public static ExtentTest logger;

	@Given("User is navigate to JLR home page sucessfully")
	public void navigateJLRHomePage() {
		lunchHomePage();
	}

	@When("User click on {string} tab")
	public void clickCompanyMenu(String menuItem) {
		
		try {
			// Store all Menu  Locators in list type 
		List<WebElement> mainMenu = driver.findElements(By.xpath("//a[@class='navigation__title navigation__title--padding']"));
		
		for (WebElement e : mainMenu)
		{
			if(e.getText().equalsIgnoreCase(menuItem))
				e.click();
		}
		}
		catch(Exception e)
		{
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
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		}
		catch(Exception e)
		{
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
		
		}
		catch(Exception e)
		{
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
			System.out.println("search ............"+SearchText);
		WebElement searchtextField=driver.findElement(By.xpath("//li[@class='desktop-search__search']//input[@type='search']"));
		enterText(driver,searchtextField,SearchText);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement searchResult=driver.findElement(By.xpath("//a[@class='navigation-search-list__link']"));
		clickItem(driver,searchResult);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	@Then("User should sucessfully serch the product")
	public void user_should_sucessfully_serch_the_produc() {
		try
		{
			WebElement searchResultTitle=driver.findElement(By.xpath("//h1[@class='page-title text-center light-font']"));
			Assert.assertTrue(waitfForElement(driver, searchResultTitle));		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		
	}
	
	@Given("User navigate to news section")
	public void user_click_on_Diversity_and_Inclusion_approach() {
		try
		{
		WebElement latestNews=driver.findElement(By.xpath("//h3[text()='Latest News']"));
		scrollToElement(driver,latestNews);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@When("User click on news")
	public void newsButton() {
		try
		{
			WebElement latestNews=driver.findElement(By.xpath("//h3[text()='Latest News']"));
			clickItem(driver,latestNews);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Then("User should sucessfully open news")
	public void user_should_sucessfully_download() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	public void lunchHomePage() {
		try {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Priya\\LocalGit\\BareGitRepo\\CucumberJava\\src\\test\\resources\\driver\\chromedriver.exe");
			 driver = new ChromeDriver();
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
			System.out.println(e);
			return null;
		}
	}
	
	public static Boolean enterText(WebDriver driver, WebElement ele,String text) 
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

			e.printStackTrace();
			return false;
		}
		
	}
	
	public static void scrollToElement(WebDriver driver,WebElement ele) 
	{
		try
		{

			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(50));
			wait.until(ExpectedConditions.visibilityOf(ele));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
			Thread.sleep(500);
			
		}
		catch(Exception e)
		{

			e.printStackTrace();
			
		}
		 
	}
	public static Boolean waitfForElement(WebDriver driver, WebElement ele)
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(50));
			wait.until(ExpectedConditions.visibilityOf(ele));
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
	}
	@After
	public void cleanUp(){    
		driver.quit();
	}
}
