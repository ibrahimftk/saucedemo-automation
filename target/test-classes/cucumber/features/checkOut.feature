Feature: Check out products from shopping cart
    @CO @Positive
    Scenario: Success Checkout products
    Given I already add products to my shopping cart
    And I am on my cart page
    When I click Checkout button
    And Application shows Information Checkout page
    And I input first name field
    And I input last name field
    And I input postal code field
    And I click Continue button
    And Application shows Checkout Overview page
    And I click Finish button
    Then Success message checkout was appeared

    @CO @Negative
    Scenario: Failed Checkout products
    Given I already add products to my shopping cart
    And I am on my cart page
    When I click Checkout button
    And Application shows Information Checkout page
    And I left first name last name and postal code field blank
    And I click Continue button
    Then Error message checkout was appeared