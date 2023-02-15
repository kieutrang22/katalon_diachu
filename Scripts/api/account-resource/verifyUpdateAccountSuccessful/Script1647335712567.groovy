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


import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testdata.reader.ExcelFactory
import api.commonUtils

def token=CustomKeywords.'api.abstractApi.getToken'('hongthan25', '123456@a')
Object excelData = ExcelFactory.getExcelDataWithDefaultSheet('resource/accountDataTest.xlsx', 'put_data', true)
Object excelData2 = ExcelFactory.getExcelDataWithDefaultSheet('resource/accountDataTest.xlsx', 'expected', true)

for(int i=1;i<=16;i++) {
	println 'Test'+i
	HashMap<String, Object> map = new HashMap<String, Object>();
	 commonUtils.checkPut(map, 'token', token)
	 commonUtils.checkPut(map,'name',excelData.getValue('Name', i))
	 commonUtils.checkPut(map,'gender',excelData.getValue('Gender', i))
	 commonUtils.checkPut(map,'address',excelData.getValue('Address', i))
	 commonUtils.checkPut(map,'phoneNumber',excelData.getValue('Number', i))
	ResponseObject response=CustomKeywords.'api.abstractApi.callApi'('Object Repository/Api/updateAccountInfor', map)
	if(excelData2.getValue('Status', i).equals('200')) {
		WS.verifyMatch(String.valueOf(response.getStatusCode()),excelData2.getValue('Status', i), false, FailureHandling.CONTINUE_ON_FAILURE)
		if(excelData2.getValue('Name', i) != "" && excelData2.getValue('Name', i) !="") {
			WS.verifyMatch(WS.getElementPropertyValue(response,'name'),excelData2.getValue('Name', i), false, FailureHandling.CONTINUE_ON_FAILURE)
		}
		if(excelData2.getValue('Gender', i) != "" && excelData2.getValue('Gender', i) !="") {
			WS.verifyMatch(WS.getElementPropertyValue(response,'gender'),excelData2.getValue('Gender', i), false, FailureHandling.CONTINUE_ON_FAILURE)
		}
		if(excelData2.getValue('Address', i) != "" && excelData2.getValue('Address', i) !="") {
			WS.verifyMatch(WS.getElementPropertyValue(response,'address'),excelData2.getValue('Address', i), false, FailureHandling.CONTINUE_ON_FAILURE)
		}
		if(excelData2.getValue('Number', i) != "" && excelData2.getValue('Number', i) !="") {
			WS.verifyMatch(WS.getElementPropertyValue(response,'phoneNumber'),excelData2.getValue('Number', i), false, FailureHandling.CONTINUE_ON_FAILURE)
		}
		
	}
	if(excelData2.getValue('Status', i).equals('401')) {
		WS.verifyMatch(String.valueOf(response.getStatusCode()),excelData2.getValue('Status', i), false, FailureHandling.CONTINUE_ON_FAILURE)
		WS.verifyMatch(WS.getElementPropertyValue(response,'message'),excelData2.getValue('message', i), false, FailureHandling.CONTINUE_ON_FAILURE)
	} 
}
	

