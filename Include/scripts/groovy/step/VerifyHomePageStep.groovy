package step
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import pageObjects.AbstractPage
import pageObjects.MainPage

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class VerifyHomePageStep extends AbstractPage{
	MainPage mainPage = new MainPage()

	@Given("I open app successfully")
	def openAppSuccessfully() {
		mainPage.navigateHome()
	}

	@Then("I verify default display information on homepage")
	def verifyInformatiDefaulf() {
		List<String> listMenu = new ArrayList()
		listMenu.add("Nh?? ?????t b??n")
		listMenu.add("Nh?? ?????t cho thu??")
		listMenu.add("D??? ??n")
		listMenu.add("C?? h???i ?????u t??")
		listMenu.add("B???n ?????")
		listMenu.add("Danh b???")
		for(String item : listMenu) {
			assert isVisible(findTestObject('dynamic/txtMenuDynamic', ['txtMenu' : item]))
			assert isVisible(findTestObject('dynamic/iconMenuDynamic', ['txtMenu' : item]))
		}
	}

	@When("I check the category on the home page")
	def checkCategoryOnHomePage() {
		List<String> listItem = new ArrayList()
		listItem.add("MUA B??N")
		listItem.add("CHO THU??")
		listItem.add("D??? ??N")

		for(String i:listItem) {
			switch(i) {
				case "MUA B??N":
					Mobile.scrollToText("MUA B??N")
					break
				case "CHO THU??":
					Mobile.scrollToText("Tri???u/th??ng")
					break
				case "D??? ??N":
					Mobile.scrollToText("Th???a thu???n")
					break
			}

			String titleRent = getText(findTestObject('dynamic/txtRentFirst', ['text' : i]))
			tap(findTestObject('dynamic/imgRent', ['text' : i]))
			String preTitle = getText(findTestObject('Object Repository/news/txtNewsTitle'))
			String[] titles = preTitle.split("]")
			Mobile.verifyEqual(titleRent.trim(), titles[titles.length-1].trim())
			Mobile.pressBack()
			tap(findTestObject('dynamic/sellAllRrent', ['text' : i]))
			String infor = getText(findTestObject('project/txtPage'))
			Mobile.verifyEqual(infor, "Th??ng th?????ng")
			tap(findTestObject('main/lnkHome'))
		}
	}

	@And("I click to item and App will be direct to item that")
	def clickToItem() {
		while (!isVisible(findTestObject('Object Repository/homePage/txtMap'))) {
			swipeDown()
		}
		swipeDown()
		List<String> listMenu = new ArrayList()
		listMenu.add("Nh?? ?????t b??n")
		listMenu.add("Nh?? ?????t cho thu??")
		listMenu.add("D??? ??n")
		listMenu.add("C?? h???i ?????u t??")
		listMenu.add("B???n ?????")
		listMenu.add("Danh b???")
		for(String item : listMenu) {
			if(item.equals("Nh?? ?????t b??n") || item.equals("Nh?? ?????t cho thu??") || item.equals("D??? ??n")) {
				tap(findTestObject('dynamic/txtMenuDynamic', ['txtMenu' : item]))
				String infor = getText(findTestObject('project/txtPage'))
				Mobile.verifyEqual(infor, "Th??ng th?????ng")
				tap(findTestObject('main/lnkHome'))
			}
			else {
				if(item.equals("C?? h???i ?????u t??")){
					tap(findTestObject('dynamic/txtMenuDynamic', ['txtMenu' : item]))
					String investOppor = getText(findTestObject('homePage/headerInvestOppor'))
					Mobile.verifyEqual(investOppor, "C?? h???i ?????u t??")
					tap(findTestObject('main/lnkHome'))
				} else {
					if(item.equals("Danh b???")) {
						tap(findTestObject('dynamic/txtMenuDynamic', ['txtMenu' : item]))
						List<String> listContact = new ArrayList()
						listContact.add("C??ng ty")
						listContact.add("C??ng ty m??i gi???i")
						listContact.add("M??i gi???i")
						for(String contact : listContact) {
							assert isVisible(findTestObject('dynamic/iconContactDynamic', ['contact' : contact]))
							assert isVisible(findTestObject('dynamic/txtContactDynamic', ['contact' : contact]))
						}
					}
				}
			}
		}
	}
}