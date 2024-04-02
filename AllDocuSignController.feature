Feature: Testing all user call log controller APIs

  Scenario: Check URL is signed GET API test
    Given Correct baseURI given to get signed URL
    When Request is sent to server with email "ge5dl5hty6@lettershield.com" userName "ge5dl5hty6@lettershield.com" offeringId "11" userId "114"
    Then Signed URL will obtain
    
  Scenario: Get file from S3 GET API test
    Given Correct baseURI given to get offering stats
    When Request is sent to server valid
    Then File will obtain
    
  Scenario: Check file is signed GET API test
    Given Correct baseURI given to get signed file
    When Request is sent to server with state "db05fbf6-acce-4bd3-998e-ee7a13fc8bdb" event "signing_complete" offeringId "11" userId "114" envelopeId "d1c72a95-48b9-4743-a9c3-34c04e40a3cc"
    Then Signed file will obtain