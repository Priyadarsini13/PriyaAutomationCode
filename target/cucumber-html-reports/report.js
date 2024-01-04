$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/com/automation/features/Login.feature");
formatter.feature({
  "name": "Login to an e-commerce website",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Verify users can login to portal with valid credentials",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "User visits e-commerce website",
  "keyword": "Given "
});
formatter.match({
  "location": "com.automationn.stepdefination.LoginStepdefination.user_visits_e_commerce_website()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User enters valid credentials",
  "keyword": "When "
});
formatter.match({
  "location": "com.automationn.stepdefination.LoginStepdefination.user_enters_valid_credentials()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User can logged in successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "com.automationn.stepdefination.LoginStepdefination.user_can_logged_in_successfully()"
});
formatter.result({
  "status": "passed"
});
});