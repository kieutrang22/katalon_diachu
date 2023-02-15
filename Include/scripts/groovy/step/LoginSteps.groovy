package step

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling

import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import pageObjects.MainPage
import utils.Companion

class LoginSteps extends MainPage {

	MainPage mainPage = new MainPage()

	@Given("User navigate login page")
	public def clickLogin() {
		mainPage.navigateAccount()
		tap(findTestObject('account/lnkSigInSigUp'))
		tap(findTestObject('account/lnkLogin'))
	}

	@When("Input (.*) and (.*)")
	def inputLoginInfo(String userName, String password) {
		inputAcount(userName)
		inputPassword(password)
		submitLogin()
	}

	@Given("User login as agent account")
	def loginAsAgent() {
		loginWithAccount(Companion.AGENT_ACCOUNT, Companion.AGENT_PASSWORD)
	}
	
	@Then("Check status (.*) and message (.*)")
	def checkLoggedIn(String status, String message) {
		if (status == Companion.Status.SUCCESSFUL.value) {
			def result = isVisible(findTestObject('Object Repository/account/lnkAccountInformation'))
			if (result) {
				Mobile.scrollToText("Đăng xuất")
				tap(findTestObject('/account/lnkLogout'))
				tap(findTestObject('/account/btnLogout'))
			}
			assert result
		}
		else {
			if (message == 'Không được bỏ trống') {
				Mobile.verifyElementText(findTestObject('account/txtCanNotBlank'), 'Không được bỏ trống')
				assert isVisible(findTestObject('account/txtCanNotBlank'))
				pressBack()
				pressBack()
			}
			else {
				assert isVisible(getTestObjectByText("Đăng nhập không thành công!"))
				pressBack()
				pressBack()
			}
		}
	}
}