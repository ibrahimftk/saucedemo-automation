Feature: Log in to the application
    @Login @Positive
    Scenario: Log in to application using valid credentials
        Given I am on the login page
        And There is a username and password field
        When I fill in the username field with standard_user
        And I fill in the password field with secret_sauce
        And I press the log in button
        Then I should be logged into the application and show the products page
    
    @Login @Negative
    Scenario: Log in to application using invalid credentials
        Given I am on the login page
        And There is a username and password field
        When I fill in the username field with standard_user
        And I fill in the password field with password
        And I press the log in button
        Then I should see an error message indicating incorrect credentials
    
    @Login @Negative
    Scenario: Log in to application using locked out username
        Given I am on the login page
        And There is a username and password field
        When I fill in the username field with locked_out_user
        And I fill in the password field with secret_sauce
        And I press the log in button
        Then I should see an error message indicating locked out user