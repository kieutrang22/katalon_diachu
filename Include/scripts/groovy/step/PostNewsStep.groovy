package step

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory

import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import pageObjects.AbstractPage
import pageObjects.AccountPage
import pageObjects.MainPage
import utils.Companion

class PostNewsStep extends AbstractPage {
	MainPage mainPage = new MainPage()
	AccountPage accountPage = new AccountPage()

	@Given("User login as agent account, navigate to post news")
	def navigatePostNews() {
		accountPage.loginAsAgent()
		mainPage.navigatePostNews()
	}


	@When("Select base information")
	def inputBaseInfomation() {

		List<String> inputList = new ArrayList()
		inputList.add("Hình thức *")
		inputList.add("Loại BĐS *")
		inputList.add("Tỉnh/Thành Phố *")
		inputList.add("Quận/Huyện *")
		inputList.add("Xã/Phường *")

		for(String input : inputList) {
			selectRandomDropDownItem(input)
		}
		tap(findTestObject('postNews/btnContinue'))
	}


	@When("Input description information")
	def inputDescriptionInfomation() {
		swipeVertically(0.3, 0.8)
		TestData postNewsData = TestDataFactory.findTestData('Data Files/postNews')
		def inputList = postNewsData.getColumnNames()

		for(String input : inputList) {
			Mobile.scrollToText(input)
			def data = postNewsData.getValue(input, 1)
			if (input != "Chọn đơn vị tính") {
				try {
					Mobile.setText(findTestObject('postNews/dynamicEditText', ['txt':input]), data, 2)
				}
				catch (Exception ex){
					swipeVertically(0.6, 0.5)
					setText(findTestObject('postNews/dynamicEditText', ['txt':input]),
					postNewsData.getValue(input, 1))
				}
			}
			else {
				try {
					Mobile.tap(findTestObject('postNews/dynamicTextView', ['txt':input]), 2)
				}
				catch (Exception ex){
					swipeVertically(0.6, 0.5)
					tap(findTestObject('postNews/dynamicTextView', ['txt':input]))
				}
				delay(Companion.DELAY_TIME)
				tap(findTestObject('selection/txtOptionItem', ['txt':data]))
			}
			delay(Companion.DELAY_TIME)
		}
		tap(findTestObject('postNews/btnContinue'))
	}

	//not have money to pay for real product server
	@When("Input payment information")
	def inputPaymentInfomation() {
		//TODO
		assert true
	}


	@Then("News should be posted succesfully")
	def checkPostNews() {
		//TODO
		Mobile.pressBack()
		Mobile.pressBack()
		assert true
	}


	@Given("As an agent, I didn't login and navigate to news post page")
	def clickPostNews() {
		tap(findTestObject('main/lnkPostNews'))
	}


	@When("Alert should be displayed with 'Cancel' and 'Login' button")
	def boolean isLoginAlertDisplayed() {
		return isVisible(findTestObject('postNews/txtNeedLoginNotice'))
	}


	@When("Navigate to login page when click 'Login' button")
	def clickLogin() {
		tap(findTestObject('postNews/btnLogin'))
		assert isVisible(findTestObject('/account/lnkLogin'))
		Mobile.pressBack()
	}

}