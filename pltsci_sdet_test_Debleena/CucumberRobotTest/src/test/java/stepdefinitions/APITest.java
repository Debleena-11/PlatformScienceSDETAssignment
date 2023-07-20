package stepdefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

import com.google.gson.Gson;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import managers.FileReaderManager;
import testDataTypes.RobotScenario;

public class APITest {

	public static Scenario scenario;
	private static Response response;

	private RobotScenario roboScenario;

	@Before
	public void setup(Scenario scenario) {
		APITest.scenario = scenario;
	}
	@Given("scenario request has name {string}")
	public void scenario_request_has_name(String scenarioName) {
		this.roboScenario = FileReaderManager.getInstance().getJsonReader().getScenarioByName(scenarioName);
	}

	@When("I send the request")
	public void i_send_the_request() {
		Gson gson = new Gson();
		// System.out.println("scenario print: " + gson.toJson(scenario.getScenario()));
		response = given().header("Content-type", "application/json").and().body(gson.toJson(roboScenario.getScenario()))
				.when().post("/v1/cleaning-sessions").then().extract().response();
	}

	@Then("service output json should match with expected output and {int} status code")
	public void service_output_json_should_match_with_expected_output_and_status_code(Integer int1) {		
		Gson gson = new Gson();
		scenario.log("Response: " + response.asString() + "status" + response.getStatusCode());
		scenario.log("Expected: " + gson.toJson(roboScenario.getExpectedOutput()) + "status" + int1 );
		assertTrue(int1.equals(response.getStatusCode()));
		if(response.getStatusCode()==200) {
			assertTrue(gson.toJson(roboScenario.getExpectedOutput()).equals(response.asString()));
		}
	}
	
	@When("I send the request with unsupported type")
	public void i_send_the_request_with_unsupported_type() {	    
	    Gson gson = new Gson();
		// System.out.println("scenario print: " + gson.toJson(scenario.getScenario()));
		response = given().header("Content-type", "application/json").and().body(gson.toJson(roboScenario.getScenario()))
				.when().get("/v1/cleaning-sessions").then().extract().response();
	}
	
	@Then("received status code should match with {int} status code")
	public void received_status_code_should_match_with_status_code(Integer int1) {
	    Gson gson = new Gson();
		scenario.log("Response: " + response.asString() + "status" + response.getStatusCode());
		scenario.log("Expected: " + gson.toJson(roboScenario.getExpectedOutput()) + "status" + int1 );
		assertTrue(int1.equals(response.getStatusCode()));		
	}
	
	@When("I send the request with invalid header")
	public void i_send_the_request_with_invalid_header() {

	    Gson gson = new Gson();
		// System.out.println("scenario print: " + gson.toJson(scenario.getScenario()));
		response = given().header("Accept", "application/json1hgyg").and().body(gson.toJson(roboScenario.getScenario()))
				.when().post("/v1/cleaning-sessions").then().extract().response();
	}
	
	@When("I send the request with invalid path")
	public void i_send_the_request_with_invalid_path() {
		Gson gson = new Gson();
		// System.out.println("scenario print: " + gson.toJson(scenario.getScenario()));
		response = given().header("Content-type", "application/json").and().body(gson.toJson(roboScenario.getScenario()))
				.when().post("/v1/cleaning-sessions1").then().extract().response();
	}


}
