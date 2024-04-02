package userService;

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

public class AllUserRiskProfileController {
	
	Response response;
	
	@Given("The valid basUrl to  get risk profile")
	public void the_valid_bas_url_to_get_risk_profile() {
		RestAssured.baseURI="https://r99uw32s4a.execute-api.us-east-1.amazonaws.com/user-service";
		System.out.println("-------------------------");
		System.out.println("Base URI given");
		System.out.println("-------------------------");	
	}

	@When("request is sent to the server for user risk profile with valid id {int}")
	public void request_is_sent_to_the_server_for_user_risk_profile_with_valid_id(Integer int1) {
		response = given().
				header("Content-Type","application/json").
				contentType(ContentType.JSON).
				accept(ContentType.JSON).
			when().
				get("/api/v1/user-risk-profile/"+int1);
		System.out.println("-------------------------");
		System.out.println("Valid endpoint is passed");
		System.out.println("-------------------------");		
	}

	@Then("User risk profile should be obtained")
	public void user_risk_profile_should_be_obtained() {
		response.
		then().
			log().all().
		assertThat().
			statusCode(200).
			header("Content-Type", "application/json");
		System.out.println("-------------------------");
		System.out.println("User Risk profile should be obtained");
		System.out.println("-------------------------");
	}
	
	@When("request is sent to the server for user risk profile with invalid id {int}")
	public void request_is_sent_to_the_server_for_user_risk_profile_with_invalid_id(Integer int1) {
		response = given().
				header("Content-Type","application/json").
				contentType(ContentType.JSON).
				accept(ContentType.JSON).
			when().
				get("/api/v1/user-risk-profile/"+int1);
		System.out.println("-------------------------");
		System.out.println("Invalid ID is passed");
		System.out.println("-------------------------");	
	}

	@Then("User risk profile should not be obtained")
	public void user_risk_profile_should_not_be_obtained() {
		response.
		then().
			log().all().
		assertThat().
			statusCode(404).
			header("Content-Type", "application/json");
		System.out.println("-------------------------");
		System.out.println("User Risk profile should not be obtained");
		System.out.println("-------------------------");
	}
	
// =============================================================================================================================
		
	Map<String,Object> map = new HashMap<String,Object>();

	
	@Given("The valid basUrl to put risk profile")
	public void the_valid_bas_url_to_put_risk_profile() {
		RestAssured.baseURI="https://r99uw32s4a.execute-api.us-east-1.amazonaws.com/user-service";
		System.out.println("-------------------------");
		System.out.println("Base URI given");
		System.out.println("-------------------------");	
	}

	@When("request is sent to the server for updating user risk profile with valid id {int}")
	public void request_is_sent_to_the_server_for_updating_user_risk_profile_with_valid_id(Integer int1) {
		map.put("investorTypeEnum","ACCREDITED_INVESTOR");//
		JSONObject request = new JSONObject(map);
		response = given().
				header("Content-Type","application/json").
				contentType(ContentType.JSON).
				accept(ContentType.JSON).body(request.toJSONString()).
			when().
				put("/api/v1/user-risk-profile/"+int1);
		System.out.println("-------------------------");
		System.out.println("Request with valid ID is passed");
		System.out.println("-------------------------");	
//			then().contentType(ContentType.JSON).extract().response();
	}
	

	@Then("User risk profile should be updated")
	public void user_risk_profile_should_be_updated() {
		response.then().
		log().all().
     	assertThat().
		statusCode(200).
		header("Content-Type", "application/json");
		System.out.println("-------------------------");
		System.out.println("User risk profile should be updated");
		System.out.println("-------------------------");
	}
	
	@When("request is sent to the server to update user risk profile with invalid id {int}")
	public void request_is_sent_to_the_server_to_update_user_risk_profile_with_invalid_id(Integer int1) {
		response = given().
				header("Content-Type","application/json").
				contentType(ContentType.JSON).
				accept(ContentType.JSON).
			when().
				put("/api/v1/user-risk-profile/"+int1);
		System.out.println("-------------------------");
		System.out.println("Request with invalid ID is passed");
		System.out.println("-------------------------");	
	}

	@Then("User risk profile shouldnt get updated")
	public void user_risk_profile_shouldnt_get_updated() {
		response.then().
		log().all().
     	assertThat().
		statusCode(400).
		header("Content-Type", "application/json");
		System.out.println("-------------------------");
		System.out.println("User risk profile should not be updated");
		System.out.println("-------------------------");
	}
	
	@When("request is sent to the server to update user risk profile without body")
	public void request_is_sent_to_the_server_to_update_user_risk_profile_without_body() {
		response = given().
				header("Content-Type","application/json").
				contentType(ContentType.JSON).
				accept(ContentType.JSON).
			when().
				put("/api/v1/user-risk-profile/113");
		System.out.println("-------------------------");
		System.out.println("Request without body is passed");
		System.out.println("-------------------------");		
	}

	@Then("User risk profile should not be updated")
	public void user_risk_profile_should_not_be_updated() {
		response.then().
		log().all().
     	assertThat().
		statusCode(400).
		header("Content-Type", "application/json");
		System.out.println("-------------------------");
		System.out.println("User risk profile should not be updated");
		System.out.println("-------------------------");
	}

// =============================================================================================================================

	
	Map<String,Object> map2 = new HashMap<String,Object>();
	Map<String,Object> map3 = new HashMap<String,Object>();
	
	@Given("The valid basUrl to  create risk profile")
	public void the_valid_bas_url_to_create_risk_profile() {
		RestAssured.baseURI="https://r99uw32s4a.execute-api.us-east-1.amazonaws.com/user-service";
		System.out.println("-------------------------");
		System.out.println("Base URI given");
		System.out.println("-------------------------");	
	}

	@When("request is sent to the server with for creating user risk profile")
	public void request_is_sent_to_the_server_with_for_creating_user_risk_profile() {
		map2.put("assetFluctuationPercentage","2");
		map2.put("country","India");
		map2.put("currentHoldingInvestments","1");
		map2.put("dateOfBirth","2000-03-21");
		map2.put("investmentAppetiteRange","1");
		map2.put("investmentDuration",0);
		map2.put("investmentExperienceInYears","1");
		map2.put("investorTypeEnum","ACCREDITED_INVESTOR");
		map2.put("monthlyIncomeAllocationPercentage","2");
		map2.put("preferredInvestmentAsset","1");
		map2.put("preferredInvestmentStrategy","1");
		map2.put("returnRate",0);
		map2.put("userId",114);
		
		JSONObject request = new JSONObject(map2);
		
		response = given().
				header("Content-Type","application/json").
				contentType(ContentType.JSON).
				accept(ContentType.JSON).body(request.toJSONString()).
			when().
				post("/api/v1/user-risk-profile");
	}

	@Then("User risk profile should be created")
	public void user_risk_profile_should_be_created() {
		response.then().
		log().all().
	assertThat().
		statusCode(200).
		header("Content-Type", "application/json");
		System.out.println("-------------------------");
		System.out.println("Risk profile should posted");
		System.out.println("-------------------------");
	}
	
	@When("Request is sent to server without ID")
	public void request_is_sent_to_server_without_id() {
		map3.put("assetFluctuationPercentage","2");
		map3.put("country","India");
		map3.put("currentHoldingInvestments","1");
		map3.put("dateOfBirth","2000-03-21");
		map3.put("investmentAppetiteRange","1");
		map3.put("investmentDuration",0);
		map3.put("investmentExperienceInYears","1");
		map3.put("investorTypeEnum","ACCREDITED_INVESTOR");
		map3.put("monthlyIncomeAllocationPercentage","2");
		map3.put("preferredInvestmentAsset","1");
		map3.put("preferredInvestmentStrategy","1");
		map3.put("returnRate",0);
		
		JSONObject request = new JSONObject(map3);
		
		response = given().
				header("Content-Type","application/json").
				contentType(ContentType.JSON).
				accept(ContentType.JSON).body(request.toJSONString()).
			when().
				post("/api/v1/user-risk-profile");
	}

	@Then("User risk profile shouldnt be created")
	public void user_risk_profile_shouldnt_be_created() {
		response.
		then().
			log().all().
		assertThat().
			statusCode(400).
			header("Content-Type", "application/json");
		
		System.out.println("-------------------------");
		System.out.println("Placement agent shouldnt get posted");
		System.out.println("-------------------------");
	}

}
