Feature: Getting user by giving  UserId

  Scenario: Get user by giving userId GET API test
    Given Righ baseURI given to get post
    When Request is sent to server with userId "" page "" size ""
    Then User by user will obtain
