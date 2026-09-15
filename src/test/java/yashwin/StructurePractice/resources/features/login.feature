Feature: Login Functionality

  Scenario: Login with valid credentials

    Given User navigates to url "https://www.shivohamautomation.com/"
    When User clicks on Login button
    And User enters username as "siddhant" and password as "system123"
    And User clicks on Login button again