# OrangeHRM Web Automation

This project implements automated testing for the OrangeHRM web application using Selenium WebDriver, TestNG, and the Page Object Model (POM) design pattern.

## Project Structure

```
Orangehrm-Web-Automation/
├── src/
│   ├── main/java/com/orangehrm/
│   │   ├── config/         # Configuration management
│   │   ├── drivers/        # WebDriver factory and management
│   │   ├── pages/          # Page object classes
│   │   └── utils/          # Utility classes (ReportManager, etc.)
│   └── test/java/com/orangehrm/tests/
│       ├── base/           # Base test classes
│       ├── scenarios/      # Test scenarios
│       └── suites/         # Test suites
├── testng.xml              # TestNG configuration
└── pom.xml                 # Maven dependencies and build configuration
```

## Prerequisites

- Java 11 or higher
- Maven 3.6 or higher
- Chrome or Firefox browser installed
- Git

## Dependencies

- Selenium WebDriver 4.15.0
- TestNG 7.8.0
- WebDriverManager 5.6.2
- ExtentReports 5.1.1
- Log4j 2.20.0

## Setup Instructions

1. Clone the repository:
   ```bash
   git clone [repository-url]
   cd Orangehrm-Web-Automation
   ```

2. Build the project:
   ```bash
   mvn clean install
   ```

3. Configure the application:
   - Update `src/main/resources/config.properties` with your OrangeHRM URL and credentials
   - Configure browser settings in the same file

## Running Tests

### Run All Tests
```bash
mvn test
```

### Run Specific Test Suite
```bash
mvn test -Dtest=UserManagementTestSuite
```

### Run Individual Test
```bash
mvn test -Dtest=CreateUserTest
```

## Test Reports

Test reports are generated in:

Extent Reports: `test-output/ExtentReports/OrangeHRM-Test-Report-[timestamp].html`

## Project Features

- Page Object Model (POM) implementation
- Multi-browser support (Chrome, Firefox)
- ExtentReports integration for detailed test reporting
- Log4j logging
- Configuration management
- Test suite organization
- User management test scenarios

## Test Scenarios

### User Management
1. Create User
   - Navigate to Admin page
   - Add new user
   - Verify user creation

2. Disable User
   - Search for existing user
   - Disable user account
   - Verify user status
