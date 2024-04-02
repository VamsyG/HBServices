package userService;

import static io.restassured.RestAssured.given;
import org.hamcrest.Matchers;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AllPlacementAgentController {
	
	Response response;
	
	@Given("I want to write valid base URI to get user")
	public void i_want_to_write_valid_base_uri_to_get_user() {
		RestAssured.baseURI="https://r99uw32s4a.execute-api.us-east-1.amazonaws.com/user-service";
		System.out.println("-------------------------");
		System.out.println("Base URI given");
		System.out.println("-------------------------");
	}

	@When("Request is sent to server")
	public void request_is_sent_to_server() {
		response = given().
				header("Content-Type","application/json").
				contentType(ContentType.JSON).
				accept(ContentType.JSON).
			when().
				get("/api/v1/user/placement-agent/request");
		System.out.println("-------------------------");
		System.out.println("Valid endpoint is passed");
		System.out.println("-------------------------");
	    
	}

	@Then("Placement agent approvals should display")
	public void placement_agent_approvals_should_display() {
		response.
		then().
			log().all().
		assertThat().
			statusCode(200).
			header("Content-Type", "application/json");
		System.out.println("-------------------------");
		System.out.println("Placement agent approvals should display");
		System.out.println("-------------------------");
	}
	
	@When("Request sent to server is invalid")
	public void request_sent_to_server_is_invalid() {
		response = given().
				header("Content-Type","application/json").
				contentType(ContentType.JSON).
				accept(ContentType.JSON).
			when().
				get("/api/v1/user/placement-agent/reques");
		System.out.println("-------------------------");
		System.out.println("Invalid endpoint is passed");
		System.out.println("-------------------------");
	}

	@Then("Placement agent approvals should not display")
	public void placement_agent_approvals_should_not_display() {
		response.
		then().
			log().all().
		assertThat().
			statusCode(404).
			header("Content-Type", "application/json");
		System.out.println("-------------------------");
		System.out.println("Placement agent approvals are not displayed");
		System.out.println("-------------------------");
	}

	
//==============================================================================================================================

	@Given("Entere valid base URI to get user")
	public void entere_valid_base_uri_to_get_user() {
		RestAssured.baseURI="https://r99uw32s4a.execute-api.us-east-1.amazonaws.com/user-service";
		System.out.println("-------------------------");
		System.out.println("Base URI given");
		System.out.println("-------------------------");	
	}

	@When("Request is sentto server with validid {int}")
	public void request_is_sentto_server_with_validid(Integer int1) {
		response = given().
				header("Content-Type","application/json").
				contentType(ContentType.JSON).
				accept(ContentType.JSON).
			when().
				post("/api/v1/user/placement-agent/request?id="+int1+"&placementAgentStatus=APPROVE");
		System.out.println("-------------------------");
		System.out.println("Valid endpoint is passed");
		System.out.println("-------------------------");	

	}
	
	@Then("Placement agent approvals should get posted")
	public void placement_agent_approvals_should_get_posted() {
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
	
	@When("Request is sentto server with invalid id {int}")
	public void request_is_sentto_server_with_invalid_id(Integer int1) {
		response = given().
				header("Content-Type","application/json").
				contentType(ContentType.JSON).
				accept(ContentType.JSON).
			when().
				post("/api/v1/user/placement-agent/request?id="+int1+"&placementAgentStatus=APPROVE");
		System.out.println("-------------------------");
		System.out.println("Valid endpoint is passed");
		System.out.println("-------------------------");	
	}


	@Then("Placement agent approvals should not get posted")
	public void placement_agent_approvals_should_not_get_posted() {
		response.
		then().
			log().all().
		assertThat().
			statusCode(400);
		
		System.out.println("-------------------------");
		System.out.println("Placement agent should posted");
		System.out.println("-------------------------");
	}

	
//==============================================================================================================================
	
	@Given("Entr valid base URI to get user")
	public void entr_valid_base_uri_to_get_user() {
		RestAssured.baseURI="https://r99uw32s4a.execute-api.us-east-1.amazonaws.com/user-service";
		System.out.println("-------------------------");
		System.out.println("Base URI given");
		System.out.println("-------------------------");	
	}

	@When("Request is to server")
	public void request_is_to_server() {
		response = given().
				header("Content-Type","application/json").
				contentType(ContentType.JSON).
				accept(ContentType.JSON).
			when().
				get("/api/v1/user/placement-agent/request/paginated?page=0&size=10");
		System.out.println("-------------------------");
		System.out.println("Valid endpoint is passed");
		System.out.println("-------------------------");	
	}

	@Then("Paginated placement agent approvals should display")
	public void paginated_placement_agent_approvals_should_display() {
		response.
		then().
			log().all().
		assertThat().
			statusCode(200).
			header("Content-Type", "application/json");
		System.out.println("-------------------------");
		System.out.println("Placement agent approvals should display");
		System.out.println("-------------------------");
	}
	
	@When("Request is given without size")
	public void request_is_given_without_size() {
		response = given().
				header("Content-Type","application/json").
				contentType(ContentType.JSON).
				accept(ContentType.JSON).
			when().
				get("/api/v1/user/placement-agent/request/paginated");
		System.out.println("-------------------------");
		System.out.println("Valid endpoint without size is passed");
		System.out.println("-------------------------");		
	}

	@Then("Default paginated approvals should display")
	public void default_paginated_approvals_should_display() {
		response.
		then().
			log().all().
		assertThat().
			statusCode(200).
			header("Content-Type", "application/json");
		System.out.println("-------------------------");
		System.out.println("Placement agent approvals are displayed with default pagination");
		System.out.println("-------------------------");
	}

	
	
}
