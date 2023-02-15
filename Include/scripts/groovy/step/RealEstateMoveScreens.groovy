package step

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import pageObjects.MainPage
import pageObjects.RealEstatesPage
import utils.Companion

class RealEstateMoveScreens extends RealEstatesPage {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */

	MainPage mainPage = new MainPage()

	@Given('I am on the Home Page')
	def I_am_on_the_home_page() {
		Mobile.verifyElementExist(findTestObject('main/txtSell'), Companion.TIME_OUT)
	}

	@When('I click on Real Estates for sale')
	def I_click_on_real_estates_for_sale() {
		tapOnSellRealEstates()
	}

	@Then('I got redirected to Real Estates for sale page')
	def I_got_redirected_to_real_estates_for_sale_page() {
		Mobile.verifyElementExist(findTestObject('RealEstates/txtSearchSellRealEstates'), Companion.TIME_OUT)
	}

	@When('I click on view all Real Estates for sale')
	def I_click_on_view_all_real_estates_for_sale() {
		mainPage.tapOnViewAllSellEstates()
	}

	@When('I click on Real Estates for rent')
	def I_click_on_real_estates_for_rent() {
		mainPage.tapOnRentalRealEstates()
	}

	@Then('I got redirected to Real Estates for rent page')
	def I_got_redirected_to_real_estates_for_rent() {
		Mobile.verifyElementExist(findTestObject('RealEstates/txtSearchRentRealEstates'),Companion.TIME_OUT)
	}

	@When('I click on view all rental Real Estates')
	def IclickOnViewAllRentalEstates() {
		mainPage.tapOnViewAllRentalEstates()
	}

	@When('I click on sort Real Estates by latest news')
	def I_click_on_sort_realEstates_by_latest_news() {
		tapOnLatestNews()
	}

	@Then('I got redirected to Real Estates latest news page')
	def I_got_redirected_to_realEstates_latest_news() {
		verifyLatestNews()
	}

	@When('I click on sort Real Estates by oldest news')
	def I_click_on_sort_realEstates_by_oldest_news() {
		tapOnOldestNews()
	}

	@Then('I got redirected to Real Estates oldest news page')
	def I_got_redirected_to_realEstates_oldest_news_page() {
		verifyOldestNews()
	}

	@When('I click on sort Real Estates by highest price news')
	def I_click_on_sort_realEstates_by_highest_news() {
		tapOnHighestPriceNews()
	}

	@Then('I got redirected to Real Estates highest price news page')
	def I_got_redirected_to_realEstate_highest_news_page() {
		verifyHighestPriceNews()
	}

	@And('I navigate back to the main page')
	def I_navigate_back_to_the_main_page() {
		mainPage.navigateHome()
	}
}