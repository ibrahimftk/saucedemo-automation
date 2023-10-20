Feature: Log out from application
    @Logout @Positive
    Scenario: Success Log out from application 
    Given I have logged in to application
    When I click side menu
    And I click Logout from side menu
    Then I should be logged out from application and redirected to login page