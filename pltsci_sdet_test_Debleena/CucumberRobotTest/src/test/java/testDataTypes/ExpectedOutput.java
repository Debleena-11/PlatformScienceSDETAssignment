package testDataTypes;


import java.util.List;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "coords", "patches" })
@Generated("jsonschema2pojo")
public class ExpectedOutput {

	@JsonProperty("coords")
	private List<Integer> coords;
	@JsonProperty("patches")
	private Integer patches;
	

	@JsonProperty("coords")
	public List<Integer> getCoords() {
		return coords;
	}

	@JsonProperty("coords")
	public void setCoords(List<Integer> coords) {
		this.coords = coords;
	}

	@JsonProperty("patches")
	public Integer getPatches() {
		return patches;
	}

	@JsonProperty("patches")
	public void setPatches(Integer patches) {
		this.patches = patches;
	}

}