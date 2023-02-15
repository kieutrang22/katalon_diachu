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

def token=CustomKeywords.'api.abstractApi.getToken'('diachu_mg5', '123456')
def response=CustomKeywords.'api.abstractApi.callApi'('Object Repository/Api/getAccountProfile', [('token') :token])

TestData data=TestDataFactory.findTestData('Data Files/accountInfor')

assertEquals(data.getValue('id', 1), String.valueOf(WS.getElementPropertyValue(response,'id')))
assertEquals(data.getValue('login', 1), WS.getElementPropertyValue(response,'login'))
assertEquals(data.getValue('name', 1), WS.getElementPropertyValue(response,'name'))
assertEquals(data.getValue('phone_number', 1), WS.getElementPropertyValue(response,'phoneNumber'))
assertEquals(data.getValue('email', 1), WS.getElementPropertyValue(response,'email'))
assertEquals(data.getValue('gender', 1), WS.getElementPropertyValue(response,'gender'))
//assertEquals(data.getValue('date_of_birth', 1), WS.getElementPropertyValue(response,'dateOfBirth'))
assertEquals(data.getValue('company_id', 1),String.valueOf( WS.getElementPropertyValue(response,'companyId')))