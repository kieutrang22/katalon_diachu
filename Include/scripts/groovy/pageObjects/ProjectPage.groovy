package pageObjects

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

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

import internal.GlobalVariable
import utils.Companion

public class ProjectPage extends AbstractPage{
	InvestOpporPage investOppor = new InvestOpporPage()

	def checkInforProject() {
		String preTitle = getText(findTestObject('project/txtTitleLatest'))
		tap(findTestObject('project/txtTitleLatest'))
		delay(10)
		String afterTitle = getText(findTestObject('project/txtTitleLatest'))
		Mobile.verifyEqual(preTitle, afterTitle)
		tap(findTestObject('Object Repository/project/img'))
		investOppor.swipeMobile()
		Mobile.pressBack()
	}

	def searchByName(String name) {
		Mobile.clearText(findTestObject('project/txtSearch'), Companion.TIME_OUT)
		tap(findTestObject('project/txtSearch'))
		Mobile.clearText(findTestObject('project/txtSearch'), Companion.TIME_OUT)
		setText(findTestObject('project/txtSearch'), name)
	}

	def verifySearchSuccess(String name) {
		String title = getText(findTestObject('Object Repository/project/txtTitleLatest'))
		Boolean result = title.contains(name)
		Mobile.verifyEqual(result, true)
	}

	def searchTypeProject() {
		Mobile.waitForElementPresent(findTestObject('project/btnSearch'), Companion.TIME_OUT)
		tap(findTestObject('project/btnSearch'))
		tap(findTestObject('Object Repository/project/searchTypeProject'))
		tap(findTestObject('Object Repository/project/allProject'))
	}

	def searchCity(String city) {
		tap(findTestObject('project/searchCity'))
		tap(findTestObject('Object Repository/project/chooseAfterAll'))
	}

	def searchDistrict(String district) {
		Mobile.waitForElementPresent(findTestObject('Object Repository/project/searchDistrict'), Companion.TIME_OUT)
		tap(findTestObject('Object Repository/project/searchDistrict'))
		tap(findTestObject('Object Repository/project/chooseDistrict'))
	}

	def clickBtnSearch() {
		tap(findTestObject('Object Repository/project/searchProject'))
	}
}
