Feature: JLR Home page Details 

Background: Navigate to home page
Given User is navigate to JLR home page sucessfully

  Scenario Outline: As a customer ,i would like to Navigate the Menu page
    Given User click on "<menuItem>" tab
    When User  click on the "<subMenuItem>"  option 
    Then User should view the "<subMenuTitle>"  successfully
    
    Examples:
    |menuItem         |subMenuItem             |subMenuTitle|
    |Company          |Overview                |Overview    |
    |BRANDS & SERVICES|Jaguar                  |Jaguar      |
   
    
    Scenario Outline: As a customer, i would like to use Search the opption  in search Tab
    Given User click on search bar
    When User enter the search keyword "<SearchText>"
    Then User should sucessfully serch the product
    
    Examples:
    |SearchText|
    |ACCESSORIES|
    
    Scenario: As a customer, i would like to view new section
    Given User navigate to news section  
    When User click on news 
    Then User should sucessfully open news
  
    