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
Feature: Title of your feature
  I want to use this template for my feature file

  Scenario Outline: Successful login with valid credentials
   Given User is on a Login Page
   And Title is matched
   When I enter a valid "<username>" and "<password>"
   Then I can see the Home page
   Then I logout from the applicaiton
   
   Examples:
   	| username | password |
   	|	admin		 | manager 	|
   	|	admin		 | manager 	|
   	|	admin		 | manager 	|
   	