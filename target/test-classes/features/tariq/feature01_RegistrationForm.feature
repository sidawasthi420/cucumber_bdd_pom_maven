Feature: Registration Form

  Scenario: Fill Registration Form with valid credentials

    Given user navigates to url "https://shivohamautomation.com/"
    And user clicks on Join Now button
    When user successfully navigates to Registration page
    And user enters the full name as "Tariq"
    And user enters the email as "tariqahmad8057@gmail.com"
    And user enters the phone number as "9258678692"
    And user selects the course from dropdown as "API Testing"
    And user selects the date as "14-09-2026"
    And user clicks on Register Now button
    Then user should successfully submit the registration form
