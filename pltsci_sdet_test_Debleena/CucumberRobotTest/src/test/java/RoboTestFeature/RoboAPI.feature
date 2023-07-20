#Author: debleena11@gmail.com
#Summary :
#The testing has been broadly been split in two categories.
#1) Effort to test the service API with diffrent combination of values
#	a) postive values simulating various scenarios like installing
# 	3 patches but cleanign only 1 or repeated cleaning of the same patch.
#	b) testing with negetive values for room or using out of boundary values for robot's
#			initial position.
#	*various scenario names has been used which are seen under scenarioName column.
#		the defination of those scenatios can be found in CucumberRobotTest\src\test\resources\testDataResources\RobotTestScenario.json
#2) Effort to test by modifying values of headers and trying to access invalid resources to see if correct error codes are begin returned. 
#
Feature: Test ROBO API
Scenario Outline: Room and starting position parameter variation Tests
  Given scenario request has name "<scenarioName>"
   When I send the request
   Then service output json should match with expected output and <statusExpected> status code

  Examples: 
    | scenarioName                     | statusExpected | 
    | Room5x5_dirtpatch0               | 200            | 
    | Room5x5_dirtpatch3_clean1        | 200            | 
    | Room5x5_dirtpatch3_clean1_repeat | 200            | 
    | Room5x5_dirtpatch3_clean2        | 200            | 
    | Room5x5_dirtpatch3_clean3        | 200            | 
    | Room5x5_dirtpatch3_clean0        | 200            | 

Scenario Outline: Negetaive value Room and starting position parameter variation Tests
  Given scenario request has name "<scenarioName>"
   When I send the request
   Then service output json should match with expected output and <statusExpected> status code

  Examples: 
    | scenarioName                | statusExpected | 
    | Negative_coords             | 400            | 
    | Negative_Room_Size          | 400            | 
    | Negative_coords_sit2        | 400            | 
    | Missing_Room_Size_parameter | 400            | 
    | faulty_directions           | 400            | 

Scenario: Change Request Type from POST to GET
  Given scenario request has name "<scenarioName>"
   When I send the request with unsupported type
   Then received status code should match with <statusExpected> status code
  Examples: 
    | scenarioName              | statusExpected | 
    | Room5x5_dirtpatch3_clean1 | 405            | 

Scenario: Use Invalid Header
  Given scenario request has name "<scenarioName>"
   When I send the request with invalid header
   Then received status code should match with <statusExpected> status code
  Examples: 
    | scenarioName              | statusExpected | 
    | Room5x5_dirtpatch3_clean1 | 415            | 

Scenario: Post request to invalid path
  Given scenario request has name "<scenarioName>"
   When I send the request with invalid path
   Then received status code should match with <statusExpected> status code
  Examples: 
    | scenarioName              | statusExpected | 
    | Room5x5_dirtpatch3_clean1 | 404            | 