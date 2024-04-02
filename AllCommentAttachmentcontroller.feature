Feature: Testing all user comment attachment controller APIs

  Scenario: User comment attachment POST API test
    Given Valid baseURI for user comment attachment
    When Request is sent to server for comment attachment for commentId "e3ed5467-d393-45a1-a822-6f3e0a715801" with key "attachments" filepath "C:\Users\sriva\OneDrive\Pictures\catalog.png"
    Then User comment attachment should be successfully posted
    
	Scenario: Delete comment attachment with commentID
    Given Enter Valid base uri to Delete comment attachment
    When We send request to server to Delete comment attachment with Id ""
    Then Attachment with given id should be deleted
