package step

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import cucumber.api.java.en.Given
import cucumber.api.java.en.When
import pageObjects.MainPage


class MainSteps extends MainPage {

	@Given ("User tap (.*) in header bar")
	def tapHeaderBarByName(String type) {
		tapText(type)
	}


	@Given ("User tap remore link by type (.*)")
	def tapRemore(String type) {
		tap(findTestObject('main/lnkReadmore',['type': type]))
	}


	@When ("Navigate to home page")
	def navigateHome() {
		tap(findTestObject('main/lnkHome'))
	}
}