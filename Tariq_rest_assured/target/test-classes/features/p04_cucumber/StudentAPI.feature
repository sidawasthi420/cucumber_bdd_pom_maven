Feature: Student API Testing

  Scenario: Complete student API CRUD flow

    Given student API is available

    When I send POST request to create student
    Then response status code should be "201"

    When I send GET request for created student
    Then response status code should be "200"

    When I send PUT request to update created student
    Then response status code should be "200"

    When I send PATCH request to partially update created student
    Then response status code should be "200"

    When I send DELETE request for created student
    Then response status code should be "200"