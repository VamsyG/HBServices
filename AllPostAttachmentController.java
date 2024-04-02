package notificationService;

import static io.restassured.RestAssured.given;

import java.io.File;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AllPostAttachmentController {
	
	
	Response response;
	
	@Given("Valid baseURI for user post attachment")
	public void valid_base_uri_for_user_post_attachment() {
		RestAssured.baseURI="https://r99uw32s4a.execute-api.us-east-1.amazonaws.com/notification-service";
		System.out.println("Base URI given");
	}

	@When("Request is sent to server for post attachment for postId {string} with key {string} filepath {string}")
	public void request_is_sent_to_server_for_post_attachment_for_post_id_with_key_filepath(String string, String string2, String string3) {
		File imageFile = new File(string3);
		
		response = 
				RestAssured.
				given().
				    header("Content-Type", "multipart/form-data").
//					contentType(ContentType.JSON).
//					accept(ContentType.JSON).
					multiPart(string2, imageFile, "image/jpeg").
				when().
					post("/api/v1/postAttachment/"+string+"/post");
			System.out.println("Valid endpoint is passed");
	}

	@Then("User post attachment should be successfully posted")
	public void user_post_attachment_should_be_successfully_posted() {
		response.
		then().
			log().all().
			statusCode(200);
		System.out.println("-------------------------");
		System.out.println("Attachment for that postID is attached");
		System.out.println("-------------------------");
	}
	
	
	
	
	
	
	
	
	
	
	@Given("Enter Valid base uri to Delete post attachment")
	public void enter_valid_base_uri_to_delete_post_attachment() {
		RestAssured.baseURI="https://r99uw32s4a.execute-api.us-east-1.amazonaws.com/notification-service";
		System.out.println("Base URI given");
	}

	@When("We send request to server to Delete post attachment with Id {string}")
	public void we_send_request_to_server_to_delete_post_attachment_with_id(String string) {
		response = given().
				header("Content-Type","application/json").
				contentType(ContentType.JSON).
				accept(ContentType.JSON).
			when().
				delete("/api/v1/postAttachment/"+string);
		System.out.println("-------------------------");
		System.out.println("Valid URL is passed");
		System.out.println("-------------------------");	
	}

	@Then("Attachment with given post id should be deleted")
	public void attachment_with_given_post_id_should_be_deleted() {
		response.
		then().
			log().all().
			statusCode(200);
		System.out.println("-------------------------");
		System.out.println("Post attachment with that ID should be deleted");
		System.out.println("-------------------------");	
	}

}
