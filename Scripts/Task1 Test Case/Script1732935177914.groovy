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

String appPath = '.\\androidapp\\General-Store.apk'

Mobile.startApplication(appPath, true)
Mobile.waitForElementPresent(findTestObject('Object Repository/Pages/android.widget.Spinner Country Dropdown list'), 0)
Mobile.tap(findTestObject('Object Repository/Pages/android.widget.Spinner Country Dropdown list'), 0)

Mobile.scrollToText('Egypt')

Mobile.tap(findTestObject('Object Repository/Pages/android.widget.TextView - Egypt (1)'), 0)

Mobile.setText(findTestObject('Object Repository/Pages/android.widget.EditText - user name textbox'), 'Hesham Abd Elhamed', 
    0)

Mobile.hideKeyboard()

Mobile.tap(findTestObject('Object Repository/Pages/android.widget.RadioButton - Male'), 0)

Mobile.tap(findTestObject('Object Repository/Pages/android.widget.Button - Lets Shop btn'), 0)

Mobile.tap(findTestObject('Object Repository/Pages/android.widget.TextView - First Product'), 0)

String BeforeAdd_FirstProductName = Mobile.getText(findTestObject('Object Repository/Pages/android.widget.TextView - First Product Name1'), 
    0)

Mobile.tap(findTestObject('Object Repository/Pages/android.widget.TextView - Second Product'), 0)

String BeforeAdd_SecondProductName = Mobile.getText(findTestObject('Object Repository/Pages/android.widget.TextView - Second Product Name1'), 
    0)

Mobile.tap(findTestObject('Object Repository/Pages/android.widget.ImageButton Cart btn'), 0)

Mobile.verifyElementExist(findTestObject('Object Repository/Pages/android.widget.TextView - First Product Name1'), 0)

Mobile.verifyElementExist(findTestObject('Object Repository/Pages/android.widget.TextView - Second Product Name1'), 0)

Mobile.verifyElementVisible(findTestObject('Object Repository/Pages/android.widget.TextView - First Product Name1'), 0)

Mobile.verifyElementVisible(findTestObject('Object Repository/Pages/android.widget.TextView - Second Product Name1'), 0)

String AfterAdd_FirstProductName = Mobile.getText(findTestObject('Object Repository/Pages/android.widget.TextView - First Product Name1'), 
    0)

String AfterAdd_SecondProductName = Mobile.getText(findTestObject('Object Repository/Pages/android.widget.TextView - Second Product Name1'), 
    0)

double FirstProductPrice = Mobile.getText(findTestObject('Object Repository/Pages/android.widget.TextView - First Product Price'), 
    0).replace('$', '').replace(',', '').toDouble()

double SecondProductPrice = Mobile.getText(findTestObject('Object Repository/Pages/android.widget.TextView - Second Product Price'), 
    0).replace('$', '').replace(',', '').toDouble()

double TotalProductPrice = Mobile.getText(findTestObject('Object Repository/Pages/android.widget.TextView - Total Price'), 
    0).replace('$', '').replace(',', '').toDouble()

Mobile.verifyElementText(findTestObject('Object Repository/Pages/android.widget.TextView - First Product Name1'), BeforeAdd_FirstProductName)

Mobile.verifyElementText(findTestObject('Object Repository/Pages/android.widget.TextView - Second Product Name1'), BeforeAdd_SecondProductName)

Mobile.verifyEqual(BeforeAdd_FirstProductName, AfterAdd_FirstProductName)

Mobile.verifyEqual(BeforeAdd_SecondProductName, AfterAdd_SecondProductName)

double expectedTotal = FirstProductPrice + SecondProductPrice

Mobile.verifyEqual(TotalProductPrice, expectedTotal)

Mobile.closeApplication()

