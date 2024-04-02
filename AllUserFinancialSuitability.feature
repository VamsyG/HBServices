Feature: User financial suitability feature

Scenario: User financial suitability GET API test
Given The valid basUrl to get financial suitability
When request is sent to the server with url for obtaining user financial suitability with valid id 113
Then User financial suitability should be obtained
When request is sent to the server with invalid for user financial suitability with invalid id 1
Then User financial suitability should not be obtained


Scenario: User financial suitability PUT API test
Given The valid basUrl to change financial suitability
When request is sent to the server with url for updating user financial suitability with valid id 113
Then User financial suitability should be updated
When request is sent to the server with url for updating user financial suitability with invalid id 1
Then User financial suitability shouldont be updated
When request is sent to the server with url for updating without body with valid id 113
Then User financial suitability should nt be updated


Scenario: User financial suitability POST API test
Given The valid basUrl to  create financial suitability profile
When request is sent to the server with for creating financial suitability profile
Then User financial suitability profile should be created
When request is sent to the server with invalid uid
Then User financial suitability profile shouldnt be created