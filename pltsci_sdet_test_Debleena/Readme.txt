Please find the bug report in bugreport.txt file along with an existing Cucumber HTML report present at CucumberRobotTest\target\cucumber-reports.html

This project has been created in Eclipse using Java and Maven.
The following main libraries have been used in developing this project
1) Restassured
2) Cucumber
3) Juint
4) google's gson
for a full list of libraries please refer to the project object model(pom.xml) present at CucumberRobotTest\pom.xml

How to run the project using Eclipse
1) Launch Eclipse 
2) On prompt point to the root directory of the project
3) After the project loads under the package explorer right click on "testrunners" package and choose to run as "junit Test"
the testrunners package can be found under "/CucumberRobotTest/src/test/java/testrunners"

*It is assumed that the Docker application "robot" is already running on local host and listening to request on 8080 port.
instruction to run the application can be found here: https://bitbucket.org/platformscience/pltsci-sdet-assignment/src/main/README.md

**After the test ran, the HTML test reports can be found at: CucumberRobotTest\target\cucumber-reports.html.

The /CucumberRobotTest/src/test/java/RoboTestFeature/RoboAPI.feature file contains the feature and scenario descriptions.

Some details about the project
dataProviders package: contains the classes and code for reading the json files(RobotTestScenario.json) which has the actual description of test scenarios
RoboTestFeature: This package contains the cucumber feature file containing the scenarios and scenario outlines in Gerkhin.
stepdefinitions: Java implemetations of the cucumber steps.
testDataTypes: POJO interface to the json data.
testrunners: JUnit inteface to run the test.
RobotTestScenario.json: contains the actual test scenarios.
