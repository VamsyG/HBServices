package docusignService;

import static io.restassured.RestAssured.given;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AllDocuSignController {
	
	Response response;
	
	@Given("Correct baseURI given to get signed URL")
	public void correct_base_uri_given_to_get_signed_url() {
		RestAssured.baseURI="https://r99uw32s4a.execute-api.us-east-1.amazonaws.com/docusign-service";
		System.out.println("-------------------------");
		System.out.println("Base URI given");
		System.out.println("-------------------------");
	}

	@When("Request is sent to server with email {string} userName {string} offeringId {string} userId {string}")
	public void request_is_sent_to_server_with_email_user_name_offering_id_user_id(String string, String string2, String string3, String string4){
		response = 
				given().
					header("Content-Type","application/json").
					contentType(ContentType.JSON).
					accept(ContentType.JSON).
				when().
					get("/api/v1/esign/getSignedUrl?email="+string+"&userName="+string2+"&offeringId="+string3+"&userId="+string4);
			System.out.println("-------------------------");
			System.out.println("Valid ID is passed");
			System.out.println("-------------------------");
	}

	@Then("Signed URL will obtain")
	public void signed_url_will_obtain() {
		response.
		then().
			log().all().
			statusCode(200);
		System.out.println("-------------------------");
		System.out.println("Offerings stats should be successfully obtained");
		System.out.println("-------------------------");
	}
	
	
	
	
	
	
	
	
	
	
	@Given("Correct baseURI given to get offering stats")
	public void correct_base_uri_given_to_get_offering_stats() {
		RestAssured.baseURI="https://r99uw32s4a.execute-api.us-east-1.amazonaws.com/docusign-service";
		System.out.println("-------------------------");
		System.out.println("Base URI given");
		System.out.println("-------------------------");	
	}

	@When("Request is sent to server valid")
	public void request_is_sent_to_server_valid() {
		response = 
				given().
					header("Content-Type","application/json").
					contentType(ContentType.JSON).
					accept(ContentType.JSON).
				when().
					get("/api/v1/esign/getFileFromS3");
			System.out.println("-------------------------");
			System.out.println("Valid ID is passed");
			System.out.println("-------------------------");
	}

	@Then("File will obtain")
	public void file_will_obtain() {
		response.
		then().
			log().all().
			statusCode(200);
		System.out.println("-------------------------");
		System.out.println("Offerings stats should be successfully obtained");
		System.out.println("-------------------------");
	}
	
	
	
	
	
	
	
	
	
	
	
	@Given("Correct baseURI given to get signed file")
	public void correct_base_uri_given_to_get_signed_file() {
		RestAssured.baseURI="https://r99uw32s4a.execute-api.us-east-1.amazonaws.com/docusign-service";
		System.out.println("-------------------------");
		System.out.println("Base URI given");
		System.out.println("-------------------------");
	}

	@When("Request is sent to server with state {string} event {string} offeringId {string} userId {string} envelopeId {string}")
	public void request_is_sent_to_server_with_state_event_offering_id_user_id_envelope_id(String string, String string2, String string3, String string4, String string5) {
		response = 
				given().
					header("Content-Type","application/json").
					contentType(ContentType.JSON).
					accept(ContentType.JSON).
				when().
					get("/api/v1/esign/checkDocumentIsSigned?state="+string+"&event="+string2+"&offeringId="+string3+"&userId="+string4+"&envelopeId="+string5);
			System.out.println("-------------------------");
			System.out.println("Valid ID is passed");
			System.out.println("-------------------------");
	}

	@Then("Signed file will obtain")
	public void signed_file_will_obtain() {
		response.
		then().
			log().all().
			statusCode(200);
		System.out.println("-------------------------");
		System.out.println("Offerings stats should be successfully obtained");
		System.out.println("-------------------------");
	}

}
