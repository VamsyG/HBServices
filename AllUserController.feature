Feature: User controller Operations

  Scenario: Get User by ID GET API test
    Given Valid baseURI to get user
    When Request is sent to server with id 55
    Then User should be successfully obtained
    When Request is sent to server with invalid id 515
    Then User null
    When Request is sent to server without id
    Then Not found
    
  Scenario: Get User by ID PUT API test
    Given Valid baseURI to update user
    When Request is sent to server with update id 55 
    Then User should be successfully updated
    When Request is sent to server to update without body
    Then User should not be updated
    When Request is sent to server with body and with invalid id 515 
    Then User should be not updated
    
	Scenario: Login POST API testing
		Given Valid baseURI to login
		When Request is sent to the server with email and password "srivamsi962@gmail.com" and "Abcd_1234"
		Then Login must be successful
		When Invalid UN and valid PW "srivamsi96@gmail.com" and "Abcd_1234"
		Then Login must be unsuccessful
		When Valid UN and invalid PW "srivamsi962@gmail.com" and "Abcd_123"
		Then Login should fial
		When No UN and No PW "" and ""
		Then Login shouldnt pass
		
	Scenario: Password reset GET API test
		Given The valid basUri to reset pw
		When request is sent to the server with valid username "srivamsi962@gmail.com"
		Then Password should be reset
		When request is sent to the server with invalid username ""
		Then Password shouldnot be reset
		
	Scenario: QR code generator GET API test
		Given The valid basUrl to  QR code generation
		When request is sent to the server for QR code with validid 55
		Then QR code should be generated
		When request is sent to the server for QR code with invalidid 515
		Then QR code shouldnt be generated
		When request is sent to the server without id with url for QR code
		Then QR code should not be generated
		
	Scenario: User logout GET API test
		Given The valid basUrl to  user logout
		When request is sent to the server with url for user logout with token id "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJ4ZE1RMHpfWG1UMng2UHEzNFh0YVBjZXYwTnNlMGdjNG1RbTBhelBzU0swIn0.eyJleHAiOjE3MDkwMzU5MTUsImlhdCI6MTcwOTAxNzkxNSwianRpIjoiYzIwNTVjY2EtODA5Mi00Njc2LWI3NDItMTdmYTFkNmUxNTA1IiwiaXNzIjoiaHR0cHM6Ly9yOTl1dzMyczRhLmV4ZWN1dGUtYXBpLnVzLWVhc3QtMS5hbWF6b25hd3MuY29tL3JlYWxtcy9oYXdrcyIsImF1ZCI6ImFjY291bnQiLCJzdWIiOiJkNzY4ZjczZS0xNDkzLTQxZDYtYjJkMS0yMGM5YmYyMTM0ZGEiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJoYXdrcy1hZG1pbiIsInNlc3Npb25fc3RhdGUiOiI0NWJlMWI1Zi1iMmZmLTQ4NTgtOTEwZi02YTYwYzY0ODBhN2UiLCJhY3IiOiIxIiwicmVhbG1fYWNjZXNzIjp7InJvbGVzIjpbIm9mZmxpbmVfYWNjZXNzIiwidW1hX2F1dGhvcml6YXRpb24iLCJBRE1JTiIsImRlZmF1bHQtcm9sZXMtaGF3a3MiXX0sInJlc291cmNlX2FjY2VzcyI6eyJhY2NvdW50Ijp7InJvbGVzIjpbIm1hbmFnZS1hY2NvdW50IiwibWFuYWdlLWFjY291bnQtbGlua3MiLCJ2aWV3LXByb2ZpbGUiXX19LCJzY29wZSI6InByb2ZpbGUgZW1haWwiLCJzaWQiOiI0NWJlMWI1Zi1iMmZmLTQ4NTgtOTEwZi02YTYwYzY0ODBhN2UiLCJlbWFpbF92ZXJpZmllZCI6dHJ1ZSwibmFtZSI6IkthbmUgU3R1YXJ0IiwicHJlZmVycmVkX3VzZXJuYW1lIjoic3JpdmFtc2k5NjJAZ21haWwuY29tIiwiZ2l2ZW5fbmFtZSI6IkthbmUiLCJmYW1pbHlfbmFtZSI6IlN0dWFydCIsImVtYWlsIjoic3JpdmFtc2k5NjJAZ21haWwuY29tIn0.u5W56gct4RLGzfUww-fc6lRP8EFvcvm1tZpAKd9llu-7z_WJzFbaziLqmlizUzJF9fByiu-bfzTnNh3LiBCz-XkqJKgtMn60iTlwKZmP80NHcrAlWSQzvkafE9_q0erThl1EOXyo0J3d8_iF90yu-PFBOAnFB_4LdaVMxZk6LkpnS410n1rKE3kO3pO_O7Pc5rGPgcs2hfceZ0IcvhumgDXdz0puPH08E9jtaRc3w74p3fg0Iwd-dEVE2LYn_udkv4IN727UOBfSsF51gP6gQtExkwlcLcumlDpbouqzMDoNyWag8hdndEqFWGM57YDpDNUHmXYZe6-F-LdeWLepRg"
		Then User should be logged out
		When request is sent to the server with invaldiurl for user logout without token id ""
		Then User should not be logged in
		
		
	Scenario: User logout GET API test
		Given The valid basUrl to  user logout
		When request is sent to the server with url for user logout with token id "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJ4ZE1RMHpfWG1UMng2UHEzNFh0YVBjZXYwTnNlMGdjNG1RbTBhelBzU0swIn0.eyJleHAiOjE3MDkwMzU5MTUsImlhdCI6MTcwOTAxNzkxNSwianRpIjoiYzIwNTVjY2EtODA5Mi00Njc2LWI3NDItMTdmYTFkNmUxNTA1IiwiaXNzIjoiaHR0cHM6Ly9yOTl1dzMyczRhLmV4ZWN1dGUtYXBpLnVzLWVhc3QtMS5hbWF6b25hd3MuY29tL3JlYWxtcy9oYXdrcyIsImF1ZCI6ImFjY291bnQiLCJzdWIiOiJkNzY4ZjczZS0xNDkzLTQxZDYtYjJkMS0yMGM5YmYyMTM0ZGEiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJoYXdrcy1hZG1pbiIsInNlc3Npb25fc3RhdGUiOiI0NWJlMWI1Zi1iMmZmLTQ4NTgtOTEwZi02YTYwYzY0ODBhN2UiLCJhY3IiOiIxIiwicmVhbG1fYWNjZXNzIjp7InJvbGVzIjpbIm9mZmxpbmVfYWNjZXNzIiwidW1hX2F1dGhvcml6YXRpb24iLCJBRE1JTiIsImRlZmF1bHQtcm9sZXMtaGF3a3MiXX0sInJlc291cmNlX2FjY2VzcyI6eyJhY2NvdW50Ijp7InJvbGVzIjpbIm1hbmFnZS1hY2NvdW50IiwibWFuYWdlLWFjY291bnQtbGlua3MiLCJ2aWV3LXByb2ZpbGUiXX19LCJzY29wZSI6InByb2ZpbGUgZW1haWwiLCJzaWQiOiI0NWJlMWI1Zi1iMmZmLTQ4NTgtOTEwZi02YTYwYzY0ODBhN2UiLCJlbWFpbF92ZXJpZmllZCI6dHJ1ZSwibmFtZSI6IkthbmUgU3R1YXJ0IiwicHJlZmVycmVkX3VzZXJuYW1lIjoic3JpdmFtc2k5NjJAZ21haWwuY29tIiwiZ2l2ZW5fbmFtZSI6IkthbmUiLCJmYW1pbHlfbmFtZSI6IlN0dWFydCIsImVtYWlsIjoic3JpdmFtc2k5NjJAZ21haWwuY29tIn0.u5W56gct4RLGzfUww-fc6lRP8EFvcvm1tZpAKd9llu-7z_WJzFbaziLqmlizUzJF9fByiu-bfzTnNh3LiBCz-XkqJKgtMn60iTlwKZmP80NHcrAlWSQzvkafE9_q0erThl1EOXyo0J3d8_iF90yu-PFBOAnFB_4LdaVMxZk6LkpnS410n1rKE3kO3pO_O7Pc5rGPgcs2hfceZ0IcvhumgDXdz0puPH08E9jtaRc3w74p3fg0Iwd-dEVE2LYn_udkv4IN727UOBfSsF51gP6gQtExkwlcLcumlDpbouqzMDoNyWag8hdndEqFWGM57YDpDNUHmXYZe6-F-LdeWLepRg"
		Then User should be logged out
		When request is sent to the server with invaldiurl for user logout without token id ""
		Then User should not be logged in
		
		
	Scenario: Creating user requests POST API test
    Given Enter valid base URL to get user
    When Request is send to server to create user with username "kaspuzarku@gufum.com" firstname "Kasp" lastname "Zark" roleId 1 roleName "ADMIN" password "Abcd_1234" phoneNumber "+917201923847" 
    Then User should get created 
		