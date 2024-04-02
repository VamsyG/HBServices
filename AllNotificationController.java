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

public class AllNotificationController {
	
	Response response;
	Map<String,Object> map = new HashMap<String,Object>();

	
	@Given("Valid base uri to get notification")
	public void valid_base_uri_to_get_notification() {
		RestAssured.baseURI="https://r99uw32s4a.execute-api.us-east-1.amazonaws.com/notification-service";
		System.out.println("Base URI given");
	}

	@When("I send request to server to get notification with id {string} page {string} size {string} type {string}")
	public void i_send_request_to_server_to_get_notification_with_id_page_size_type(String string, String string2, String string3, String string4) {
		response = given().
				header("Content-Type","application/json").
				contentType(ContentType.JSON).
				accept(ContentType.JSON).
			when().
				put("/api/v1/notification/"+string+"?page="+string2+"&size="+string3+"&type="+string4);
		System.out.println("-------------------------");
		System.out.println("Valid endpoint is passed");
		System.out.println("-------------------------");	
	}

	@Then("Notifications of that id should be fetched")
	public void notifications_of_that_id_should_be_fetched() {
		response.
		then().
			log().all().
			statusCode(200);
		System.out.println("-------------------------");
		System.out.println("Userpost with that ID should be updated");
		System.out.println("-------------------------");	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	@Given("Enter Valid base uri to edit notifications")
	public void enter_valid_base_uri_to_edit_notifications() {
		RestAssured.baseURI="https://r99uw32s4a.execute-api.us-east-1.amazonaws.com/notification-service";
		System.out.println("Base URI given");
	}

	@When("We send request to server to edit notifications with id {string} status {string}")
	public void we_send_request_to_server_to_edit_notifications_with_id_status(String string, String string2) {
		map.put("status",string2);
		JSONObject request = new JSONObject(map);

		response = given().
			header("Content-Type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).body(request.toJSONString()).
			when().
				put("api/v1/notification/"+string);
			//	then().statusCode(200).contentType(ContentType.JSON).extract().response();
			System.out.println("-------------------------");
			System.out.println("Valid endpoint is passed");
			System.out.println("-------------------------");	
	}

	@Then("Notifications with given id should be edited")
	public void notifications_with_given_id_should_be_edited() {
		response.
		then().
			log().all().
			statusCode(200);
		System.out.println("-------------------------");
		System.out.println("Notification with that ID should be updated");
		System.out.println("-------------------------");	
	}
	
	
	
	
	
	
	
	
	
	Map<String,Object> map2 = new HashMap<String,Object>();
	
	@Given("Enter Valid base uri to create notifications")
	public void enter_valid_base_uri_to_create_notifications() {
		RestAssured.baseURI="https://r99uw32s4a.execute-api.us-east-1.amazonaws.com/notification-service";
		System.out.println("Base URI given");
	}

	@When("We send request to server to create notifications with userId {string} message {string} title {string} type {string}")
	public void we_send_request_to_server_to_create_notifications_with_user_id_message_title_type(String string, String string2, String string3, String string4) {
		map2.put("userId",string);
		map2.put("message",string2);
		map2.put("title",string3);
		map2.put("type",string4);
		
		JSONObject request = new JSONObject(map2);

		response = given().
			header("Content-Type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).body(request.toJSONString()).
			when().
				post("api/v1/notification");
			//	then().statusCode(200).contentType(ContentType.JSON).extract().response();
			System.out.println("-------------------------");
			System.out.println("Valid endpoint is passed");
			System.out.println("-------------------------");	
	}

	@Then("Notifications with given id should be created")
	public void notifications_with_given_id_should_be_created() {
		response.
		then().
			log().all().
			statusCode(200);
		System.out.println("-------------------------");
		System.out.println("Notification with that ID should be created");
		System.out.println("-------------------------");	
	}
	
	
	
	
	
	
	
	
	@Given("Entering Valid base uri to get unread notifications")
	public void entering_valid_base_uri_to_get_unread_notifications() {
		RestAssured.baseURI="https://r99uw32s4a.execute-api.us-east-1.amazonaws.com/notification-service";
		System.out.println("Base URI given");
	}

	@When("We send request to te server to get unread notifications with userId {string}")
	public void we_send_request_to_te_server_to_get_unread_notifications_with_user_id(String string) {
		response = given().
				header("Content-Type","application/json").
				contentType(ContentType.JSON).
				accept(ContentType.JSON).
			when().
				get("/api/v1/notification/unread/"+string);
		System.out.println("-------------------------");
		System.out.println("Valid endpoint is passed");
		System.out.println("-------------------------");	
	}

	@Then("Unread notifications of that user should be obtained")
	public void unread_notifications_of_that_user_should_be_obtained() {
		response.
		then().
			log().all().
			statusCode(200);
		System.out.println("-------------------------");
		System.out.println("Unread notiffications with that ID should be updated");
		System.out.println("-------------------------");	
	}

	
}
