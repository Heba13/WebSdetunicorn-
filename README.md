# Automation Testing for Sdetunicorn 

This project is aimed at automating Web application testing using selenium 4 and Cucumber framework with BDD (Behavior-Driven Development) methodology.
This README file will guide you through setting up and running the tests.

## Prerequisites

- Java Development Kit (JDK) installed
- Maven installed
- Git installed
- Your preferred IDE (IntelliJ IDEA, Eclipse, etc.)
- Your preferred Browser (Edge,chrome,firefox etc.)

## Steps

open git bash on the project directory then run command
```
git clone  https://github.com/Heba13/WebAutomation.git 
```
Choose browser Type by setting set variable in  java class WebDriverConfig 
 in driver directory.

- driverType = "chrome" 

Run "TestNG" file in project path

## Project Structure
- src/test/java/webApp/tests: Contains Java files for implementing test cases.
- src/test/java/webApp/pages: Contains pages classes contains  element locators and functions implementation .
- src/test/java/webApp/utilities/extentReport: Contains ExtentReport configuration files.
- src/test/java/webApp/driver:  Contains driver class 
- pom.xml: Maven project configuration file containing dependencies and plugins.
- testNG.xml file : testNg xml file

- ## Test Reporting
  Test reports are generated automatically after running "testNG" file.
  You can find the HTML report in the "\src\report" directory.
  Open shop.html in a web browser to view the test report.

- ## Media
-  record video html link 
**https://drive.google.com/file/d/1NS96s42TaHpuQs1KwKRqetp0wvtxDQkr/view?usp=drivesdk**
