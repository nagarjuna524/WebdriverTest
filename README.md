# Java Automation Framework (WebdriverTest)

This project is a hybrid automation framework combining the Page Object Model (POM) with both UI and API testing capabilities.

## Prerequisites

- Java JDK 1.8
- Apache Maven
- Browser Drivers (Chrome, Firefox) - located in the `drivers/` directory

## Maven Commands for Test Execution

### General Commands

- **Clean the project:**
  ```bash
  mvn clean
  ```
- **Compile the project:**
  ```bash
  mvn compile
  ```
- **Run all tests (default):**
  ```bash
  mvn test
  ```

### UI Test Profiles

- **Run all UI tests:**
  ```bash
  mvn test -PuiAllTests
  ```
- **Run UI Sanity tests:**
  ```bash
  mvn test -PuiSanityTests
  ```
- **Run UI Smoke tests:**
  ```bash
  mvn test -PuiSmokeTests
  ```

### API Test Profiles

- **Run all API tests:**
  ```bash
  mvn test -PapiAllTests
  ```
- **Run API Sanity tests:**
  ```bash
  mvn test -PapiSanityTests
  ```
- **Run API Smoke tests:**
  ```bash
  mvn test -PapiSmokeTests
  ```

### Running Specific Tests

- **Run a specific test class:**
  ```bash
  mvn test -Dtest=ClassName
  ```
  Example: `mvn test -Dtest=SanityTest`

- **Run a specific test method:**
  ```bash
  mvn test -Dtest=ClassName#methodName
  ```
  Example: `mvn test -Dtest=BrowserTest#testChrome`

## Reports

After test execution, reports can be found in the `target/surefire-reports/` directory:
- `index.html`: Standard TestNG report
- `emailable-report.html`: Shareable HTML report
