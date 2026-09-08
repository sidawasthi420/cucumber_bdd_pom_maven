Feature: Login Functionality
    We will validate all the positive and negative edge case scenarios related to login functinality here

    Background: 
        And Navigate to url "https://shivohamautomation.com/"
        When User enter the username as "siddhant" and password as "system123#"
        And  User clicks on Login button

    Scenario: Validate that login is working fine with valid credentials
        Then User should get logged in successfully

    Scenario: Validate that login is not working fine with invalid credentials
        Then User should not get logged-in into the application