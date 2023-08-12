Feature: User Login and Logout

  Scenario: Successful login
    Given User is on the login page
    When User enters valid username and password
    And User clicks the login button
    Then User should be logged in successfully

  Scenario: Successful logout
    Given User is logged in
    When User clicks the logout button
    Then User should be logged out successfully