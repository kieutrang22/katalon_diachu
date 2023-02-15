package pageObjects

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import javax.media.ExtendedCachingControl

import org.testng.Assert
import org.testng.asserts.SoftAssert

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.sun.org.apache.bcel.internal.generic.RETURN

import groovy.util.ObservableList.ElementAddedEvent

import org.openqa.selenium.WebElement as WebElement
import internal.GlobalVariable
import org.openqa.selenium.WebDriver
import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.util.KeywordUtil
import io.appium.java_client.AppiumDriver

import utils.Companion

public class ContactsPage extends AbstractPage  {

	def tapContacts() {
		tap(findTestObject('main/btnContacts'))
	}


	def tapCompany() {
		tap(findTestObject('main/lnkCompany'))
	}


	def tapBroker() {
		tap(findTestObject('main/lnkBroker'))
	}


	def tapBrokerageFirmLnk() {
		tap(findTestObject('main/lnkBrokerageFirm'))
	}


	def tapByElement(String text) {
		tapText(text)
	}


	def verifyCompanyPage() {
		SoftAssert soft= new SoftAssert();
		soft.assertTrue(isVisible(findTestObject('Object Repository/ComanyPage/image')), "Image not displayed")
		soft.assertTrue(isVisible(findTestObject('Object Repository/ComanyPage/name')),"Name not displayed")
		soft.assertTrue(isVisible(findTestObject('Object Repository/ComanyPage/address')),"Address not displayed")
		soft.assertTrue(isVisible(findTestObject('Object Repository/ComanyPage/phoneNumber')),"Phone Number not displayed")
		soft.assertAll();
	}


	def verifyContactsButton() {
		Assert.assertTrue(isVisible(findTestObject('Object Repository/main/btnContacts')),"Contacts button not displayed")
	}


	def verifyIntroduce() {
		Assert.assertTrue(isVisible(findTestObject('ComanyPage/TxtIntroduce')),"Introduce not displayed")
	}


	def verifyCallButton() {
		Assert.assertTrue(isVisible(findTestObject('Object Repository/ComanyPage/btnCall')),"Call btn not displayed")
	}


	def verifyByElement(String text) {
		Assert.assertTrue(checkDisplayedByText(text)," Not displayed")
	}


	def inputToSearchBar(String text) {
		setText(findTestObject('comanyPage/searchBar'), text)
	}


	def findBrokerName(String name) {
		swipeToName(name)
		Assert.assertTrue(checkDisplayedByText(name),"Broker name not displayed")
	}


	def tapElementByName(String name) {
		swipeToName(name)
		tapByElement(name)
	}


	def inputToBrokerSearchBar(String text) {
		setText(findTestObject('brokerPage/brokerSearch'), text)
	}


	def findBrokerageFirmName(String name) {
		swipeToName(name)
		Assert.assertTrue(checkDisplayedByText(name),"Brokerage Firm Name not displayed")
	}



	def inputToBrokerageFirmSearchBar(String text) {
		setText(findTestObject('Object Repository/BrokerageFirmPage/brokerageFirmSearchBar'), text)
	}

	//
	//	def Boolean checkDisplayedNameCompany(String text) {
	//		return Mobile.verifyElementVisible(
	//				getTestObjectByTextAndIndexAtribute(text, '0'),
	//				Companion.TIME_OUT,
	//				FailureHandling.OPTIONAL)
	//	}
	//
	//
	//	def Boolean checkDisplayedAddressCompany(String text) {
	//		return Mobile.verifyElementVisible(
	//				getTestObjectByTextAndIndexAtribute(text, '2'),
	//				Companion.TIME_OUT,
	//				FailureHandling.OPTIONAL)
	//	}


	def verifyNameCompany(String text) {
		Assert.assertEquals(getText(findTestObject('Object Repository/comanyPage/companyName')),text," Not displayed" )
	}


	def verifyAddressCompany(String text) {
		Assert.assertEquals(getText(findTestObject('Object Repository/comanyPage/companyAddress')),text," Not displayed" )
	}
}
