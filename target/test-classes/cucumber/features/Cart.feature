Feature: Manage Products in Shopping Cart
    @Cart @Positive
    Scenario: Add Products to Shopping Cart
    Given I have logged in to application and i am on products page
    When I click Add to cart button
    Then The product should be added to the shopping cart

    @Cart @Positive
    Scenario: Remove Products from Shopping Cart
    Given I have logged in to application and i am on products page
    And There is a product already added to my shopping cart
    When I click remove button for that product
    Then That product should be removed from the shopping cart