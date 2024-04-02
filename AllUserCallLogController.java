package notificationService;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AllUserCallLogController {
	
	Response response;
	Map<String,Object> map = new HashMap<String,Object>();
	
	@Given("Valid baseURI for editing call logs")
	public void valid_base_uri_for_editing_call_logs() {
		RestAssured.baseURI="https://r99uw32s4a.execute-api.us-east-1.amazonaws.com/notification-service";
		System.out.println("Base URI given");
	}

	
	@When("Request is sent to server for editing call logs with id {string} fullName {string} title {string} note {string} loggedById {string}")
	public void request_is_sent_to_server_for_editing_call_logs_with_id_full_name_title_note_logged_by_id(String string, String string2, String string3, String string4, String string5) {
		map.put("fullName",string2);
		map.put("title",string3);
		map.put("note",string4);
		map.put("loggedById",string5);
		
		JSONObject request = new JSONObject(map);

		response = given().
			header("Content-Type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).body(request.toJSONString()).
			when().
				put("api/v1/calllog/"+string);
			//	then().statusCode(200).contentType(ContentType.JSON).extract().response();
			System.out.println("-------------------------");
			System.out.println("Valid endpoint is passed");
			System.out.println("-------------------------");	
	}

	@Then("Call logs should be successfully edited")
	public void call_logs_should_be_successfully_edited() {
		response.
		then().
			log().all().
			statusCode(200);
		System.out.println("-------------------------");
		System.out.println("Calllog with that ID should be edited");
		System.out.println("-------------------------");	
	}
	
	
	
	
	
	
	
	@Given("Valid baseURI for getting call logs")
	public void valid_base_uri_for_getting_call_logs() {
		RestAssured.baseURI="https://r99uw32s4a.execute-api.us-east-1.amazonaws.com/notification-service";
		System.out.println("Base URI given");
	}

	@When("Request is sent to server for Getting call logs with loggedById {string} keyword {string} page {string} size {string}")
	public void request_is_sent_to_server_for_getting_call_logs_with_logged_by_id_keyword_page_size(String string, String string2, String string3, String string4) {
		response = given().
				header("Content-Type","application/json").
				contentType(ContentType.JSON).
				accept(ContentType.JSON).
			when().
				get("/api/v1/calllog?loggedById="+string+"&keyword="+string2+"&page="+string3+"&size="+string4);
		System.out.println("-------------------------");
		System.out.println("Valid endpoint is passed");
		System.out.println("-------------------------");	
	}

	@Then("Call logs should be successfully obtained")
	public void call_logs_should_be_successfully_obtained() {
		response.
		then().
			log().all().
			statusCode(200);
		System.out.println("-------------------------");
		System.out.println("Userpost with that ID should be updated");
		System.out.println("-------------------------");	
	}
	
	
	
	
	
	
	
	
	
	
	Map<String,Object> map2 = new HashMap<String,Object>();
	
	@Given("Valid baseURI for posting call log")
	public void valid_base_uri_for_posting_call_log() {
		RestAssured.baseURI="https://r99uw32s4a.execute-api.us-east-1.amazonaws.com/notification-service";
		System.out.println("Base URI given");
	}

	@When("Request is sent to server to post call log with title {string} email {string} fullName {string} phonenumber {string} note {string} loggedbyId {string}")
	public void request_is_sent_to_server_to_post_call_log_with_title_email_full_name_phonenumber_note_loggedby_id(String string, String string2, String string3, String string4, String string5, String string6) {
		map2.put("title",string);
		map2.put("email",string2);
		map2.put("fullName",string3);
		map2.put("phoneNumber",string4);
		map2.put("note",string5);
		map2.put("loggedById",string6);
		
		JSONObject request = new JSONObject(map2);

		response = given().
			header("Content-Type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).body(request.toJSONString()).
			when().
				post("api/v1/calllog");
			//	then().statusCode(200).contentType(ContentType.JSON).extract().response();
			System.out.println("-------------------------");
			System.out.println("Valid endpoint is passed");
			System.out.println("-------------------------");	
			System.out.println(response.getSessionId());
	}

	@Then("Call log should be successfully posted")
	public void call_log_should_be_successfully_posted() {
		response.
		then().
			log().all().
			statusCode(200);
		System.out.println("-------------------------");
		System.out.println("Calllog should be created");
		System.out.println("-------------------------");	
	}
	
	

}
