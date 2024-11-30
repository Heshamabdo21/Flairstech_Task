$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("C:/1-H/Projects/KatalonStudio/Flairstech_Task/Include/features/Task/Task1.feature");
formatter.feature({
  "name": "General Store App Functionality",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Verify product selection, cart functionality, and total amount in General Store App",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "I open the General Store app on an android device",
  "keyword": "Given "
});
formatter.match({
  "location": "Task1.openApp()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I select \"Egypt\" from the country dropdown",
  "keyword": "When "
});
formatter.match({
  "location": "Task1.selectCountry(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I enter my name as \"Hesham Abd Elhamed\" in the text field",
  "keyword": "And "
});
formatter.match({
  "location": "Task1.enterName(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I select \"Male\" as my gender",
  "keyword": "And "
});
formatter.match({
  "location": "Task1.selectGender(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on the Let’s Shop button",
  "keyword": "And "
});
formatter.match({
  "location": "Task1.clickButton()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I add the first product to the cart",
  "keyword": "Then "
});
formatter.match({
  "location": "Task1.addFirstProduct()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I add the second product to the cart",
  "keyword": "And "
});
formatter.match({
  "location": "Task1.addSecondProduct()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I navigate to the cart screen",
  "keyword": "When "
});
formatter.match({
  "location": "Task1.navigateToCart()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I verify that the selected products are displayed in the cart",
  "keyword": "Then "
});
formatter.match({
  "location": "Task1.verifyProducts()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I assert that the total amount equals the sum of the two products\u0027 values",
  "keyword": "And "
});
formatter.match({
  "location": "Task1.verifyTotalAmount()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "i close the android app",
  "keyword": "Then "
});
formatter.match({
  "location": "Task1.closeapp()"
});
formatter.result({
  "status": "passed"
});
});