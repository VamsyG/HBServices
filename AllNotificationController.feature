Feature: Testing all notification controller APIs

	Scenario: Retreiving the notifications by ID
    Given Valid base uri to get notification
    When I send request to server to get notification with id "" page "" size "" type ""
    Then Notifications of that id should be fetched
    
  Scenario: Editing the notifications with ID
    Given Enter Valid base uri to edit notifications
    When We send request to server to edit notifications with id "0abd3ff6-d6dd-4a3d-9443-5e57f844a0f2" status "UNREAD"
    Then Notifications with given id should be edited
    
  Scenario: Create the notifications with ID
    Given Enter Valid base uri to create notifications
    When We send request to server to create notifications with userId "55" message "string" title "string" type "PLACEMENT_AGENT_REVIEW"
    Then Notifications with given id should be created
    
  Scenario: Retreiving the unread notifications by ID
    Given Entering Valid base uri to get unread notifications
    When We send request to te server to get unread notifications with userId "55"
    Then Unread notifications of that user should be obtained