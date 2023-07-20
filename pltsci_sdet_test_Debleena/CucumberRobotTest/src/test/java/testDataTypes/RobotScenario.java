package testDataTypes;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "ScenarioName", "scenario", "expectedOutput" })
@Generated("jsonschema2pojo")
public class RobotScenario {

	@JsonProperty("ScenarioName")
	private String scenarioName;
	@JsonProperty("scenario")
	private Scenario scenario;
	@JsonProperty("expectedOutput")
	private ExpectedOutput expectedOutput;
	

	@JsonProperty("scenarioName")
	public String getScenarioName() {
		return scenarioName;
	}

	@JsonProperty("scenarioName")
	public void setScenarioName(String scenarioName) {
		this.scenarioName = scenarioName;
	}

	@JsonProperty("scenario")
	public Scenario getScenario() {
		return scenario;
	}

	@JsonProperty("scenario")
	public void setScenario(Scenario scenario) {
		this.scenario = scenario;
	}

	@JsonProperty("expectedOutput")
	public ExpectedOutput getExpectedOutput() {
		return expectedOutput;
	}

	@JsonProperty("expectedOutput")
	public void setExpectedOutput(ExpectedOutput expectedOutput) {
		this.expectedOutput = expectedOutput;
	}
}