Feature: Test search bar

  Scenario Outline: Check the functionality of the search bar
    in Real Estates for sale

    Given I am on Real Estates for sale page
    When I input <realEstates> in the search bar in Real Estate page
    Then I verify the result in the Real Estates list
    And I clear the search bar

    Examples: 
      | realEstates    |
      | biệt thự       |
      | Quận Long Biên |
      | asabasd        |

  Scenario Outline: Check the functionality of the search bar
    in Real Estates for rent

    Given I am on Real Estates for rent page
    When I input <realEstates> in the search bar in Real Estate page
    Then I verify the result in the Real Estates list
    And I clear the search bar

    Examples: 
      | realEstates     |
      | Dương Quảng Hàm |
      | Hà Đông         |
      | asdasdvsc       |
