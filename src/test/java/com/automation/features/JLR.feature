Feature: JLR Home page Details 

Background:
Given User is navigate to JLR home page sucessfully

  Scenario Outline: Navigate the Company over view page
    Given User click on "<menuItem>" tab
    When User  click on the "<subMenuItem>"  option 
    Then User should view the "<subMenuTitle>"  successfully
    
    Examples:
    |menuItem         |subMenuItem|subMenuTitle|
    |Company          |Overview   |Overview    |
    |BRANDS & SERVICES|Jaguar     |Jaguar      |
    
    Scenario Outline: Search the ACCESSORIES in search Tab
    Given User click on search bar
    When User enter the search keyword "<SearchText>"
    Then User should sucessfully serch the product
    
    Examples:
    |SearchText|
    |ACCESSORIES|
    