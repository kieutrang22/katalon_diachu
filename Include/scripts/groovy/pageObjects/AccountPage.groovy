package pageObjects

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.annotation.Keyword
import utils.CommonUtils
import utils.Companion

public class AccountPage extends AbstractPage {
	CommonUtils utils = new CommonUtils()
	MainPage mainPage = new MainPage()


	def loginAsAdmin() {
		loginWithAccount(Companion.ADMIN_ACCOUNT, Companion.ADMIN_ACCOUNT)
	}


	def loginAsAgent() {
		loginWithAccount(Companion.AGENT_ACCOUNT, Companion.AGENT_PASSWORD)
	}


	def inputAcount(String userName) {
		setText(findTestObject('account/txtAcount'), userName)
	}


	def inputPassword(String password) {
		setText(findTestObject('account/txtPassword'), password)
	}


	def submitLogin() {
		tap(findTestObject('account/lnkLogin'))
	}


	def navigateSigInSingUp() {
		tap(findTestObject('Object Repository/account/lnkSigInSigUp'))
	}


	def navigateLogin() {
		mainPage.navigateAccount()
		navigateSigInSingUp()
		tap(findTestObject('account/lnkLogin'))
	}


	def Boolean isLoggedIn() {
		return isVisible(findTestObject('account/lnkAccountInformation'))
	}


	def loginWithAccount(String userName, String password) {
		navigateLogin()
		inputAcount(userName)
		inputPassword(password)
		submitLogin()

		mainPage.navigateHome()
	}
	
	def navigateSignUpPage() {
		tap(findTestObject('Object Repository/account/btnSignUp'))
	}
	
}
