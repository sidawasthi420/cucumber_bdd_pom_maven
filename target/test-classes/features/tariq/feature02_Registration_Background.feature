Feature: Registration Form

  Background:
    Given user navigates to url "https://shivohamautomation.com/"
    And user clicks on Join Now button
    When user successfully navigates to Registration page

  Scenario Outline: Validate registration form with valid user details
    And user enters the full name as "<fullName>"
    And user enters the email as "<email>"
    And user enters the phone number as "<phone>"
    And user selects the course from dropdown as "<course>"
    And user selects the date as "<date>"
    And user prints the registration data given below
      | Name     | Course      | Phone      |
      | Tariq    | API Testing | 9258678692 |
      | Mukul    | Selenium    | 9876543210 |
      | Ravi Raj | Core JAVA   | 8765432109 |
    And user clicks on Register Now button
    Then user should successfully submit the registration form

    Examples:
      | fullName | email                    | phone      | course      | date       |
      | Tariq    | tariqahmad8057@gmail.com | 9258678692 | API Testing | 14-09-2026 |
      | Mukul    | mukul123@gmail.com       | 9876543210 | Selenium    | 15-09-2026 |
      | Ravi Raj | ravi123@gmail.com        | 8765432109 | Core JAVA   | 16-09-2026 |
