# selenium-java
Voicemod testing project

This is a basic Selenium-Java project using the Base Model Page Object to organize the structure of your project
The Structure of this project is:
src>>main>>java>>net
net>>qa.ExtentReportListner>>ExtentReporterNG (class that build Test Nodes and generate Report)
net>>voicemod.qa (has four test classes...base>>config>>pages>>util... who have the test classes for the webside different features)

It has following characteristics as needed: 
● Selenium and the necessary dependencies to execute the project.
--Downloaded the Selenium and add the jar files to the project directory 

● Firefox as a browser to launch the tests.
--TestBase class is used to add the driver and configure it.

● Develop the acceptance tests that you have previously defined automatically, do not
forget:
o If you make a check , use Assert with an explanatory message.
o Use Javadoc in each of the methods.
o Close the browser when we finish each test case.
--Everything is working

● A suite is created in TestNG to launch all the tests.
--In test>>java>>net.voicemod.qa.testcases (we have three main feature test cases which are testing the Home page, pageLoad and VoiceMod site test.
--we have build a TestNG method which runs all the testcases.

● Analyze your code with Sonar and correct the defects found. Send a screenshot of
the results of the analysis.
I have tried to follow it but it was diving me some errors if i got some more time i can fix this.


