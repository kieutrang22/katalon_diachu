import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable

import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory

import static org.junit.Assert.assertEquals

import org.junit.Assert
import com.kms.katalon.core.testobject.ResponseObject
ResponseObject response=CustomKeywords.'api.abstractApi.callApi'('Object Repository/Api/getAccountProfile')

assertEquals('https://www.diachu.vn/problem/problem-with-message', WS.getElementPropertyValue(response,'type'))
assertEquals('Unauthorized', WS.getElementPropertyValue(response,'title'))
assertEquals('401', String.valueOf(WS.getElementPropertyValue(response,'status')))
assertEquals('Full authentication is required to access this resource', WS.getElementPropertyValue(response,'detail'))
assertEquals('/api/account/profile', WS.getElementPropertyValue(response,'path'))
assertEquals('error.http.401', WS.getElementPropertyValue(response,'message'))