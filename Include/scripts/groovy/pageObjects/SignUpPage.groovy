package pageObjects

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.testng.Assert
import org.testng.asserts.SoftAssert

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable
import utils.Companion
import pageObjects.MainPage
import step.LoginSteps
public class SignUpPage extends AbstractPage {
	LoginSteps login=new LoginSteps()
	def String random= generateRandomString()
	
	def verifySignUpPage() {
		SoftAssert soft=new SoftAssert()
		soft.assertTrue(isDisplayed(findTestObject('Object Repository/account/txtAcount')),"Username not displayed")
		soft.assertTrue(isDisplayed(findTestObject('Object Repository/account/txtEmail')),"Email not displayed")
		soft.assertTrue(isDisplayed(findTestObject('Object Repository/account/txtPassword')),"Password not displayed")
		soft.assertTrue(isDisplayed(findTestObject('Object Repository/account/txtPassword2')),"Password not displayed")
		soft.assertTrue(isDisplayed(findTestObject('Object Repository/account/btnSignUp2')),"SignUp button not displayed")
		soft.assertAll()
	}

	def inputSignUpForms(String username,String email,String password,String password2) {
		if (username.equals('test1')) {
			setText(findTestObject('Object Repository/account/txtAcount'), username + random)
			setText(findTestObject('Object Repository/account/txtEmail'), random+'@gmail.com')
		}else {
			setText(findTestObject('Object Repository/account/txtAcount'), username)
			setText(findTestObject('Object Repository/account/txtEmail'), email)
		}
		setText(findTestObject('Object Repository/account/txtPassword'), password)
		setText(findTestObject('Object Repository/account/txtPassword'), password2)
	}

	def tapSignUpBtn() {
		tap(findTestObject('Object Repository/account/btnSignUp2'))
	}

	def verifyMessages(String message,String enable,String username,String password,String status) {
		String mess1="Đăng ký tài khoản thành công. Vui lòng vào email bạn đã đăng ký để kích hoạt tài khoản."
		if (enable.equals('true')) {
			Mobile.verifyElementVisible(getTestObjectByText(message),Companion.DELAY_TIME)
			if (message.equals(mess1)) {
				tap(findTestObject('Object Repository/account/btnOk'))
				login.inputLoginInfo(username+random, password)
				login.checkLoggedIn(status)
			}
		}else {
			try {
				Mobile.verifyElementVisible(getTestObjectByText(message), Companion.DELAY_TIME)
			} catch (e) {
				
			}
		}
	}
}
