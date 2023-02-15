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
@postnews
Feature: Post news


  Scenario: Check cancel news post without login as agent
    Given As an agent, I didn't login and navigate to news post page
    Then Alert should be displayed with 'Cancel' and 'Login' button
    Then Navigate to login page when click 'Login' button
    

  @postNewsAsAgent
  Scenario: Post news with agent account
    Given User login as agent account, navigate to post news
    When Select base information
    And Input description information
    And Input payment information
    Then News should be posted succesfully
    

