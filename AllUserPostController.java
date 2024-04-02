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

public class AllUserPostController {
	
	Response response;
	
	Map<String,Object> map = new HashMap<String,Object>();
	
	@Given("Giving basURI given to Update userpost by ID")
	public void giving_bas_uri_given_to_update_userpost_by_id() {
		RestAssured.baseURI="https://r99uw32s4a.execute-api.us-east-1.amazonaws.com/notification-service";
		System.out.println("-------------------------");
		System.out.println("Base URI given");
		System.out.println("-------------------------");
	}

	@When("Request is sent to a server to Update userpost by ID {string} postedById {string} postedToId {string} post {string}")
	public void request_is_sent_to_a_server_to_update_userpost_by_id_posted_by_id_posted_to_id_post(String string, String string2, String string3, String string4) {
		
		map.put("id", string);
		map.put("postedById", string2);
		map.put("postedToId", string3);
		map.put("post", string4);
		
		JSONObject request = new JSONObject(map);

		response = given().
			header("Content-Type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
			when().
				put("/api/v1/userpost/"+string);
			//	then().statusCode(200).contentType(ContentType.JSON).extract().response();
			System.out.println("-------------------------");
			System.out.println("Valid endpoint is passed");
			System.out.println("-------------------------");	
	}

	@Then("Userpost with that ID should be updated")
	public void userpost_with_that_id_should_be_updated() {
		response.
		then().
			log().all().
			statusCode(200);
		System.out.println("-------------------------");
		System.out.println("Userpost with that ID should be updated");
		System.out.println("-------------------------");	
	}
	

	
	@Given("Valid baseURI for user post")
	public void valid_base_uri_for_user_post() {
		RestAssured.baseURI="https://r99uw32s4a.execute-api.us-east-1.amazonaws.com/notification-service";
		System.out.println("-------------------------");
		System.out.println("Base URI given");
		System.out.println("-------------------------");
	}

	@When("Request is sent to server for key {string} filepath {string} for key {string} filepath {string}")
	public void request_is_sent_to_server_for_key_filepath_for_key_filepath(String string, String string2, String string3, String string4) {		
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
					post("/api/v1/userpost");
			System.out.println("Valid endpoint is passed");
	}

	@Then("User post should be successfully posted")
	public void user_post_should_be_successfully_posted() {
		response.
		then().
			log().all().
			statusCode(200);
		System.out.println("-------------------------");
		System.out.println("Post from that ID is posted");
		System.out.println("-------------------------");
	}
	
	
	
	
	@Given("Rigth baseURI given to get post by Id")
	public void rigth_base_uri_given_to_get_post_by_id() {
		RestAssured.baseURI="https://r99uw32s4a.execute-api.us-east-1.amazonaws.com/notification-service";
		System.out.println("-------------------------");
		System.out.println("Base URI given");
		System.out.println("-------------------------");
	}
	
	@When("Request is sent to server to get post with userId {int}")
	public void request_is_sent_to_server_to_get_post_with_user_id(Integer int1) {
		response = 
				given().
					header("Content-Type","application/json").
					contentType(ContentType.JSON).
					accept(ContentType.JSON).
				when().
					get("/api/v1/userpost/getPostsByUserId/"+int1);
			System.out.println("-------------------------");
			System.out.println("Valid ID is passed");
			System.out.println("-------------------------");
	}

	@Then("Posts made by user will obtain")
	public void posts_made_by_user_will_obtain() {
		response.
		then().
			log().all().
			statusCode(200);
		System.out.println("-------------------------");
		System.out.println("Posts by that user should be successfully obtained");
		System.out.println("-------------------------");
	}
	
}
