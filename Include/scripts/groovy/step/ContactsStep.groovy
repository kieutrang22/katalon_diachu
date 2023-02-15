package step
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import pageObjects.ContactsPage

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class ContactsStep extends ContactsPage {

	@Given("Home page displays the Contacts button")
	public void homePageDisplaysTheContactsButton() {
		verifyContactsButton()
	}

	@When("Tap Contacts button")
	public void clickContactsButton() {
		tapContacts()
	}

	@And("Tap Company lnk")
	public void clickCompanyLnk() {
		tapCompany()
	}

	@Then("displays: name,address,phone number,image")
	public void displaysNameAddressPhoneNumberImage() {
		verifyCompanyPage()
	}

	@Then("Comany page: shows the company (.*)")
	public void comanyPageShowsTheCompanyName(String name) {
		swipeToName(name)
		verifyByElement(name.trim())
	}

	@And("Tap company (.*)")
	public void clickCompanyName(String name) {
		swipeToName(name)
		tapByElement(name)
	}

	@Then("displays (.*),(.*),(.*),(.*),(.*),introduce,call button")
	public void displaysNameAddressEmailWebsitePhoneNumberIntroduceCallButton(String address,String name,String email,String website,String phoneNumber) {
		verifyNameCompany(name.trim())
		verifyAddressCompany(address.trim())
		verifyByElement(email.trim())
		verifyByElement(website.trim())
		verifyByElement(phoneNumber.trim())
		verifyIntroduce()
		verifyCallButton()
	}

	@And("input (.*) to search bar")
	public void inputTextToSearchBar(String text) {
		inputToSearchBar(text)
	}

	@And("Tap Brokerlnk")
	public void tapBrokerLnk() {
		tapBroker()
	}

	@Then("Broker page: shows the broker (.*)")
	public void brokerPageShowsTheBrokerName(String name) {
		findBrokerName(name)
	}

	@And("Tap Broker (.*)")
	public void tapBrokerName1(String name) {
		tapElementByName(name)
	}

	@Then("displays (.*),(.*),(.*),rating,call button")
	public void displaysNameEmailPhoneNumberRatingCallButton(String name,String email,String phoneNumber) {
		verifyByElement(name)
		verifyByElement(email)
		verifyByElement(phoneNumber)
	}

	@And("input (.*) to broker search bar")
	public void inputTextBrokerSearchBar(String text) {
		inputToBrokerSearchBar(text)
	}

	@And("Tap BrokerageFirm lnk")
	public void clickBrokerageFirmLnk() {
		tapBrokerageFirmLnk()
	}

	@Then("Brokerage Firm: shows the Brokerage Firm (.*)")
	public void brokerageFirmShowsTheBrokerageFirmName(String name) {
		findBrokerageFirmName(name)
	}

	@And("Tap Brokerage Firm (.*)")
	public void clickBrokerageFirmName(String name) {
		tapElementByName(name)
	}

	@And("input (.*) to Brokerage Firm search bar")
	public void inputTextToBrokerageFirmSearchBar(String text) {
		inputToBrokerageFirmSearchBar(text)
	}

	@Then("Brokerage Firm page: shows the Brokerage Firm (.*)")
	public void brokerageFirmPageShowsTheBrokerageFirmName(String name) {
	}
}