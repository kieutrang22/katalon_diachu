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
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ResponseObject as ResponseObject
import com.kms.katalon.core.testdata.reader.ExcelFactory as ExcelFactory
import api.commonUtils as commonUtils
import org.apache.commons.lang3.RandomStringUtils as RandomStringUtils
import java.sql.ResultSet as ResultSet
import com.database.PostgreSQLJDBC as PostgreSQLJDBC

String randomUsername = RandomStringUtils.randomAlphabetic(6)

String randomMail = RandomStringUtils.randomAlphanumeric(10) + '@mymail.com'

String randomPassword = RandomStringUtils.randomAlphanumeric(8)

String login = null

HashMap<String, Object> map = new HashMap<String, Object>()

commonUtils.checkPut(map, 'username', randomUsername)

commonUtils.checkPut(map, 'email', randomMail)

commonUtils.checkPut(map, 'password', randomPassword)

commonUtils.checkPut(map, 'repeatPassword', randomPassword)

//Tạo account mới
ResponseObject response = CustomKeywords.'api.abstractApi.callApi'('Object Repository/Api/registerAccount', map)

WS.verifyResponseStatusCode(response, 201, FailureHandling.STOP_ON_FAILURE)

def token = CustomKeywords.'api.abstractApi.getToken'('admin', 'admin')

HashMap<String, Object> map2 = new HashMap<String, Object>()

commonUtils.checkPut(map2, 'token', token)

commonUtils.checkPut(map2, 'account', randomUsername)

commonUtils.checkPut(map2, 'boolean', 'true')

//activate account vừa tạo bằng tài khoản admin
def response2 = CustomKeywords.'api.abstractApi.callApi'('Object Repository/Api/setActivateAccount', map2)

//Kiểm tra trong db có tài khoản vừa tạo chưa
String query = ('SELECT * FROM users WHERE login=\'' + randomUsername.toLowerCase()) + '\''

sleep(10000)

ResultSet rs = PostgreSQLJDBC.executeQuery(query)

while (rs.next()) {
    login = rs.getString('login')

    PostgreSQLJDBC.closeDatabaseConnection()
}

WS.verifyMatch(login, randomUsername.toLowerCase(), false, FailureHandling.STOP_ON_FAILURE)

//Xoá tài khoản vừa tạo
ResponseObject response3 = CustomKeywords.'api.abstractApi.callApi'('Object Repository/Api/deleteAccount', [('token') : token
        , ('account') : login])

WS.verifyResponseStatusCode(response3, 204, FailureHandling.STOP_ON_FAILURE)