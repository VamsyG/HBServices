Feature: Testing all user call log controller APIs

  Scenario: Editing call logs PUT API test
    Given Valid baseURI for editing call logs
    When Request is sent to server for editing call logs with id "d9e86dfa-c76d-4f21-ba4c-ee8e3a9aa745" fullName "shris admin" title "testing user subject" note "testing user call summary details" loggedById "36"
    Then Call logs should be successfully edited

  Scenario: Getting call logs GET API test
    Given Valid baseURI for getting call logs
    When Request is sent to server for Getting call logs with loggedById "36" keyword "" page "" size ""
    Then Call logs should be successfully obtained
    
  Scenario: Post call log POST API test
    Given Valid baseURI for posting call log
    When Request is sent to server to post call log with title "string" email "string@email.com" fullName "string" phonenumber "9802222198" note "Testing purpose" loggedbyId "1"
    Then Call log should be successfully posted    