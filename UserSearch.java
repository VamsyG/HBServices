package userService;

import static io.restassured.RestAssured.given;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserSearch {
	
	Response response;
	
	@Given("Righ baseURI given to get post")
	public void righ_base_uri_given_to_get_post() {
		RestAssured.baseURI="https://r99uw32s4a.execute-api.us-east-1.amazonaws.com/user-service";
		System.out.println("-------------------------");
		System.out.println("Base URI given");
		System.out.println("-------------------------");
	}

	@When("Request is sent to server with userId {string} page {string} size {string}")
	public void request_is_sent_to_server_with_user_id_page_size(String string, String string2, String string3) {
		response = 
				given().
					header("Content-Type","application/json").
					contentType(ContentType.JSON).
					accept(ContentType.JSON).
				when().
					get("/api/v1/user/search?page="+string2+"&size="+string3);
			System.out.println("-------------------------");
			System.out.println("Valid ID is passed");
			System.out.println("-------------------------");
	}

	@Then("User by user will obtain")
	public void user_by_user_will_obtain() {
		response.
		then().
			log().all().
			statusCode(200);
		System.out.println("-------------------------");
		System.out.println("Posts by that user should be successfully obtained");
		System.out.println("-------------------------");
	}

}
