package dataProviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import com.google.gson.Gson;
import managers.FileReaderManager;
import testDataTypes.RobotScenario;

public class JsonDataReader {
	private final String robotScenarioFilePath = FileReaderManager.getInstance().getConfigReader()
			.getTestDataResourcePath() + "RobotTestScenario.json";
	public List<RobotScenario> RobotScenarioList;

	public JsonDataReader() {
		RobotScenarioList = getRobotScenarioData();
	}

	public List<RobotScenario> getRobotScenarioData() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(robotScenarioFilePath));
			RobotScenario[] RobotScenarios = gson.fromJson(bufferReader, RobotScenario[].class);

			return Arrays.asList(RobotScenarios);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + robotScenarioFilePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}
	}

	public final RobotScenario getScenarioByName(String scenarioName) {
		for (RobotScenario robotScenario : FileReaderManager.getInstance().getJsonReader().RobotScenarioList) {
			if (robotScenario.getScenarioName().equalsIgnoreCase(scenarioName)) {
				return robotScenario;
			}
		}
		return null;
	}

}