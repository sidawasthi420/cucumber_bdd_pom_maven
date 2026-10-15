Feature: Login functionality

  # This scenario checks whether a user can login successfully
  Scenario: Validate if login successfull with correct credentials

  
    Given Open the chrome browser

    And Navigate to the URL

    And Go to the Practice Page 

    And Go to the Test Login Page

    When User enters valid Username and Password

    And Click on login button

    Then User should be logged in successfully

    And Close the browser