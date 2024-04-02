package notificationService;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AllCommentController {
	
	
	Response response;
	
	Map<String,Object> map = new HashMap<String,Object>();
	
	@Given("Giving basURI given to Update user comment by ID")
	public void giving_bas_uri_given_to_update_user_comment_by_id() {
		RestAssured.baseURI="https://r99uw32s4a.execute-api.us-east-1.amazonaws.com/notification-service";
		System.out.println("-------------------------");
		System.out.println("Base URI given");
		System.out.println("-------------------------");
	}

	@When("Request is sent to a server to Update user comment by ID {string} commentedById {string} post {string} comment {string}")
	public void request_is_sent_to_a_server_to_update_user_comment_by_id_commented_by_id_post_comment(String string, String string2, String string3, String string4) {
		map.put("id", string);
		map.put("commentedById", string2);
		map.put("post", string3);
		map.put("comment", string4);
		
		JSONObject request = new JSONObject(map);

		response = given().
			header("Content-Type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
			when().
				put("/api/v1/comment/"+string);
			//	then().statusCode(200).contentType(ContentType.JSON).extract().response();
			System.out.println("-------------------------");
			System.out.println("Valid endpoint is passed");
			System.out.println("-------------------------");	
	}

	@Then("user comment with that ID should be updated")
	public void user_comment_with_that_id_should_be_updated() {
		response.
		then().
			log().all().
			statusCode(200);
		System.out.println("-------------------------");
		System.out.println("User comment with that ID should be updated");
		System.out.println("-------------------------");	
	}
	
	
	
	
	
	
	
	
	@Given("Valid baseURI for user comment")
	public void valid_base_uri_for_user_comment() {
		RestAssured.baseURI="https://r99uw32s4a.execute-api.us-east-1.amazonaws.com/notification-service";
		System.out.println("Base URI given");
	}

	@When("Request is sent to server for comment with key {string} filepath {string} for key {string} filepath {string}")
	public void request_is_sent_to_server_for_comment_with_key_filepath_for_key_filepath(String string, String string2, String string3, String string4) {
		File imageFile = new File(string2);
		File jsonFile = new File(string4);

		response = 
				RestAssured.
				given().
				    header("Content-Type", "multipart/form-data").
//					contentType(ContentType.JSON).
//					accept(ContentType.JSON).
					multiPart(string, imageFile, "image/jpeg").
					multiPart(string3, jsonFile, "application/json").
				when().
					post("/api/v1/comment");
			System.out.println("Valid endpoint is passed");
		}

	@Then("User comment should be successfully posted")
	public void user_comment_should_be_successfully_posted() {
		response.
		then().
			log().all().
			statusCode(200);
		System.out.println("-------------------------");
		System.out.println("Comment from user with that ID is sent");
		System.out.println("-------------------------");
	}



}
