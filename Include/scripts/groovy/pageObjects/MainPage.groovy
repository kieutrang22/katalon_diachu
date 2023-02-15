package pageObjects
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import utils.Companion


public class MainPage extends AbstractPage {

	def navigateHome() {
		tap(findTestObject('main/lnkHome'))
	}

	def navigateAccount() {
		tap(findTestObject('Object Repository/main/lnkAccount'))
	}

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


	def navigateLogin() {
		tap(findTestObject('main/lnkAccount'))
		tap(findTestObject('account/lnkSigInSigUp'))
		tap(findTestObject('account/lnkLogin'))
	}

	def loginWithAccount(String userName, String password) {
		navigateLogin()
		inputAcount(userName)
		inputPassword(password)
		submitLogin()

		tap(findTestObject('main/lnkHome'))
	}

	def tapSearch(){
		tap(findTestObject('search/btnSearch'))
	}

	def navigatePostNews() {
		tap(findTestObject('main/lnkPostNews'))
	}

	def tapOnViewAllRentalEstates() {
		swipeUp()
		tap(findTestObject('main/lnkViewAllRentalEstates'))
	}


	def tapOnViewAllSellEstates() {
		tap(findTestObject('main/lnkViewAllSellEstates'))
	}

	def tapOnSellRealEstates() {
		tap(findTestObject('main/lnkSellEstates'))
	}

	def tapOnRentalRealEstates() {
		tap(findTestObject('main/lnkRentalEstates'))
	}
}
