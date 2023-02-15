Feature: Check information Project page

  Scenario Outline: Check display list on project page
    Given I click on the menu project  
    When I click on the tap latest 
    And I check the information latest project and return project page
    When I click on the tap oldest
    And I check the information oldest project and return project page
    When I click on the tap highest price
    And I check information highest price project and return project page
    And I search project by filter
    And I search project by search bar <input>
    Then I check the project information successfully

    Examples: 
      | input |
      | ABC   |
      