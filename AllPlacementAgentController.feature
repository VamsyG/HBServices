Feature: Get Placement agent notifications

  Scenario: Placement Agent requests GET API test
    Given I want to write valid base URI to get user
    When Request is sent to server
    Then Placement agent approvals should display 
    When Request sent to server is invalid
    Then Placement agent approvals should not display

    
  Scenario: Paginated placement Agent requests POST API test
    Given Entere valid base URI to get user
    When Request is sentto server with validid 117
    Then Placement agent approvals should get posted 
    When Request is sentto server with invalid id 1
    Then Placement agent approvals should not get posted 
    
  Scenario: Paginated placement Agent requests GET API test
    Given Entr valid base URI to get user
    When Request is to server
    Then Paginated placement agent approvals should display
    When Request is given without size
    Then Default paginated approvals should display
  
    