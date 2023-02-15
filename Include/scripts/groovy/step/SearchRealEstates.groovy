package step

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import pageObjects.RealEstatesPage


class SearchRealEstates extends RealEstatesPage{
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */

	String inputSearch

	@Given('I am on Real Estates for sale page')
	def I_am_on_real_estates_for_sale_page() {
		tapOnSellRealEstates()
	}

	@Given('I am on Real Estates for rent page')
	def I_am_on_realEstates_for_rent_page() {
		tapOnRentRealEstates()
	}

	@When('I input (.*) in the search bar in Real Estate page')
	def I_input_realEstates_in_the_search_bar(String value) {
		inputSearch = value
		searchRealEstates(inputSearch)
	}


	@Then('I verify the result in the Real Estates list')
	def Boolean I_verify_the_result_in_the_realEstates_list() {
		String title = getRealEstateFirstTitle()
		return title.contains(inputSearch) || isVisible(findTestObject('search/txtNoResultSearch'))
	}


	@And('I clear the search bar')
	def I_clear_the_search_bar() {
		clearSellSearchBar()
	}
}