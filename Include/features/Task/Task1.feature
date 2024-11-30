Feature: General Store App Functionality

  Scenario: Verify product selection, cart functionality, and total amount in General Store App
    Given I open the General Store app on an android device
    When I select "Egypt" from the country dropdown
    And I enter my name as "Hesham Abd Elhamed" in the text field
    And I select "Male" as my gender
    And I click on the Let’s Shop button
    Then I add the first product to the cart
    And I add the second product to the cart
    When I navigate to the cart screen
    Then I verify that the selected products are displayed in the cart
    And I assert that the total amount equals the sum of the two products' values
    Then i close the android app