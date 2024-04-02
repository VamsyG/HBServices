Feature: Testing all user call log controller APIs

  Scenario: Getting Sharepoint Welcome GET API test
    Given Giving baseURI given to get welcome
    When Request is sent to server to welcome 
    Then Welcome sharepoint will obtain

  Scenario: Getting documents by ID GET API test
    Given Giving basURI given to get documents
    When Request is sent to server with item ID "01XCQ7OEUOJ4XXZYY7XBCZGN7WID7GKEFQ"
    Then documents of that item id will obtain

  Scenario: Getting document GET API test
    Given Giving basURI given to get document
    When Request is sent to a server to get document with itemID "" userName "" entityName ""
    Then Document will obtain

  Scenario: Getting all documents by itemID GET API test
    Given Giving basURI given to get documentss
    When Request is sent to a server with item ID "01XCQ7OEUOJ4XXZYY7XBCZGN7WID7GKEFQ"
    Then All documents of that item id will obtain

  Scenario: Downloading document GET API test
    Given Giving basURI given to download document
    When Request is sent to a server to download document with itemID "" userName "" entityName ""
    Then Document will be downloaded

  Scenario: Delete sharepoint document DELETE API test
    Given Giving basURI given to delete document
    When Request is sent to a server to get property with itemId ""
    Then Document should be deleted

  Scenario: Promote deal by dealID POST API test
    Given Giving basURI given to Promote deal by dealID
    When Request is sent to a server to Promote deal by dealID ""
    Then Deal with that ID will be promoted

  Scenario: Uploading document for a deal POST API test
    Given Giving basURI given to uploading doc by itemID
    When Request is sent to a server to uploading doc by itemID "01XCQ7OEVQDBVCBSURDRFZU3EJBOCEIA3M" and key "file" filepath "C:\Users\sriva\OneDrive\Pictures\hawksbaywatermark.png"
    Then Document will get upload fro deal



        