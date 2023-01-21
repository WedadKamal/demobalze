@smoke


Feature: F05_checkoutRandomItem | user could checkout random Item successfully

  Scenario: S06_checkoutRandomItem | user could checkout random Item successfully

    When user select random Item
    And user click on add cart Button
    And user select cart page
    And user select placeOrder button
    And user enter placeorder data
    And user select purchase button
    Then user could assert on thank you message
