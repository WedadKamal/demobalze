@smoke


Feature: F04_addRandomItemToCartAndDeleteIt | user could add random Item to cart and remove it from cart

  Scenario: S04_addRandomItemToCart | user could add random Item to cart

    When user select random Item
    And user click on add cart Button
    Then user could assert that item displayed on the cart

  Scenario: S05_removeItemFromCart | user could remove Item from cart

    When user select random Item
    And user click on add cart Button
    And user select cart page
    And user remove the item from the cart
    Then user could assert that item doesn`t display on the cart