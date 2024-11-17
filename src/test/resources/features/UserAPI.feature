Feature: User API Testing

  Scenario: Verify product retrieval by ID
    Given I set the base URI for the API
    When I send a GET request to "/products/1"
    Then the response status code should be 200
    And the response should contain "1+"