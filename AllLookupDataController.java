package userService;

import static io.restassured.RestAssured.given;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AllLookupDataController {

	Response response;
	
//========================================================================================================================

	
	@Given("The valid baseURI to get user")
	public void the_valid_base_uri_to_get_user() {
		RestAssured.baseURI="https://r99uw32s4a.execute-api.us-east-1.amazonaws.com/user-service";
		System.out.println("-------------------------");
		System.out.println("Base URI given");
		System.out.println("-------------------------");	
	}

	@When("request is sent to the server")
	public void request_is_sent_to_the_server() {
		response = given().
				header("Content-Type","application/json").
				contentType(ContentType.JSON).
				accept(ContentType.JSON).
			when().
				get("/api/v1/user/lookup-data/financialSuitability");
		System.out.println("-------------------------");
		System.out.println("Valid endpoint is passed");
		System.out.println("-------------------------");	
		//then().contentType(ContentType.JSON).extract().response();
	}
	

	@Then("Financial Suitability fields should be obtained")
	public void financial_suitability_fields_should_be_obtained() {
		response.
		then().
			log().all().
		assertThat().
			statusCode(200).
			header("Content-Type", "application/json");
		System.out.println("-------------------------");
		System.out.println("Financial Suitability fields should be obtained");
		System.out.println("-------------------------");
	}
	
	@When("Inavalid request sent to servr")
	public void inavalid_request_sent_to_servr() {
		response = given().
				header("Content-Type","application/json").
				contentType(ContentType.JSON).
				accept(ContentType.JSON).
			when().
				get("/api/v1/user/lookup-data/financialSuitabilit");
		System.out.println("-------------------------");
		System.out.println("Invalid endpoint is passed");
		System.out.println("-------------------------");	


	}

	@Then("Financial Suitability fields should not be obtained")
	public void financial_suitability_fields_should_not_be_obtained() {
		response.
		then().
			log().all().
		assertThat().
			statusCode(404).
			header("Content-Type", "application/json");
		System.out.println("-------------------------");
		System.out.println("Financial Suitability fields should not be obtained");
		System.out.println("-------------------------");

	}

	
//========================================================================================================================
	
	
	@Given("The valid baseUrl to get user")
	public void the_valid_base_url_to_get_user() {
		RestAssured.baseURI="https://r99uw32s4a.execute-api.us-east-1.amazonaws.com/user-service";
		System.out.println("-------------------------");
		System.out.println("Base URI given");
		System.out.println("-------------------------");	
	}

	@When("request is sent to server")
	public void request_is_sent_to_server() {
		
		response = given().
				header("Content-Type","application/json").
				contentType(ContentType.JSON).
				accept(ContentType.JSON).
			when().
				get("/api/v1/user/lookup-data/countriesAndStates");
		System.out.println("-------------------------");
		System.out.println("Valid endpoint is passed");
		System.out.println("-------------------------");	
		
			//then().contentType(ContentType.JSON).extract().response();		
	}

	@Then("Countries and States fields should be obtained with status code {int}")
	public void countries_and_states_fields_should_be_obtained_with_status_code(Integer int1) {
		response.
		then().
			log().all().
		assertThat().
			statusCode(200).
			header("Content-Type", "application/json");
		System.out.println("-------------------------");
		System.out.println("Countries and States should be obtained");
		System.out.println("-------------------------");  
	}
	
	@When("request is sent to server with invuri")
	public void request_is_sent_to_server_with_invuri() {
		
		response = given().
				header("Content-Type","application/json").
				contentType(ContentType.JSON).
				accept(ContentType.JSON).
			when().
				get("/api/v1/user/lookup-data/countriesAndState");
		System.out.println("-------------------------");
		System.out.println("Invalid endpoint is passed");
		System.out.println("-------------------------");	
	}

	@Then("Countries and States fields shouldnot be obtained")
	public void countries_and_states_fields_shouldnot_be_obtained() {
		response.
		then().
			log().all().
		assertThat().
			statusCode(404).
			header("Content-Type", "application/json");
		System.out.println("-------------------------");
		System.out.println("Countries and States should not be obtained");
		System.out.println("-------------------------");
	}


}
