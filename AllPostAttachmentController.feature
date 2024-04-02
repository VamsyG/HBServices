Feature: Testing all post attachment controller APIs

  Scenario: User post attachment POST API test
    Given Valid baseURI for user post attachment
    When Request is sent to server for post attachment for postId "e3ed5467-d393-45a1-a822-6f3e0a715801" with key "attachments" filepath "C:\Users\sriva\OneDrive\Pictures\catalog.png"
    Then User post attachment should be successfully posted
    
  Scenario: Delete post attachment with commentID
    Given Enter Valid base uri to Delete post attachment
    When We send request to server to Delete post attachment with Id ""
    Then Attachment with given post id should be deleted