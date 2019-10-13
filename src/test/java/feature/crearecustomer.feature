#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Creating customer
  description creating a valid customer

  @sanity
  Scenario: Customer Creation
    Given User is on a Login Page
    And Title is matched
    When I enter a valid "admin" and "manager"
    Then I can see the Home page
    Then User is on customer creation page
    When i enter a customer "firstBDDCust101" and "firstBDDCust-Desc"
    Then I should be able to create customer
    And validate custmer creation success message
    And Logout of the application

  @regression
  Scenario Outline: Multiple Customer Creation
    Given User is on a Login Page
    And Title is matched
    When I enter a valid "admin" and "manager"
    Then I can see the Home page
    Then User is on customer creation page
    When i enter a customer "<CustomerName>" and "<CustomerDescription>"
    Then I should be able to create customer
    And validate custmer creation success message
    And Logout of the application

    Examples: 
      | CustomerName | CustomerDescription |  
      | BDDCustomer211 | BDDCust-desc1       |  
      | BDDCustomer222 | BDDCust-desc2       |  
      | BDDCustomer23 | BDDCust-desc3       |  
      | BDDCustomer24 | BDDCust-desc4       |  
      | BDDCustomer25 | BDDCust-desc5       |  
      | BDDCustomer26 | BDDCust-desc6       |  
