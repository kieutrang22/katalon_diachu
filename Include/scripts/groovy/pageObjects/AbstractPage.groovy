package pageObjects
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebElement

import com.google.common.collect.Iterators
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.exception.StepFailedException
import cucumber.api.java.After
import io.appium.java_client.AppiumDriver
import utils.Companion

public class AbstractPage {

	final int width = Mobile.getDeviceWidth()
	final int height = Mobile.getDeviceHeight()
	final double percentLarge = 0.8
	final double percentMin = 0.2
	final String lastestIndex = "last()"


	def setText(TestObject testObject, String value) {
		Mobile.setText(testObject, value, Companion.TIME_OUT)
	}


	def pressBack() {
		Mobile.pressBack()
	}

	def String getText(TestObject testObject) {
		return Mobile.getText(testObject, Companion.TIME_OUT, FailureHandling.OPTIONAL)
	}

	def tap(TestObject testObject) {
		Mobile.tap(testObject, Companion.TIME_OUT, FailureHandling.OPTIONAL)
	}

	def tap(TestObject testObject, int timeOut) {
		Mobile.tap(testObject, timeOut, FailureHandling.OPTIONAL)
	}

	def tapWithException(TestObject testObject){
		Mobile.tap(testObject, Companion.TIME_OUT)
	}

	def String selectRandomDropDownItem(String textToScroll){
		Mobile.scrollToText(textToScroll)
		try {
			Mobile.tap(findTestObject('selection/txtSelection', ['txt':textToScroll]), Companion.DELAY_TIME)
		}
		catch (Exception ex){
			swipeVertically(0.6, 0.5)
			tap(findTestObject('selection/txtSelection', ['txt':textToScroll]))
		}

		delay(Companion.DELAY_TIME)
		int randomNum = getRandomIndex(Companion.DYNAMIC_TEXT_VIEW_XPATH, 2)
		def result = getText(findTestObject('selection/optionItem', ['index':randomNum]))
		tap(findTestObject('selection/optionItem', ['index':randomNum]))
		return result
	}

	def selectDropDownMenu(String textToScroll){
		Mobile.scrollToText(textToScroll)
		try {
			Mobile.tap(findTestObject('selection/txtSelection', ['txt':textToScroll]), Companion.DELAY_TIME)
		}
		catch (Exception ex){
			swipeVertically(0.6, 0.5)
			tap(findTestObject('selection/txtSelection', ['txt':textToScroll]))
		}

		delay(Companion.DELAY_TIME)
	}

	def Boolean isVisible(TestObject testObject) {
		return Mobile.verifyElementVisible(
				testObject,
				Companion.TIME_OUT,
				FailureHandling.OPTIONAL)
	}

	def delay(int seconds) {
		Mobile.delay(seconds)
	}

	def delay() {
		delay(Companion.DELAY_TIME)
	}


	def Boolean isDisplayed(TestObject testObject) {
		String condition=Mobile.getAttribute(testObject, 'displayed', Companion.TIME_OUT)
		if (condition.equals('true')) {
			return true
		}else {
			return false
		}
	}

	def swipeVertically(double startPercentY, double endPercentY) {
		int pointX = width/2
		int startY = (int) (height * startPercentY)
		int endY = (int) (height * endPercentY)
		Mobile.swipe(pointX, startY, pointX, endY)
	}

	def swipeDown() {
		swipeVertically(percentMin, percentLarge)
	}

	def swipeUp() {
		swipeVertically(percentLarge, percentMin)
	}


	def swipehorizontally(double pointPercentX, double startPercentX, double endPercentX) {
		int pointY = (int)pointPercentX
		int startX = (int)(height * startPercentX)
		int endX = (int)(height * endPercentX)
		Mobile.swipe(startX, pointY, endX, pointY)
	}

	def swipeLeft(double pointPercentX) {
		swipehorizontally(pointPercentX, percentLarge, percentMin)
	}

	def swipeRight(double pointPercentX) {
		swipehorizontally(pointPercentX, percentLarge, percentMin)
	}

	def TestObject getTestObjectByText(String text, int index) {
		return findTestObject('dynamic/txtDynamic', ['txt':text, 'index': index])
	}

	def TestObject getTestObjectByText(String text, String index) {
		return findTestObject('dynamic/txtDynamic', ['txt':text, 'index': index])
	}

	def tapText(String text, int index) {
		tap(getTestObjectByText(text, index))
	}

	def TestObject getTestObjectByText(String text) {
		return getTestObjectByText(text, 1)
	}

	def TestObject getLastestText(String text) {
		tap(getTestObjectByText(text, lastestIndex))
	}

	def tapText(String text) {
		tap(getTestObjectByText(text))
	}

	def List<WebElement> getListItemByLocator(String locator) {
		AppiumDriver<?> driver = MobileDriverFactory.getDriver()
		List<WebElement> elements = driver.findElementsByXPath(locator)
		return elements
	}

	def int getRandomIndex(String locator, int minIndex) {
		int maxIndex = getListItemByLocator(locator).size()
		int randomNum = minIndex + (int)(Math.random() * maxIndex)
	}

	def swipeToName(String name) {
		for(int i;i<=100;i++) {
			try {
				if(checkDisplayedByText(name))
					break
				Mobile.scrollToText(name)
			} catch (Exception e) {
				e.printStackTrace()
			}
		}
	}

	def Boolean checkDisplayedByText(String text) {
		boolean result = isVisible(getTestObjectByText(text))
		return result
	}


	def pressBackHomePage() {
		while (!isNavigatedHomePage()) {
			pressBack()
		}
	}

	def boolean isNavigatedHomePage() {
		try {
			Mobile.tap(findTestObject('main/lnkHome'), Companion.TIME_OUT)
		}
		catch (Exception ex) {
			return false
		}
		return true
	}

	def Boolean isEnabled(TestObject testObject) {
		String condition=Mobile.getAttribute(testObject, 'enable', Companion.TIME_OUT)
		if (condition.equals('true')) {
			return true
		}else {
			return false
		}
	}

	//random string
	private static final String CHAR_LIST = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	private static final int RANDOM_STRING_LENGTH = 6;
	public String generateRandomString() {
		StringBuffer randStr = new StringBuffer();
		for (int i = 0; i < RANDOM_STRING_LENGTH; i++) {
			int number = getRandomNumber();
			char ch = CHAR_LIST.charAt(number);
			randStr.append(ch);
		}
		return randStr.toString();
	}
	private int getRandomNumber() {
		int randomInt = 0;
		Random randomGenerator = new Random();
		randomInt = randomGenerator.nextInt(CHAR_LIST.length());
		if (randomInt - 1 == -1) {
			return randomInt;
		} else {
			return randomInt - 1;
		}
	}
}


