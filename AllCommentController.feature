Feature: Testing all comment controller APIs

  Scenario: Update user comment by ID PUT API test
    Given Giving basURI given to Update user comment by ID
    When Request is sent to a server to Update user comment by ID "fe5cdca4-f8fd-4f78-a98a-58473456b901" commentedById "21" post "3de49051-f8b3-48ba-a259-3da387869921" comment "Takenn"
    Then user comment with that ID should be updated

  Scenario: User comment POST API test
    Given Valid baseURI for user comment
    When Request is sent to server for comment with key "attachments" filepath "C:\Users\sriva\OneDrive\Pictures\catalog.png" for key "comment" filepath "C:\Users\sriva\OneDrive\Desktop\comment.json"
    Then User comment should be successfully posted
    