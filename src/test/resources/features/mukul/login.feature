Feature: Login functionality

  Scenario: Login with valid username and password
    Given I open the Chrome browser
    And I navigate to the login page "https://practicetestautomation.com/practice-test-login/"
    When I enter username "student" and password "Password123"
    And I click on the Submit button
    Then I should be logged in successfully