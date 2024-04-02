Feature: Testing all Userpost controller APIs

  Scenario: Update userpost by ID PUT API test
    Given Giving basURI given to Update userpost by ID
    When Request is sent to a server to Update userpost by ID "3de49051-f8b3-48ba-a259-3da387869921" postedById "21" postedToId "null" post "Strings are taken"
    Then Userpost with that ID should be updated
    
  Scenario: User post POST API test
    Given Valid baseURI for user post
    When Request is sent to server for key "attachments" filepath "C:\Users\sriva\OneDrive\Pictures\catalog.png" for key "post" filepath "C:\Users\sriva\OneDrive\Desktop\json.json"
    Then User post should be successfully posted
    
  Scenario: Get post by user id GET API test
    Given Rigth baseURI given to get post by Id
    When Request is sent to server to get post with userId 114
    Then Posts made by user will obtain
