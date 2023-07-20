This project has been creted in eclipse using java and Maven.
The following main libraries have been used in developing this project
1) restassured
2) cucumber
3) Juint
4) google's gson
for a full list of libraries please refer to the project object model(pom.xml) present at CucumberRobotTest\pom.xml

How to run the project using eclipse
1) launch eclipse 
2) On prompt point to the root directory of the project
3) After the project loads under the package explorer right click on "testrunners" package and choose to run as "Juint Test"
the testrunners package can be found under "/CucumberRobotTest/src/test/java/testrunners"

*it is assumed that the docker application "robot" is already running on local host and listening to request on 8080 port.
instruction to run the application can be found here: https://bitbucket.org/platformscience/pltsci-sdet-assignment/src/main/README.md

**After the test is ran the HTML tet reports can be found at: CucumberRobotTest\target\cucumber-reports.html

the /CucumberRobotTest/src/test/java/RoboTestFeature/RoboAPI.feature file contains the feature and scenario descriptions.

Some details about the project
dataProviders package : caontains the classes and code for readig the json files(RobotTestScenario.json) which has the actual description of test scenarios
RoboTestFeature: this package contains the cucumber feature file containing the scenarios and scenario outlines in Gerkhin.
stepdefinitions: java implemetations of the cucumber steps.
testDataTypes: POJO interface to the json data.
testrunners: juint inteface to run the test.
RobotTestScenario.json; contains the actual test scenarios.