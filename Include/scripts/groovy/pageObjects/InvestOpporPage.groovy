package pageObjects

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.testng.Assert

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import utils.Companion

public class InvestOpporPage extends AbstractPage{
	def verifyText() {
		Mobile.waitForElementPresent(findTestObject('Object Repository/investmentOpportunity/txtNameInvestOppor'), Companion.TIME_OUT)
	}

	def checkTitle() {
		String preTitle = getText(findTestObject('Object Repository/investmentOpportunity/txtFirstTitle'))
		Mobile.tap(findTestObject('Object Repository/investmentOpportunity/txtFirstTitle'), Companion.TIME_OUT)
		delay(5)
		String afterTitle = getText(findTestObject('Object Repository/investmentOpportunity/txtFirstTitle'))
		Mobile.verifyEqual(preTitle, afterTitle)
	}

	def swipeMobile() {
		Mobile.swipe(200, 300, 400, 600)
		Mobile.swipe(200, 300, 400, 600)
		Mobile.swipe(200, 300, 400, 600)
	}

	def verifyInforUser() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/investmentOpportunity/img'), Companion.TIME_OUT)
		Mobile.verifyElementExist(findTestObject('Object Repository/investmentOpportunity/txtName'), Companion.TIME_OUT)
		Mobile.verifyElementText(findTestObject('Object Repository/investmentOpportunity/txtName'), 'ThienKhoi')
		Mobile.verifyElementVisible(findTestObject('Object Repository/investmentOpportunity/txtEmail'), Companion.TIME_OUT)
		Mobile.verifyElementVisible(findTestObject('Object Repository/investmentOpportunity/txtPhoneNumber'), Companion.TIME_OUT)
	}

	def choosePurpose() {
		tap(findTestObject('Object Repository/investmentOpportunity/filterInverOppor'))
		tap(findTestObject('Object Repository/investmentOpportunity/filterPurpose'))
		tap(findTestObject('Object Repository/investmentOpportunity/chooseTypeProperty'))
	}

	def chooseTypeProperty() {
		tap(findTestObject('Object Repository/investmentOpportunity/filterTypeProperty'))
		tap(findTestObject('Object Repository/investmentOpportunity/chooseTypeProperty'))
	}

	def chooseCity() {
		tap(findTestObject('Object Repository/investmentOpportunity/filterCity'))
		tap(findTestObject('Object Repository/investmentOpportunity/chooseTypeProperty'))
	}

	def chooseDistrict() {
		tap(findTestObject('Object Repository/investmentOpportunity/filterDistrict'))
		tap(findTestObject('Object Repository/investmentOpportunity/chooseTypeProperty'))
	}

	def chooseFinance() {
		tap(findTestObject('Object Repository/investmentOpportunity/filterFinance'))
		tap(findTestObject('Object Repository/investmentOpportunity/chooseTypeProperty'))
	}
}
