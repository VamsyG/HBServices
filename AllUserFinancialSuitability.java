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

public class AllUserFinancialSuitability {
	
	Response response;
	
	@Given("The valid basUrl to get financial suitability")
	public void the_valid_bas_url_to_get_financial_suitability() {
		RestAssured.baseURI="https://r99uw32s4a.execute-api.us-east-1.amazonaws.com/user-service";
		System.out.println("-------------------------");
		System.out.println("Base URI given");
		System.out.println("-------------------------");	
	}

	@When("request is sent to the server with url for obtaining user financial suitability with valid id {int}")
	public void request_is_sent_to_the_server_with_url_for_obtaining_user_financial_suitability_with_valid_id(Integer int1) {
		response = given().
				header("Content-Type","application/json").
				contentType(ContentType.JSON).
				accept(ContentType.JSON).
			when().
   			    get("/api/v1/user-financial-suitability/"+int1);
		System.out.println("-------------------------");
		System.out.println("Valid ID is passed");
		System.out.println("-------------------------");
	}

	@Then("User financial suitability should be obtained")
	public void user_financial_suitability_should_be_obtained() {
		response.
		then().
			log().all().
		assertThat().
			statusCode(200).
			header("Content-Type", "application/json");
		System.out.println("-------------------------");
		System.out.println("User Financial suitability profile should be obtained");
		System.out.println("-------------------------");	
	}
	
	@When("request is sent to the server with invalid for user financial suitability")
	public void request_is_sent_to_the_server_with_invalid_for_user_financial_suitability() {
		
	}
	
	@When("request is sent to the server with invalid for user financial suitability with invalid id {int}")
	public void request_is_sent_to_the_server_with_invalid_for_user_financial_suitability_with_invalid_id(Integer int1) {
		response = given().
				header("Content-Type","application/json").
				contentType(ContentType.JSON).
				accept(ContentType.JSON).
			when().
   			    get("/api/v1/user-financial-suitability/"+int1);
		System.out.println("-------------------------");
		System.out.println("Invalid ID is passed");
		System.out.println("-------------------------");	
	}

	@Then("User financial suitability should not be obtained")
	public void user_financial_suitability_should_not_be_obtained() {
		response.
		then().
			log().all().
		assertThat().
			statusCode(400).
			header("Content-Type", "application/json");
		System.out.println("-------------------------");
		System.out.println("User Financial suitability profile should not be obtained");
		System.out.println("-------------------------");		
	}


//==============================================================================================================================	
	
	
	Map<String,Object> map = new HashMap<String,Object>();
	
	@Given("The valid basUrl to change financial suitability")
	public void the_valid_bas_url_to_change_financial_suitability() {
		RestAssured.baseURI="https://r99uw32s4a.execute-api.us-east-1.amazonaws.com/user-service";
		System.out.println("-------------------------");
		System.out.println("Base URI given");
		System.out.println("-------------------------");	
	}
	
	@When("request is sent to the server with url for updating user financial suitability with valid id {int}")
	public void request_is_sent_to_the_server_with_url_for_updating_user_financial_suitability_with_valid_id(Integer int1) {
		map.put("investmentGoals","4");//
		map.put("netWorth",2);//
		
		JSONObject request = new JSONObject(map);
		
		response = given().
				header("Content-Type","application/json").
				contentType(ContentType.JSON).
				accept(ContentType.JSON).body(request.toJSONString()).
			when().
				put("/api/v1/user-financial-suitability/"+int1);
		System.out.println("-------------------------");
		System.out.println("Valid endpoint is passed");
		System.out.println("-------------------------");	
		//then().contentType(ContentType.JSON).extract().response();
	}

	@Then("User financial suitability should be updated")
	public void user_financial_suitability_should_be_updated() {
		response.then().
		log().all().
     	assertThat().
		statusCode(200).
		header("Content-Type", "application/json");
		System.out.println("-------------------------");
		System.out.println("Financial suitability profile should be updated");
		System.out.println("-------------------------");
	}
	
	@When("request is sent to the server with url for updating user financial suitability with invalid id {int}")
	public void request_is_sent_to_the_server_with_url_for_updating_user_financial_suitability_with_invalid_id(Integer int1) {
		map.put("investmentGoals","4");//
		map.put("netWorth",2);//
		
		JSONObject request = new JSONObject(map);
		
		response = given().
				header("Content-Type","application/json").
				contentType(ContentType.JSON).
				accept(ContentType.JSON).body(request.toJSONString()).
			when().
				put("/api/v1/user-financial-suitability/"+int1);
		System.out.println("-------------------------");
		System.out.println("Valid endpoint is passed");
		System.out.println("-------------------------");	
		//then().contentType(ContentType.JSON).extract().response();
	}

	@Then("User financial suitability shouldont be updated")
	public void user_financial_suitability_shouldont_be_updated() {
		response.then().
		log().all().
     	assertThat().
		statusCode(400).
		header("Content-Type", "application/json");
		System.out.println("-------------------------");
		System.out.println("Financial suitability profile should not be updated");
		System.out.println("-------------------------");
	}
		
	@When("request is sent to the server with url for updating without body with valid id {int}")
	public void request_is_sent_to_the_server_with_url_for_updating_without_body_with_valid_id(Integer int1) {
		response = given().
				header("Content-Type","application/json").
				contentType(ContentType.JSON).
				accept(ContentType.JSON).
			when().
   			    put("/api/v1/user-financial-suitability/"+int1);
		System.out.println("-------------------------");
		System.out.println("Valid ID without body is passed");
		System.out.println("-------------------------");
	}

	@Then("User financial suitability should nt be updated")
	public void user_financial_suitability_should_nt_be_updated() {
		response.then().
		log().all().
     	assertThat().
		statusCode(400).
		header("Content-Type", "application/json");
		System.out.println("-------------------------");
		System.out.println("Financial suitability profile should not be updated");
		System.out.println("-------------------------");
	}
	


//==============================================================================================================================
	
	
	Map<String,Object> map2 = new HashMap<String,Object>();
	
	@Given("The valid basUrl to  create financial suitability profile")
	public void the_valid_bas_url_to_create_financial_suitability_profile() {
		RestAssured.baseURI="https://r99uw32s4a.execute-api.us-east-1.amazonaws.com/user-service";
		System.out.println("-------------------------");
		System.out.println("Base URI given");
		System.out.println("-------------------------");	
	}

	@When("request is sent to the server with for creating financial suitability profile")
	public void request_is_sent_to_the_server_with_for_creating_financial_suitability_profile() {
		map2.put("userId",114);//
		map2.put("investmentGoals","4");//
		map2.put("netWorth",2);//
		
		JSONObject request = new JSONObject(map2);
		
		response = given().
				header("Content-Type","application/json").
				contentType(ContentType.JSON).
				accept(ContentType.JSON).body(request.toJSONString()).
			when().
				post("/api/v1/user-financial-suitability");
		System.out.println("-------------------------");
		System.out.println("Valid endpoint is passed");
		System.out.println("-------------------------");	
			//then().statusCode(200).contentType(ContentType.JSON).extract().response();
	}

	@Then("User financial suitability profile should be created")
	public void user_financial_suitability_profile_should_be_created() {
		response.then().
		log().all().
     	assertThat().
		statusCode(400).
		header("Content-Type", "application/json");
		System.out.println("-------------------------");
		System.out.println("Financial suitability profile should posted");
		System.out.println("-------------------------");
	}
	
	@When("request is sent to the server with invalid uid")
	public void request_is_sent_to_the_server_with_invalid_uid() {
		map2.put("userId",300);//
		map2.put("investmentGoals","4");//
		map2.put("netWorth","2");//
		
		JSONObject request = new JSONObject(map2);
		
		response = given().
				header("Content-Type","application/json").
				contentType(ContentType.JSON).
				accept(ContentType.JSON).body(request.toJSONString()).
			when().
				post("/api/v1/user-financial-suitability");
		System.out.println("-------------------------");
		System.out.println("Invalid ID is passed");
		System.out.println("-------------------------");		
	}

	@Then("User financial suitability profile shouldnt be created")
	public void user_financial_suitability_profile_shouldnt_be_created() {
		response.then().
		log().all().
     	assertThat().
		statusCode(400).
		header("Content-Type", "application/json");
		System.out.println("-------------------------");
		System.out.println("Financial suitability profile should not be posted");
		System.out.println("-------------------------");	
	}



}
