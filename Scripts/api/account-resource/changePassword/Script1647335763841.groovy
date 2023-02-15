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

import org.openqa.selenium.Keys
import org.testng.Assert

import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory


import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testdata.reader.ExcelFactory
import api.commonUtils

// đổi chỗ 2 loại mật khẩu nếu test false
def token=CustomKeywords.'api.abstractApi.getToken'('hongthan25', '123456@a')
HashMap<String, Object> map = new HashMap<String, Object>();
commonUtils.checkPut(map, 'token', token)
commonUtils.checkPut(map,'currentPassword','123456@a')
commonUtils.checkPut(map,'newPassword','123456@a')
ResponseObject response=CustomKeywords.'api.abstractApi.callApi'('Object Repository/Api/changePassword', map)

WS.verifyResponseStatusCodeInRange(response, 200, 205, FailureHandling.STOP_ON_FAILURE)

def token2=CustomKeywords.'api.abstractApi.getToken'('hongthan25', '123456@a')
Assert.assertTrue(token2 != null)