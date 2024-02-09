package com.automationn.stepdefination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepdefination {
	WebDriver driver;
	public static ExtentTest logger;
	
	@Given("User visits e-commerce website")
	public void user_visits_e_commerce_website() {
		
		lunchDriver();
	}

	@When("User enters valid credentials")
	public void user_enters_valid_credentials() {
		System.out.println("User enters valid credentials");
	}

	@Then("User can logged in successfully")
	public void user_can_logged_in_successfully() {
		System.out.println("User can logged in successfully");
	}
	

public void lunchDriver()
{
	try {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Priya\\LocalGit\\BareGitRepo\\CucumberJava\\src\\test\\resources\\driver\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("https://www.jaguarlandrover.com");
	}catch (Exception e) {
		logger.log(Status.FAIL, "Not selected Parent Entity: " + e.toString());
	}
}
}
