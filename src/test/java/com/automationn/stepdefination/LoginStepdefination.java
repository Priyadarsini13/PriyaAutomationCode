package com.automationn.stepdefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepdefination {
	@Given("User visits e-commerce website")
	public void user_visits_e_commerce_website() {
	    System.out.println("User visits e-commerce website");
	}

	@When("User enters valid credentials")
	public void user_enters_valid_credentials() {
		System.out.println("User enters valid credentials");
	}

	@Then("User can logged in successfully")
	public void user_can_logged_in_successfully() {
		System.out.println("User can logged in successfully");
	}

}
