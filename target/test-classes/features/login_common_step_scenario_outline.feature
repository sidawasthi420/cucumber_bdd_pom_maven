Feature: Login Functionality
    We will validate all the positive and negative edge case scenarios related to login functinality here

    Background: 
        And Navigate to url "https://shivohamautomation.com/"
        
    Scenario Outline: Validate that login is working fine with valid credentials
        When User enter the username as "<username>" and password as "<password>"
        And  User clicks on Login button
        Then User should get logged in successfully
        And Enter the data in the user table given below
             |siddhant|awasthi|31|
             |ravi ratan|raj|32|
             |mukul|varshney|24|

    Examples:
        | username | password   |
        | siddhant | system123# |
        | ravi     | test123#   |
        | tariq    | system123# |