# Mobile Framework

## Overview
This project is a mobile automation testing framework designed to test Android applications using Appium, Selenium, and Cucumber. It integrates various tools and libraries to provide a robust and scalable testing solution.

---

## Tools and Technologies Used
- **Programming Language**: Java
- **Build Tool**: Maven
- **Mobile Automation**: Appium
- **Web Automation**: Selenium WebDriver
- **Test Framework**: TestNG
- **Behavior-Driven Development (BDD)**: Cucumber
- **Reporting**: ExtentReports
- **Dependency Management**: Maven Central Repository
- **IDE**: IntelliJ IDEA

---

## Project Structure
src/ ├── main/ │ 
    ├── Apps/ # Contains the APK files for testing │ 
    └── java/ 
    ├── test/ 
│ ├── java/
│ │ ├── Screens/ # Page Object Model (POM) classes │ │ ├── Steps/ # Step Definitions for Cucumber │ │ ├── Runners/ # Cucumber Test Runners │ │ └── Utils/ # Utility classes (e.g., Appium Driver Factory) │ └── resources/ │ ├── Features/ # Cucumber feature files │ └── Config/ # Configuration files


## Dependencies
The following dependencies are used in this project:

- **Appium Java Client**: `8.7.0`
- **Selenium WebDriver**: `4.15.2`
- **TestNG**: `7.9.0`
- **Cucumber Java**: `7.14.0`
- **Cucumber TestNG**: `7.14.0`
- **ExtentReports Cucumber Adapter**: `1.9.0`

---

## Features
- **BDD with Cucumber**: Write test scenarios in plain English using Gherkin syntax.
- **Page Object Model (POM)**: Maintainable and reusable page classes for UI interactions.
- **Cross-Platform Testing**: Supports Android devices and emulators.
- **Detailed Reporting**: Generate HTML and JSON reports with ExtentReports.
- **Parallel Execution**: Run tests in parallel using TestNG.

---

## How to Run the Tests
1. Clone the repository:
   ```bash
   git clone https://github.com/Nkosikk/Mobile2ndGroup2025.git