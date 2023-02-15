package step

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import pageObjects.InvestOpporPage
import pageObjects.MainPage
import pageObjects.ProjectPage
import utils.Companion


class ProjectStep extends ProjectPage {
	MainPage mainPage = new MainPage()

	@Given("I click on the menu project")
	def clickOnMenuProject()  {
		tap(findTestObject('Object Repository/Project/btnProject'))
		String infor = getText(findTestObject('project/txtPage'))
		Mobile.verifyEqual(infor, "Thông thường")
	}

	@Then("I check the project information successfully")
	def checkInformationSuccessfully() {
		Mobile.pressBack()
		mainPage.navigateHome()
	}


	@And("I click on the tap latest")
	def clickOnLastetProject() {
		tap(findTestObject('Object Repository/Project/txtLatest'))
		Thread.sleep(1500)
	}

	@And("I check the information latest project and return project page")
	def checkInformationLatestProject() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Project/txtTitleThird'), Companion.TIME_OUT)
		String scroll = getText(findTestObject('Object Repository/Project/txtTitleThird'))
		Mobile.scrollToText(scroll, FailureHandling.OPTIONAL)
		checkInforProject()
	}

	@When("I click on the tap oldest")
	def clickOnOldestProject() {
		tap(findTestObject('Object Repository/Project/txtOldest'))
		delay(2)
	}

	@And("I check the information oldest project and return project page")
	def checkInformationOldestProject() {
		checkInforProject()
	}

	@When("I click on the tap highest price")
	def clickOnHighestPriceProject() {
		tap(findTestObject('Object Repository/Project/txtHighestPrice'))
		Mobile.delay(2)
	}

	@And("I check information highest price project and return project page")
	def checkInformationHighesPriceProject() {
		checkInforProject()
	}

	@And('I search project by filter')
	def searchProjectByFilter() {
		searchTypeProject()
		searchCity("Hồ Chí Minh")
		searchDistrict("Quận 1")
		clickBtnSearch()
	}

	@And("I search project by search bar (.*)")
	def searchProjectBySearchBarAndFilter(String input) {
		searchByName(input)
		verifySearchSuccess(input)
	}
}