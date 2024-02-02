Feature: weather

  Scenario: Retrieve weather information by Country ID.
    Given the user requests weather information for country with ID "1"
    When the request is sent to the "/weather/1" endpoint
    Then the response status should be 200 OK
    And the response should contain weather details for city "Gothenburg"


