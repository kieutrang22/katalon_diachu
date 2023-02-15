
@tag
Feature: Search and filter

	@SortFilterResults
  Scenario Outline: Sort filter results
    Given User tap <real estate type> in header bar
    And Tap sort type <sort type> 
   	Then Posts should be displayed in the correct <sort type> 
   	   
    Examples:
	    |	real estate type	|	sort type		|
	    |	Nhà đất cho thuê	|	Mới nhất		|			
	    |	Nhà đất cho thuê	|	Cũ nhất			|				
	    |	Nhà đất cho thuê	|	Giá cao nhất|	
	    |			Nhà đất bán		|	Mới nhất		|			
	    |			Nhà đất bán		|	Cũ nhất			|				
	    |			Nhà đất bán		|	Giá cao nhất|			
	    |						Dự án		|	Giá cao nhất|	
	    |			Cơ hội đầu tư	|	Cũ nhất			|


  @filterHomPageFromDataFile
  Scenario Outline: Filter home page from data file
    Given User navigate to filter and select <type>
    When Filter <type> form data file
    Then Posts that match the filter should be displayed
    
    Examples:
	    |	type						|	
	 		|	Nhà đất bán			|	
	    |	Nhà đất cho thuê|
	    |	Dự án						|
	    
	    
	@filterRandomForHeaderBar
  Scenario Outline: Filter random in each tab
    Given User tap <real estate type> in header bar
    When User navigate to filter and select <type>
    And Filter <type> by random option
    Then Posts that match the filter should be displayed
     
    Examples:
	    |real estate type|
	    |Nhà đất cho thuê|
	    |Nhà đất bán		|
	    |Dự án					|
	    |Cơ hội đầu tư	|
	      
#	@filterHomPage
  #Scenario Outline: Filter home page
    #Given User navigate to filter and select <type>
    #When Filter <realType> <city> <distric> <area> <price> <numberOfBedRooms> for <type>
    #Then Posts that match the filter should be displayed
    #
    #Examples:
#	    |	type							|	realType	|	city		|	distric					|	area				|	price			|	numberOfBedRooms	|
#			| Nhà đất bán       | Nhà riêng | Hà Nội  |Quận Hoàng Mai   | 30 - 50 m2  |3 - 5 tỉ   |    4+             |
#	  
	    
	    
	@searchKeywordForHeaderBar
	Scenario Outline: Search keyword For Header Bar
    Given User tap <real estate type> in header bar
    When Input <searchKeyword> in search bar
    Then News that match keyword <searchKeyword> should be displayed
     
    Examples:
		  |real estate type|	searchKeyword|
	    |Nhà đất cho thuê|	Quảng Hàm		|
	    |Nhà đất bán		|	KCN						|
	    |Dự án					|	Khu nhà				|
	      
	    		

  @searchKeyword
  Scenario Outline: Search keyword
    Given Input <searchKeyword> in search bar
    When Tap a search result is displayed
    Then News containing keyword <searchKeyword> should be displayed

    Examples:
	    |searchKeyword|
	    |Khu|
	    |Khuabc|		 

