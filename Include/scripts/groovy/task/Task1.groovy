package task
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class Task1 {
	@Given("I open the General Store app on an android device")
	def openApp() {
		String appPath = '.\\androidapp\\General-Store.apk'

		Mobile.startApplication(appPath, true)
	}

	@When("I select {string} from the country dropdown")
	def selectCountry(String country) {
		Mobile.waitForElementPresent(findTestObject('Object Repository/Pages/android.widget.Spinner Country Dropdown list'), 0)

		Mobile.tap(findTestObject('Object Repository/Pages/android.widget.Spinner Country Dropdown list'), 0)

		Mobile.scrollToText(country)

		Mobile.tap(findTestObject('Object Repository/Pages/android.widget.TextView - Egypt (1)'), 0)
	}

	@And("I enter my name as {string} in the text field")
	def enterName(String name) {
		Mobile.setText(findTestObject('Object Repository/Pages/android.widget.EditText - user name textbox'), name,
				0)

		Mobile.hideKeyboard()
	}

	@And("I select {string} as my gender")
	def selectGender(String gender) {
		if (gender == 'Male') {
			Mobile.tap(findTestObject('Object Repository/Pages/android.widget.RadioButton - Male'), 0)
		}
	}

	@And("I click on the Let’s Shop button")
	def clickButton() {
		Mobile.tap(findTestObject('Object Repository/Pages/android.widget.Button - Lets Shop btn'), 0)
	}
	String BeforeAdd_FirstProductName
	@Then("I add the first product to the cart")
	def addFirstProduct() {
		Mobile.tap(findTestObject('Object Repository/Pages/android.widget.TextView - First Product'), 0)

		BeforeAdd_FirstProductName=Mobile.getText(findTestObject('Object Repository/Pages/android.widget.TextView - First Product Name1'), 0)
	}
	String BeforeAdd_SecondProductName
	@And("I add the second product to the cart")
	def addSecondProduct() {
		Mobile.tap(findTestObject('Object Repository/Pages/android.widget.TextView - Second Product'), 0)

		BeforeAdd_SecondProductName=Mobile.getText(findTestObject('Object Repository/Pages/android.widget.TextView - Second Product Name1'), 0)
	}

	@When("I navigate to the cart screen")
	def navigateToCart() {
		Mobile.tap(findTestObject('Object Repository/Pages/android.widget.ImageButton Cart btn'), 0)
	}

	@Then("I verify that the selected products are displayed in the cart")
	def verifyProducts() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Pages/android.widget.TextView - First Product Name1'), 0)

		Mobile.verifyElementExist(findTestObject('Object Repository/Pages/android.widget.TextView - Second Product Name1'), 0)

		Mobile.verifyElementVisible(findTestObject('Object Repository/Pages/android.widget.TextView - First Product Name1'), 0)

		Mobile.verifyElementVisible(findTestObject('Object Repository/Pages/android.widget.TextView - Second Product Name1'), 0)

		String AfterAdd_FirstProductName=Mobile.getText(findTestObject('Object Repository/Pages/android.widget.TextView - First Product Name1'), 0)

		String AfterAdd_SecondProductName=Mobile.getText(findTestObject('Object Repository/Pages/android.widget.TextView - Second Product Name1'), 0)
		Mobile.verifyElementText(findTestObject('Object Repository/Pages/android.widget.TextView - First Product Name1'), BeforeAdd_FirstProductName)

		Mobile.verifyElementText(findTestObject('Object Repository/Pages/android.widget.TextView - Second Product Name1'), BeforeAdd_SecondProductName)
		Mobile.verifyEqual(BeforeAdd_FirstProductName, AfterAdd_FirstProductName)
		Mobile.verifyEqual(BeforeAdd_SecondProductName, AfterAdd_SecondProductName)
		assert AfterAdd_FirstProductName == BeforeAdd_FirstProductName
		assert AfterAdd_SecondProductName == BeforeAdd_SecondProductName
	}

	@And("I assert that the total amount equals the sum of the two products' values")
	def verifyTotalAmount() {
		double FirstProductPrice =Mobile.getText(findTestObject('Object Repository/Pages/android.widget.TextView - First Product Price'), 0).replace('$', '').replace(',', '').toDouble()

		double SecondProductPrice =Mobile.getText(findTestObject('Object Repository/Pages/android.widget.TextView - Second Product Price'), 0).replace('$', '').replace(',', '').toDouble()

		double TotalProductPrice =Mobile.getText(findTestObject('Object Repository/Pages/android.widget.TextView - Total Price'), 0).replace('$', '').replace(',', '').toDouble()
		double expectedTotal = FirstProductPrice + SecondProductPrice
		Mobile.verifyEqual(TotalProductPrice, expectedTotal)

		assert TotalProductPrice == (FirstProductPrice + SecondProductPrice)
	}

	@Then("i close the android app")
	def closeapp() {
		Mobile.closeApplication()
	}
}