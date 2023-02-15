Feature: Test moving between sell and rental Real Estate screens

  Scenario: I click on Real Estates for sale
   	Given I am on the Home Page
    When I click on Real Estates for sale
    Then I got redirected to Real Estates for sale page
    And I navigate back to the main page

  Scenario: I click on view all Real Estates for sale
  	Given I am on the Home Page
  	When I click on view all Real Estates for sale
  	Then I got redirected to Real Estates for sale page
  	And I navigate back to the main page
  	
  Scenario: I click on the Latest Real Estates for sale
  	Given I am on Real Estates for sale page 
  	When I click on sort Real Estates by latest news 
  	Then I got redirected to Real Estates latest news page
  	And I navigate back to the main page
  	
  Scenario: I click on the Oldest Real Estates for sale 
  	Given I am on Real Estates for sale page
  	When I click on sort Real Estates by oldest news 
  	Then I got redirected to Real Estates oldest news page
  	And I navigate back to the main page
  	
  Scenario: I click on sort by Highest price Real Estates for sale
  	Given I am on Real Estates for sale page 
  	When I click on sort Real Estates by highest price news 
  	Then I got redirected to Real Estates highest price news page
  	And I navigate back to the main page
  	
  Scenario: I click on Real Estates for rent
  	Given I am on the Home Page
  	When I click on Real Estates for rent
  	Then I got redirected to Real Estates for rent page
  	And I navigate back to the main page
  	
  Scenario: I click on view all Real Estates for rent
  	Given I am on the Home Page
  	When I click on view all rental Real Estates
  	Then I got redirected to Real Estates for rent page
  	And I navigate back to the main page
  	
  Scenario: I click on the Latest Real Estates for rent
  	Given I am on Real Estates for rent page 
  	When I click on sort Real Estates by latest news 
  	Then I got redirected to Real Estates latest news page
  	And I navigate back to the main page
  	
  Scenario: I click on the Oldest Real Estates for rent 
  	Given I am on Real Estates for rent page
  	When I click on sort Real Estates by oldest news 
  	Then I got redirected to Real Estates oldest news page
  	And I navigate back to the main page
  	
  Scenario: I click on sort by Highest price Real Estates for rent
  	Given I am on Real Estates for rent page 
  	When I click on sort Real Estates by highest price news 
  	Then I got redirected to Real Estates highest price news page
  	And I navigate back to the main page
  	
  	