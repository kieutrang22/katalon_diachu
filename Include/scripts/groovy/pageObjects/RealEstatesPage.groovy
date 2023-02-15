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

public class RealEstatesPage extends AbstractPage {

	def tapOnSellRealEstates(){
		tap(findTestObject('main/lnkSellEstates'))
	}


	def searchRealEstates(String value){
		setText(findTestObject('realEstates/txtSearchRealEstates'), value)
	}


	def clearSellSearchBar(){
		Mobile.clearText(findTestObject('realEstates/txtSearchRealEstates'), Companion.TIME_OUT)
	}


	def getRealEstateFirstTitle(){
		Mobile.getText(findTestObject('realEstates/txtSellEstatesFirstTitle'), Companion.TIME_OUT)
	}


	def tapOnRentRealEstates(){
		tap(findTestObject('main/lnkRentalEstates'))
	}


	def tapOnLatestNews(){
		tap(findTestObject('realEstates/txtLatestNews'))
	}


	def tapOnOldestNews(){
		tap(findTestObject('realEstates/txtOldestNews'))
	}


	def tapOnHighestPriceNews(){
		tap(findTestObject('realEstates/txtHighestPriceNews'))
	}


	def verifyLatestNews(){
		String preTitle = Mobile.getText(findTestObject('realEstates/txtSellEstatesFirstTitle'), Companion.TIME_OUT)
		tap(findTestObject('realEstates/txtSellEstatesFirstTitle'))
		String currentTitle = Mobile.getText(findTestObject('realEstates/txtSellEstatesFirstTitle'), Companion.TIME_OUT)
		currentTitle.contains(preTitle)
		Mobile.pressBack()
	}


	def verifyOldestNews(){
		String preTitle = Mobile.getText(findTestObject('realEstates/txtSellEstatesFirstTitle'), Companion.TIME_OUT)
		tap(findTestObject('realEstates/txtSellEstatesFirstTitle'))
		String currentTitle = Mobile.getText(findTestObject('realEstates/txtSellEstatesFirstTitle'), Companion.TIME_OUT)
		currentTitle.contains(preTitle)
		Mobile.pressBack()
	}


	def verifyHighestPriceNews(){
		String preTitle = Mobile.getText(findTestObject('realEstates/txtSellEstatesFirstTitle'), Companion.TIME_OUT)
		tap(findTestObject('realEstates/txtSellEstatesFirstTitle'))
		String currentTitle = Mobile.getText(findTestObject('realEstates/txtSellEstatesFirstTitle'), Companion.TIME_OUT)
		currentTitle.contains(preTitle)
		Mobile.pressBack()
	}
}