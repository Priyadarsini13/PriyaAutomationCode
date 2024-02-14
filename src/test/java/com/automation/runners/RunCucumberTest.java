package com.automation.runners;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

 @RunWith(Cucumber.class)
 @CucumberOptions(features="src/test/java/com/automation/features",
 glue="com.automationn.stepdefination",
 plugin = {"html:target/cucumber-html-reports","usage:target/cucumber-json-reports/cucumber-usage.json"},
 strict=true,
 monochrome=true
)
public class RunCucumberTest {

}


