package sharepointService;

import static io.restassured.RestAssured.given;

import java.io.File;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AllSharepointController {
	
	Response response;
	
	@Given("Giving baseURI given to get welcome")
	public void giving_base_uri_given_to_get_welcome() {
		RestAssured.baseURI="https://r99uw32s4a.execute-api.us-east-1.amazonaws.com/sharepoint-service";
		System.out.println("-------------------------");
		System.out.println("Base URI given");
		System.out.println("-------------------------");
	}

	@When("Request is sent to server to welcome")
	public void request_is_sent_to_server_to_welcome() {
		response = 
				given().
					header("Content-Type","application/json").
					contentType(ContentType.JSON).
					accept(ContentType.JSON).
				when().
					get("/api/v1/sharepoint/welcome");
			System.out.println("-------------------------");
			System.out.println("Valid URL is passed");
			System.out.println("-------------------------");
	}

	@Then("Welcome sharepoint will obtain")
	public void welcome_sharepoint_will_obtain() {
		response.
		then().
			log().all().
			statusCode(200);
		System.out.println("-------------------------");
		System.out.println("Welcome message should be successfully obtained");
		System.out.println("-------------------------");	
	}
	
	
	
	
	
	
	
	
	
	@Given("Giving basURI given to get documents")
	public void giving_bas_uri_given_to_get_documents() {
		RestAssured.baseURI="https://r99uw32s4a.execute-api.us-east-1.amazonaws.com/sharepoint-service";
		System.out.println("-------------------------");
		System.out.println("Base URI given");
		System.out.println("-------------------------");
	}
	
	@When("Request is sent to server with item ID {string}")
	public void request_is_sent_to_server_with_item_id(String string) {
		response = 
				given().
					header("Content-Type","application/json").
					contentType(ContentType.JSON).
					accept(ContentType.JSON).
				when().
					get("/api/v1/sharepoint/getDocumentsByItemId/"+string);
			System.out.println("-------------------------");
			System.out.println("Valid URL is passed");
			System.out.println("-------------------------");	
	}

	@Then("documents of that item id will obtain")
	public void documents_of_that_item_id_will_obtain() {
		response.
		then().
			log().all().
			statusCode(200);
		System.out.println("-------------------------");
		System.out.println("Welcome message should be successfully obtained");
		System.out.println("-------------------------");	
	}
	
	
	
	
	
	
	
	
	
	@Given("Giving basURI given to get document")
	public void giving_bas_uri_given_to_get_document() {
		RestAssured.baseURI="https://r99uw32s4a.execute-api.us-east-1.amazonaws.com/sharepoint-service";
		System.out.println("-------------------------");
		System.out.println("Base URI given");
		System.out.println("-------------------------");
	}

	@When("Request is sent to a server to get document with itemID {string} userName {string} entityName {string}")
	public void request_is_sent_to_a_server_to_get_document_with_item_id_user_name_entity_name(String string, String string2, String string3) {
		response = 
				given().
					header("Content-Type","application/json").
					contentType(ContentType.JSON).
					accept(ContentType.JSON).
				when().
					get("/api/v1/sharepoint/getDocument?itemId="+string+"&userName="+string2+"&entityName="+string3);
			System.out.println("-------------------------");
			System.out.println("Valid URL is passed");
			System.out.println("-------------------------");
	}

	@Then("Document will obtain")
	public void document_will_obtain() {
		response.
		then().
			log().all().
			statusCode(200);
		System.out.println("-------------------------");
		System.out.println("All documents should be successfully obtained");
		System.out.println("-------------------------");
	}
	
	
	
	
	
	
	
	
	
	
	
	@Given("Giving basURI given to get documentss")
	public void giving_bas_uri_given_to_get_documentss() {
		RestAssured.baseURI="https://r99uw32s4a.execute-api.us-east-1.amazonaws.com/sharepoint-service";
		System.out.println("-------------------------");
		System.out.println("Base URI given");
		System.out.println("-------------------------");
	}

	@When("Request is sent to a server with item ID {string}")
	public void request_is_sent_to_a_server_with_item_id(String string) {
		response = 
				given().
					header("Content-Type","application/json").
					contentType(ContentType.JSON).
					accept(ContentType.JSON).
				when().
					get("/api/v1/sharepoint/getAllDocuments?itemid="+string);
			System.out.println("-------------------------");
			System.out.println("Valid URL is passed");
			System.out.println("-------------------------");	
	}

	@Then("All documents of that item id will obtain")
	public void all_documents_of_that_item_id_will_obtain() {
		response.
		then().
			log().all().
			statusCode(200);
		System.out.println("-------------------------");
		System.out.println("All documents should be successfully obtained");
		System.out.println("-------------------------");
	}
	
	
	
	
	
	
	
	
	
	
	@Given("Giving basURI given to download document")
	public void giving_bas_uri_given_to_download_document() {
		RestAssured.baseURI="https://r99uw32s4a.execute-api.us-east-1.amazonaws.com/sharepoint-service";
		System.out.println("-------------------------");
		System.out.println("Base URI given");
		System.out.println("-------------------------");
	}

	@When("Request is sent to a server to download document with itemID {string} userName {string} entityName {string}")
	public void request_is_sent_to_a_server_to_download_document_with_item_id_user_name_entity_name(String string, String string2, String string3) {
		response = 
				given().
					header("Content-Type","application/json").
					contentType(ContentType.JSON).
					accept(ContentType.JSON).
				when().
					get("/api/v1/sharepoint/download/document?itemId="+string+"&userName="+string2+"&entityName="+string3);
			System.out.println("-------------------------");
			System.out.println("Valid URL is passed");
			System.out.println("-------------------------");
	}

	@Then("Document will be downloaded")
	public void document_will_be_downloaded() {
		response.
		then().
			log().all().
			statusCode(200);
		System.out.println("-------------------------");
		System.out.println("All documents should be successfully obtained");
		System.out.println("-------------------------");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Given("Giving basURI given to delete document")
	public void giving_bas_uri_given_to_delete_document() {
		RestAssured.baseURI="https://r99uw32s4a.execute-api.us-east-1.amazonaws.com/sharepoint-service";
		System.out.println("-------------------------");
		System.out.println("Base URI given");
		System.out.println("-------------------------");
	}

	@When("Request is sent to a server to get property with itemId {string}")
	public void request_is_sent_to_a_server_to_get_property_with_item_id(String string) {
		response = 
				given().
					header("Content-Type","application/json").
					contentType(ContentType.JSON).
					accept(ContentType.JSON).
				when().
					delete("/api/v1/sharepoint/delete/document?itemId="+string);
			System.out.println("-------------------------");
			System.out.println("Valid URL is passed");
			System.out.println("-------------------------");
	}

	@Then("Document should be deleted")
	public void document_should_be_deleted() {
		response.
		then().
			log().all().
			statusCode(200);
		System.out.println("-------------------------");
		System.out.println("Property Document should be deleted successfully");
		System.out.println("-------------------------");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Given("Giving basURI given to Promote deal by dealID")
	public void giving_bas_uri_given_to_promote_deal_by_deal_id() {
		RestAssured.baseURI="https://r99uw32s4a.execute-api.us-east-1.amazonaws.com/offering-service";
		System.out.println("-------------------------");
		System.out.println("Base URI given");
		System.out.println("-------------------------");
	}

	@When("Request is sent to a server to Promote deal by dealID {string}")
	public void request_is_sent_to_a_server_to_promote_deal_by_deal_id(String string) {
		response = 
				given().
					header("Content-Type","application/json").
					contentType(ContentType.JSON).
					accept(ContentType.JSON).
				when().
					post("/api/v1/sharepoint/promoteDeal/"+string);
			System.out.println("-------------------------");
			System.out.println("Valid URL is passed");
			System.out.println("-------------------------");
	}

	@Then("Deal with that ID will be promoted")
	public void deal_with_that_id_will_be_promoted() {
		response.
		then().
			log().all().
			statusCode(200);
		System.out.println("-------------------------");
		System.out.println("Deal should be successfully promoted");
		System.out.println("-------------------------");	
	}
	
	
	
	
	
	
	
	
	
	@Given("Giving basURI given to uploading doc by itemID")
	public void giving_bas_uri_given_to_uploading_doc_by_item_id() {
		RestAssured.baseURI="https://r99uw32s4a.execute-api.us-east-1.amazonaws.com/sharepoint-service";
		System.out.println("-------------------------");
		System.out.println("Base URI given");
		System.out.println("-------------------------");
	}

	@When("Request is sent to a server to uploading doc by itemID {string} and key {string} filepath {string}")
	public void request_is_sent_to_a_server_to_uploading_doc_by_item_id_and_key_filepath(String string, String string2, String string3) {
		
		File imageFile = new File(string3);
		
		response = 
				RestAssured.
				given().
				    header("Content-Type", "multipart/form-data").
//					contentType(ContentType.JSON).
//					accept(ContentType.JSON).
					multiPart(string2, imageFile, "image/jpeg").
				when().
					post("/api/v1/sharepoint/upload/document?itemId="+string);
			System.out.println("Valid endpoint is passed");
	}

	@Then("Document will get upload fro deal")
	public void document_will_get_upload_fro_deal() {
		response.
		then().
			log().all().
			statusCode(200);
		System.out.println("-------------------------");
		System.out.println("Document should be successfully uploaded");
		System.out.println("-------------------------");	
	}
	
	
	

}
