package testDataTypes;

import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "roomSize", "coords", "patches", "instructions" })
@Generated("jsonschema2pojo")
public class Scenario {

	@JsonProperty("roomSize")
	private List<Integer> roomSize;
	@JsonProperty("coords")
	private List<Integer> coords;
	@JsonProperty("patches")
	private List<List<Integer>> patches;
	@JsonProperty("instructions")
	private String instructions;
	

	@JsonProperty("roomSize")
	public List<Integer> getRoomSize() {
		return roomSize;
	}

	@JsonProperty("roomSize")
	public void setRoomSize(List<Integer> roomSize) {
		this.roomSize = roomSize;
	}

	@JsonProperty("coords")
	public List<Integer> getCoords() {
		return coords;
	}

	@JsonProperty("coords")
	public void setCoords(List<Integer> coords) {
		this.coords = coords;
	}

	@JsonProperty("patches")
	public List<List<Integer>> getPatches() {
		return patches;
	}

	@JsonProperty("patches")
	public void setPatches(List<List<Integer>> patches) {
		this.patches = patches;
	}

	@JsonProperty("instructions")
	public String getInstructions() {
		return instructions;
	}

	@JsonProperty("instructions")
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	
}