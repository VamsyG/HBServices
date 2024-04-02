package userService;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AllUserController {
	
	Response response;
	
	@Given("Valid baseURI to get user")
	public void valid_base_uri_to_get_user() {
		RestAssured.baseURI="https://r99uw32s4a.execute-api.us-east-1.amazonaws.com/user-service";
		System.out.println("-------------------------");
		System.out.println("Base URI given");
		System.out.println("-------------------------");
	}

	@When("Request is sent to server with id {int}")
	public void request_is_sent_to_server_with_id(Integer int1) {
		response = 
			given().
				header("Content-Type","application/json").
				contentType(ContentType.JSON).
				accept(ContentType.JSON).
			when().
				get("/api/v1/user/"+int1);
		System.out.println("-------------------------");
		System.out.println("Valid ID is passed");
		System.out.println("-------------------------");
	}

	
	@Then("User should be successfully obtained")
	public void user_should_be_successfully_obtained() {
		response.
		then().
			log().all();
		System.out.println("-------------------------");
		System.out.println("User with that ID is found");
		System.out.println("-------------------------");
	}
		
	@When("Request is sent to server with invalid id {int}")
	public void request_is_sent_to_server_with_invalid_id(Integer int1) {
		response = given().
				header("Content-Type","application/json").
				contentType(ContentType.JSON).
				accept(ContentType.JSON).
			when().
				get("/api/v1/user/"+int1);
		System.out.println("-------------------------");
		System.out.println("Invalid ID is passed");
		System.out.println("-------------------------");
	}


	@Then("User null")
	public void user_null() {
		response.
		then().
			log().all().
			statusCode(400);
		System.out.println("-------------------------");
		System.out.println("User with that ID is not found");
		System.out.println("-------------------------");
	}
	
	@When("Request is sent to server without id")
	public void request_is_sent_to_server_without_id() {
		response = given().
				header("Content-Type","application/json").
				contentType(ContentType.JSON).
				accept(ContentType.JSON).
			when().
				get("/api/v1/user/");
		System.out.println("-------------------------");
		System.out.println("No ID is passed");
		System.out.println("-------------------------");
	}

	@Then("Not found")
	public void not_found() {
		response.
		then().
			log().all().
			statusCode(404);
		System.out.println("-------------------------");
		System.out.println("Nothing is found");
		System.out.println("-------------------------");
	}

	//========================================================================================================================
	
	Map<String,Object> map = new HashMap<String,Object>();
	
	@Given("Valid baseURI to update user")
	public void valid_base_uri_to_update_user() {
		RestAssured.baseURI="https://r99uw32s4a.execute-api.us-east-1.amazonaws.com/user-service";
		System.out.println("-------------------------");
		System.out.println("Base URI given");
		System.out.println("-------------------------");	
	}

	@When("Request is sent to server with update id {int}")
	public void request_is_sent_to_server_with_update_id(Integer int1) {
		map.put("phoneNumber", "9182736451");
		JSONObject request = new JSONObject(map);

		response = given().
			header("Content-Type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).body(request.toJSONString()).
			when().
				put("/api/v1/user/"+int1);
			//	then().statusCode(200).contentType(ContentType.JSON).extract().response();
			System.out.println("-------------------------");
			System.out.println("Valid endpoint is passed");
			System.out.println("-------------------------");	
	}

	@Then("User should be successfully updated")
	public void user_should_be_successfully_updated() {
		response.
		then().
			log().all().
		assertThat().
			statusCode(200).
			header("Content-Type", "application/json");
		System.out.println("-------------------------");
		System.out.println("User should be successfully updated");
		System.out.println("-------------------------");  
	}
	
	@When("Request is sent to server to update without body")
	public void request_is_sent_to_server_to_update_without_body() {
		response = given().
				header("Content-Type","application/json").
				contentType(ContentType.JSON).
				accept(ContentType.JSON).
			when().
				put("/api/v1/user/55");
		System.out.println("-------------------------");
		System.out.println("Body is not passed");
		System.out.println("-------------------------");	
	}

	@Then("User should not be updated")
	public void user_should_not_be_updated() {
		response.
		then().
			log().all().
		assertThat().
			statusCode(400).
			header("Content-Type", "application/json");
		System.out.println("-------------------------");
		System.out.println("User should not be successfully updated");
		System.out.println("-------------------------");  
	}
	
	@When("Request is sent to server with body and with invalid id {int}")
	public void request_is_sent_to_server_with_body_and_with_invalid_id(Integer int1) {
		map.put("phoneNumber", "9182736451");
		JSONObject request = new JSONObject(map);

		response = given().
			header("Content-Type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).body(request.toJSONString()).
			when().
				put("/api/v1/user/"+int1);
			//	then().statusCode(200).contentType(ContentType.JSON).extract().response();
			System.out.println("-------------------------");
			System.out.println("Valid endpoint is passed");
			System.out.println("-------------------------");	
	}

	@Then("User should be not updated")
	public void user_should_be_not_updated() {
		response.
		then().
			log().all().
		assertThat().
			statusCode(400).
			header("Content-Type", "application/json");
		System.out.println("-------------------------");
		System.out.println("User should not get updated");
		System.out.println("-------------------------");  
	}
	
//========================================================================================================================
	
	public HashMap<Object,Object> map1=new HashMap<Object,Object>();
	public HashMap<Object,Object> map2=new HashMap<Object,Object>();
	public HashMap<Object,Object> map3=new HashMap<Object,Object>();
	public HashMap<Object,Object> map4=new HashMap<Object,Object>();
	
	@Given("Valid baseURI to login")
	public void valid_base_uri_to_login() {
		RestAssured.baseURI="https://r99uw32s4a.execute-api.us-east-1.amazonaws.com/user-service";
		System.out.println("Base URI given");
	}

	@When("Request is sent to the server with email and password {string} and {string}")
	public void request_is_sent_to_the_server_with_email_and_password_and(String string, String string2) {
	    map1.put("username", string);
	    map1.put("password", string2);
	    JSONObject request = new JSONObject(map1);
	    
	    response = given().
				header("Content-Type","application/json").
				contentType(ContentType.JSON).
				accept(ContentType.JSON).body(request.toJSONString()).
			when().
				post("/api/v1/user/login");
	}

	@Then("Login must be successful")
	public void login_must_be_successful() {
		response.
		then().
			log().all().
			assertThat().
				statusCode(200).
				header("Content-Type", "application/json");
		//then().statusCode(200).contentType(ContentType.JSON).extract().response();
	}
	
	@When("Invalid UN and valid PW {string} and {string}")
	public void invalid_un_and_valid_pw_and(String string, String string2) {
		map2.put("username", string);
	    map2.put("password", string2);
	    JSONObject request = new JSONObject(map2);
	    
	    response = given().
				header("Content-Type","application/json").
				contentType(ContentType.JSON).
				accept(ContentType.JSON).body(request.toJSONString()).
			when().
				post("/api/v1/user/login");	
	}

	@Then("Login must be unsuccessful")
	public void login_must_be_unsuccessful() {
		response.
		then().
			log().all().
			assertThat().
				statusCode(400).
				header("Content-Type", "application/json").
				body("message", Matchers.equalTo("User not found"));
	}
	
	@When("Valid UN and invalid PW {string} and {string}")
	public void valid_un_and_invalid_pw_and(String string, String string2) {
		map3.put("username", string);
	    map3.put("password", string2);
	    JSONObject request = new JSONObject(map3);
	    
	    response = given().
				header("Content-Type","application/json").
				contentType(ContentType.JSON).
				accept(ContentType.JSON).body(request.toJSONString()).
			when().
				post("/api/v1/user/login");	
	}

	@Then("Login should fial")
	public void login_should_fial() {
		response.
		then().
			log().all().
			assertThat().
				statusCode(400).
				header("Content-Type", "application/json").
				body("message", Matchers.equalTo("Keycloak Login failed!!"));
	}
	
	@When("No UN and No PW {string} and {string}")
	public void no_un_and_no_pw_and(String string, String string2) {
		map4.put("username", string);
	    map4.put("password", string2);
	    JSONObject request = new JSONObject(map4);
	    
	    response = given().
				header("Content-Type","application/json").
				contentType(ContentType.JSON).
				accept(ContentType.JSON).body(request.toJSONString()).
			when().
				post("/api/v1/user/login");	
	}

	@Then("Login shouldnt pass")
	public void login_shouldnt_pass() {
		response.
		then().
			log().all().
			assertThat().
				statusCode(400);
	}

//========================================================================================================================
	
	@Given("The valid basUri to reset pw")
	public void the_valid_bas_uri_to_reset_pw() {
		RestAssured.baseURI="https://r99uw32s4a.execute-api.us-east-1.amazonaws.com/user-service";
		System.out.println("Bae URI given");
	}

	@When("request is sent to the server with valid username {string}")
	public void request_is_sent_to_the_server_with_valid_username(String string) {
		response = given().
				header("Content-Type","application/json").
				contentType(ContentType.JSON).
				accept(ContentType.JSON).
			when().
				get("/api/v1/user/reset-password?username="+string);
//			then().contentType(ContentType.JSON).extract().response();
	}

	@Then("Password should be reset")
	public void password_should_be_reset() {
		response.
		then().
			log().all().
		assertThat().
			statusCode(200).
			header("Content-Type", "application/json");
		System.out.println("-------------------------");
		System.out.println("Password reset link should be sent");
		System.out.println("-------------------------");	
	}
	
	@When("request is sent to the server with invalid username {string}")
	public void request_is_sent_to_the_server_with_invalid_username(String string) {
		response = given().
				header("Content-Type","application/json").
				contentType(ContentType.JSON).
				accept(ContentType.JSON).
			when().
				get("/api/v1/user/reset-password?username="+string);
//			then().contentType(ContentType.JSON).extract().response();
	}
	
	@Then("Password shouldnot be reset")
	public void password_shouldnot_be_reset() {
		response.
		then().
			log().all().
		assertThat().
			statusCode(400).
			header("Content-Type", "application/json");
		System.out.println("-------------------------");
		System.out.println("Password reset link should not be sent");
		System.out.println("-------------------------");	

	}

//========================================================================================================================
	
	@Given("The valid basUrl to  QR code generation")
	public void the_valid_bas_url_to_qr_code_generation() {
		RestAssured.baseURI="https://r99uw32s4a.execute-api.us-east-1.amazonaws.com/user-service";
		System.out.println("-------------------------");
		System.out.println("Base URI given");
		System.out.println("-------------------------");	
	}

	
	@When("request is sent to the server for QR code with validid {int}")
	public void request_is_sent_to_the_server_for_qr_code_with_validid(Integer int1) {
		response = given().
				header("Content-Type","application/json").
				contentType(ContentType.JSON).
				accept(ContentType.JSON).
			when().
				get("/api/v1/user/qrCode?userId="+int1);
//			then().contentType(ContentType.JSON).extract().response();
		System.out.println("-------------------------");
		System.out.println("Valid endpoint is passed");
		System.out.println("-------------------------");	

	}

	@Then("QR code should be generated")
	public void qr_code_should_be_generated() {
		response.
		then().
			log().all().
		assertThat().
			statusCode(200).
			header("Content-Type", "application/json");
		System.out.println("-------------------------");
		System.out.println("QR Code URL should be obtained");
		System.out.println("-------------------------");  
	}
	
	@When("request is sent to the server for QR code with invalidid {int}")
	public void request_is_sent_to_the_server_for_qr_code_with_invalidid(Integer int1) {
		response = given().
				header("Content-Type","application/json").
				contentType(ContentType.JSON).
				accept(ContentType.JSON).
			when().
				get("/api/v1/user/qrCode?userId="+int1);
//			then().contentType(ContentType.JSON).extract().response();
		System.out.println("-------------------------");
		System.out.println("Invalid Id to endpoint is passed");
		System.out.println("-------------------------");	
	}

	@Then("QR code shouldnt be generated")
	public void qr_code_shouldnt_be_generated() {
		response.
		then().
			log().all().
		assertThat().
			statusCode(400).
			header("Content-Type", "application/json");
		System.out.println("-------------------------");
		System.out.println("QR Code URL should not be obtained");
		System.out.println("-------------------------");  
	}
	
	@When("request is sent to the server without id with url for QR code")
	public void request_is_sent_to_the_server_without_id_with_url_for_qr_code() {
		response = given().
				header("Content-Type","application/json").
				contentType(ContentType.JSON).
				accept(ContentType.JSON).
			when().
				get("/api/v1/user/qrCode");
			//then().contentType(ContentType.JSON).extract().response();
		System.out.println("-------------------------");
		System.out.println("Request without ID is passed");
		System.out.println("-------------------------");		
	}

	@Then("QR code should not be generated")
	public void qr_code_should_not_be_generated() {
		response.
		then().
			log().all().
		assertThat().
			statusCode(400).
			header("Content-Type", "application/json");
		System.out.println("-------------------------");
		System.out.println("QR Code URL shouldnt be obtained");
		System.out.println("-------------------------");  
	}

//========================================================================================================================
	
	@Given("The valid basUrl to  user logout")
	public void the_valid_bas_url_to_user_logout() {
		RestAssured.baseURI="https://r99uw32s4a.execute-api.us-east-1.amazonaws.com/user-service";
		System.out.println("-------------------------");
		System.out.println("Base URI given");
		System.out.println("-------------------------");	
	}

	@When("request is sent to the server with url for user logout with token id {string}")
	public void request_is_sent_to_the_server_with_url_for_user_logout_with_token_id(String string) {
		response = given().
				header("Content-Type","application/json").
				contentType(ContentType.JSON).
				accept(ContentType.JSON).
			when().
				get("/api/v1/user/logout?token="+string);
		System.out.println("-------------------------");
		System.out.println("Valid endpoint is passed");
		System.out.println("-------------------------");	
	}

	@Then("User should be logged out")
	public void user_should_be_logged_out() {
		response.
		then().
			log().all().
		assertThat().
			statusCode(200).
			header("Content-Type", "application/json");
		System.out.println("-------------------------");
		System.out.println("Placement agent should posted");
		System.out.println("-------------------------");
	}
		
	@When("request is sent to the server with invaldiurl for user logout without token id {string}")
	public void request_is_sent_to_the_server_with_invaldiurl_for_user_logout_without_token_id(String string) {
		response = given().
				header("Content-Type","application/json").
				contentType(ContentType.JSON).
				accept(ContentType.JSON).
			when().
				get("/api/v1/user/logout?token="+string);
		System.out.println("-------------------------");
		System.out.println("Invalid endpoint is passed");
		System.out.println("-------------------------");	
	}

	@Then("User should not be logged in")
	public void user_should_not_be_logged_in() {
		response.
		then().
			log().all().
		assertThat().
			statusCode(200).
			header("Content-Type", "application/json");
		System.out.println("-------------------------");
		System.out.println("Placement agent should posted");
		System.out.println("-------------------------");	
	}

//========================================================================================================================
	
	Map<String,Object> map5 = new HashMap<String,Object>();
	
	@Given("Enter valid base URL to get user")
	public void enter_valid_base_url_to_get_user() {
		RestAssured.baseURI="https://r99uw32s4a.execute-api.us-east-1.amazonaws.com/user-service";
		System.out.println("Base URI given");
	}
/*  Request made to the server
{
  "username": "y4hjw0vdwn@lettershield.com",
  "email": "y4hjw0vdwn@lettershield.com",
  "firstName": "Yon",
  "lastName": "Rel",
  "userRoles": {
    "roleId": 1,
    "name": "ADMIN"
  },
  "password": "Abcd_1234",
  "phoneNumber": "+919182736450"
}

*/
	@When("Request is send to server to create user with username {string} firstname {string} lastname {string} roleId {int} roleName {string} password {string} phoneNumber {string}")
	public void request_is_send_to_server_to_create_user_with_username_firstname_lastname_role_id_role_name_password_phone_number(String string, String string2, String string3, Integer int1, String string4, String string5, String string6) {
		map5.put("username", string);
		map5.put("email",string);
		map5.put("firstName", string2);
		map5.put("lastName", string3);
		
		Map<String,Object> ur = new HashMap<String,Object>();//for user role
		ur.put("roleId", int1);
		ur.put("name",string4);
		
		map5.put("userRoles",ur);

		map5.put("password", string5);
		map5.put("phoneNumber", string6);
		
		JSONObject request = new JSONObject(map5);
		
		response = given().
				header("Content-Type","application/json").
				contentType(ContentType.JSON).
				accept(ContentType.JSON).body(request.toJSONString()).
			when().
				post("/api/v1/user");
	}

	@Then("User should get created")
	public void user_should_get_created() {
		response.
		then().
			log().all().
			assertThat().statusCode(200).
			header("Content-Type", "application/json");
	}

	//========================================================================================================================
	//========================================================================================================================
	//========================================================================================================================
	//========================================================================================================================

}
