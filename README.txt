OrangeHRM Web Automation Project
==============================

This project automates the testing of user management functionality in OrangeHRM using Selenium WebDriver, Java, Maven, and TestNG.

Prerequisites
------------
1. Java JDK 11 or higher
2. Maven 3.6 or higher
3. Chrome and Firefox browsers installed
4. Internet connection

Project Structure
----------------
├── pom.xml
├── README.txt
├── src/
│   ├── main/
│   │   └── java/com/orangehrm/
│   │       ├── config/
│   │       │   └── ConfigurationManager.java
│   │       ├── drivers/
│   │       │   └── WebDriverFactory.java
│   │       ├── pages/
│   │       │   ├── BasePage.java
│   │       │   ├── LoginPage.java
│   │       │   ├── DashboardPage.java
│   │       │   └── AdminPage.java
│   │       └── utils/
│   │           └── ScreenshotUtil.java
│   └── test/
│       ├── java/com/orangehrm/tests/
│       │   ├── base/
│       │   │   └── TestBase.java
│       │   ├── scenarios/
│       │   │   ├── CreateUserTest.java
│       │   │   └── DisableUserTest.java
│       │   └── suites/
│       │       └── UserManagementTestSuite.java
│       └── resources/
│           ├── config.properties
│           ├── log4j.properties
│           └── testng.xml

Setup Instructions
-----------------
1. Clone the repository
2. Open the project in your preferred IDE
3. Update the config.properties file with your OrangeHRM credentials if needed
4. Run 'mvn clean install' to download dependencies

Running Tests
------------
1. To run all tests:
   mvn test

2. To run specific test class:
   mvn test -Dtest=CreateUserTest
   or
   mvn test -Dtest=DisableUserTest

3. To run tests in a specific browser:
   Update the 'browser' property in config.properties to either 'chrome' or 'firefox'

Test Scenarios
-------------
1. Create User Test
   - Logs in as admin
   - Creates a new user
   - Verifies user creation
   - Logs out
   - Logs in with new user credentials
   - Verifies successful login

2. Disable User Test
   - Logs in as admin
   - Creates a new user
   - Disables the user
   - Logs out
   - Attempts to log in with disabled user
   - Verifies appropriate error message

Reports
-------
Test execution reports can be found in:
- target/surefire-reports/ (TestNG reports)
- logs/automation.log (Log file)
