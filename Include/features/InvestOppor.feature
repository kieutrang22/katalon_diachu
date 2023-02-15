Feature: Check Investment Opportunity Page Functionality 

  Scenario: Check information Investment Opportunity page
    Given I click on the menu Investment Opportunity    
    When I check the information latest
    And I click on oldest tap
    And I check the information oldest
    And I check infomation filter
    Then I verify the status in step is successfully