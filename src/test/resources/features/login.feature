Feature: Login Functionality
    We will validate all the positive and negative edge case scenarios related to login functinality here

    Background: 
        And Navigate to url "https://shivohamautomation.com/"
        And Click on Login button

    Scenario: Validate that login is working fine with valid credentials
        When User enter the username as "siddhant" and password as "system123"
        And  User clicks on Login button
        Then User should get logged in successfully
        And Click on Logout button