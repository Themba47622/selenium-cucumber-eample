Feature: User Login

  Scenario: login with valid credentials
    Given I am on the login page
    When I type "standard_user" in the email field
    And I type "secret_sauce" in the password field
    And I click on the Login button
    Then I see the SWAG logo on the home page

  Scenario: login with invalid credentials
    Given I am on the login page
    When I type "standard_user" in the email field
    And I type "0000" in the password field
    And I click on the Login button
    Then I see an error message