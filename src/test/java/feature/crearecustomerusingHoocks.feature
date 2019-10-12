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
    Given User is on customer creation page
    When i enter a customer "firstBDDCust101" and "firstBDDCust-Desc"
    Then I should be able to create customer
    And validate custmer creation success message

  @regression
  Scenario Outline: Multiple Customer Creation
    Given User is on customer creation page
    When i enter a customer "<CustomerName>" and "<CustomerDescription>"
    Then I should be able to create customer
    And validate custmer creation success message

    Examples: 
      | CustomerName  | CustomerDescription |
      | BDDCustomer9  | BDDCust-desc1       |
      | BDDCustomer90 | BDDCust-desc2       |
      | BDDCustomer91 | BDDCust-desc3       |
      | BDDCustomer92 | BDDCust-desc4       |
      | BDDCustomer93 | BDDCust-desc5       |
      | BDDCustomer94 | BDDCust-desc6       |
