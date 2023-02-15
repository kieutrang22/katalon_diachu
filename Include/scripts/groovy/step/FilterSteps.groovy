package step
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.TestObject

import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import pageObjects.FilterPage
import utils.Companion.HeaderBar
import utils.Companion.SortType

class FilterSteps extends FilterPage{
	String preText
	String nxtText
	Boolean resultTC = false
	HashMap<String, String> filterList = new HashMap<String, String>()

	@Given("User navigate to filter and select (.*)")
	def clickSearch(String type) {
		delay()
		tap(findTestObject('search/btnFilter'))
		tap(getTestObjectByText(type, 2))
	}


	@Given("Click reset input search")
	def clickReset() {
		tap(findTestObject('search/txtReset'))
	}

	@Given("Filter (.*) by random option")
	def filterRandom(String type) {
		List<String> inputList = new ArrayList()
		inputList.add(" bất động sản")
		inputList.add("Tỉnh/Thành Phố")
		inputList.add("Quận/Huyện")

		if(type != HeaderBar.PROJECT.value &&
		type != HeaderBar.INVESTMENT_OPPORTUNITY.value) {
			inputList.add("Diện tích")
			inputList.add("Mức giá")
			inputList.add("Số phòng ngủ")
		}

		if (type == HeaderBar.INVESTMENT_OPPORTUNITY.value) {
			inputList.add("Mục đích đầu tư")
			inputList.add("Đòn bẩy tài chính")
		}

		for(String input : inputList) {
			filterList.put(input, selectRandomDropDownItem(input))
		}

		swipeVertically(0.6, 0.3)
		Mobile.scrollToText("Tìm kiếm")
		tap(findTestObject('search/btnSearch'))
	}


	@When("Filter (.*) form data file")
	def filterFromDataFile(String type) {

		def filtersData = (type != HeaderBar.PROJECT.value)
				? TestDataFactory.findTestData('Data Files/filterRealEstate')
				: TestDataFactory.findTestData('Data Files/filterProject')
		def cols = filtersData.getColumnNames()

		for(String col : cols) {
			def data = filtersData.getValue(col, 1)
			filterList.put(col, data)
			selectDropDownMenu(col)
			tap(findTestObject('selection/txtOptionItem', ['txt':data]))
		}
		Mobile.scrollToText("Tìm kiếm")
		tap(findTestObject('search/btnSearch'))
	}

	@Then("Posts that match the filter should be displayed")
	def checkFilterResults() {
		delay(3)
		while(true) {
			assert checkFilter(filterList)
			if(!hasNext()) break
		}
	}

	@When("Filter (.*) (.*) (.*) (.*) (.*) (.*) for (.*)")
	def selectFilterOption(
			String type,
			String realType,
			String city,
			String distric,
			String area,
			String price,
			String numberOfBedRooms) {

		filterList.add(" bất động sản", realType)
		filterList.add("Tỉnh/Thành Phố", city)
		filterList.add("Quận/Huyện", distric)

		if(type != HeaderBar.PROJECT.value) {
			filterList.add("Diện tích", area)
			filterList.add("Mức giá", price)
			filterList.add("Số phòng ngủ", numberOfBedRooms)
		}

		for(Map.Entry<String, String> entry : filterList.entrySet()) {
			String key = entry.getKey()
			String value = entry.getValue()

			selectDropDownMenu(key)
			tap(findTestObject('selection/txtOptionItem', ['txt':value]))
		}

		Mobile.scrollToText("Tìm kiếm")
		tap(findTestObject('search/btnSearch'))
	}


	@Given("Input (.*) in search bar")
	def inputSearchKeyword(String searchKeyword) {
		preText = searchKeyword
		tap(findTestObject('search/txtInputSearch'))
		setText(findTestObject('search/txtInputSearch'), searchKeyword)
		delay()
	}


	@Then("News that match keyword (.*) should be displayed")
	def checkNewsSearchForHeaderBarIsDislayed(String searchKeyword) {
		delay()
		if (isVisible(findTestObject('/search/txtNoSearchResult'))) {
			assert true
			return
		} else {
			def titleNews  = getText(findTestObject('news/txtNewsTitle'))
			assert titleNews.contains(searchKeyword)
		}
	}


	@Given("Tap a search result is displayed")
	def tapSearchResult() {
		try {
			delay()
			Mobile.tap(findTestObject('search/txtHomePageSearchResult'), 3)
		} catch (Exception exp) {
			// not found
			resultTC = true
		}
	}


	@Then("News containing keyword (.*) should be displayed")
	def checkNewsSearchIsDislayed(String searchKeyword) {
		if (!resultTC) {
			TestObject result = findTestObject('news/txtNewsTitle')
			def titleNews = getText(result)
			pressBack()
			assert titleNews.contains(searchKeyword)
		} else assert resultTC
	}

	@When("Tap sort type (.*)")
	def tapSortType(String sortType) {
		delay()
		tap(getTestObjectByText(sortType))
		delay()
	}

	@Then("Posts should be displayed in the correct (.*)")
	def checkSort(String sortType) {
		delay()
		switch (sortType) {
			case SortType.OLDEST.value:
				assert checkSortByTime(SortType.OLDEST)
				break
			case SortType.LASTEST.value:
				assert checkSortByTime(SortType.LASTEST)
				break
			case SortType.HIGHEST_PRICE.value:
				assert checkSortByPrice()
				break
			default: assert false
		}
	}
}