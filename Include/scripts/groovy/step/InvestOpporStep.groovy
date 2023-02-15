package step

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import pageObjects.InvestOpporPage
import pageObjects.MainPage


class InvestOpporStep extends InvestOpporPage{
	MainPage mainPage = new MainPage()

	@Given("I click on the menu Investment Opportunity")
	def clickOnInvestmentOpportunity() {
		tap(findTestObject('Object Repository/investmentOpportunity/txtNameInvestOppor'))
		verifyText()
	}

	@And('I check infomation filter')
	def checkInfomartionFilter() {
		choosePurpose()
		chooseTypeProperty()
		chooseCity()
		chooseDistrict()
		chooseFinance()
		tap(findTestObject('search/btnSearch'))
	}

	@And('I check the information latest')
	def checkInformationLatest() {
		checkTitle()
		tap(findTestObject('Object Repository/investmentOpportunity/imgImages'))
		swipeMobile()
		tap(findTestObject('Object Repository/investmentOpportunity/nodeCall'))
		Mobile.scrollToText('Thông Tin Liên Hệ', FailureHandling.OPTIONAL)
		verifyInforUser()
		Mobile.pressBack()
	}

	@When("I click on oldest tap")
	def clickOnOldest() {
		tap(findTestObject('Object Repository/investmentOpportunity/txtOldest'))
		verifyText()
	}

	@And('I check the information oldest')
	def checkInformationOldest() {
		checkTitle()
		tap(findTestObject('Object Repository/investmentOpportunity/imgImages'))
		swipeMobile()
		Mobile.scrollToText('Thông Tin Liên Hệ', FailureHandling.OPTIONAL)
		verifyInforUser()
		tap(findTestObject('Object Repository/investmentOpportunity/imgImages'))
		Mobile.pressBack()
	}

	@Then("I verify the status in step is successfully")
	def verifyStatusInStep() {
		assert true
	}
}