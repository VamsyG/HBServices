Feature: Get All Lookup data fields



Scenario: GET Financial Suitability API test
Given The valid baseURI to get user
When request is sent to the server
Then Financial Suitability fields should be obtained
When Inavalid request sent to servr
Then Financial Suitability fields should not be obtained


Scenario: GET Countries and States API test
Given The valid baseUrl to get user
When request is sent to server
Then Countries and States fields should be obtained with status code 200
When request is sent to server with invuri
Then Countries and States fields shouldnot be obtained 