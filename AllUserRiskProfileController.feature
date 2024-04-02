Feature:  User risk profile feature

Scenario: User risk profile GET API test
Given The valid basUrl to  get risk profile
When request is sent to the server for user risk profile with valid id 114
Then User risk profile should be obtained
When request is sent to the server for user risk profile with invalid id 1
Then User risk profile should not be obtained


Scenario: User risk profile PUT API test
Given The valid basUrl to put risk profile
When request is sent to the server for updating user risk profile with valid id 113
Then User risk profile should be updated
When request is sent to the server to update user risk profile with invalid id 1
Then User risk profile shouldnt get updated
When request is sent to the server to update user risk profile without body
Then User risk profile should not be updated


Scenario: User risk profile POST API test
Given The valid basUrl to  create risk profile
When request is sent to the server with for creating user risk profile
Then User risk profile should be created
When Request is sent to server without ID
Then User risk profile shouldnt be created