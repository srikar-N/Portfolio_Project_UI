# 🧪 E-Commerce UI Automation Framework 🚀
**Selenium WebDriver + Java + TestNG**

## 📌 Overview

This project is a UI automation framework built using Selenium WebDriver with Java.

The framework automates a representative e-commerce purchase journey (Login → Product → Checkout → Confirmation) to demonstrate a maintainable regression strategy — stable flows are automated while exploratory and edge-case validation remain manual.

Key goals:
- Reduce repetitive regression effort
- Ensure consistent validation across executions
- Provide faster feedback through parallel execution


## 🛠 Tech Stack

| Category | Tools |
|---|---|
| Language | Java (JDK 17) |
| Automation | Selenium WebDriver |
| Test Framework | TestNG |
| Build Tool | Maven |
| Design Pattern | Page Object Model |
| Test Data | JSON + Properties |
| CI/CD | Jenkins |




## ✨ Framework Design Highlights

- Designed Page Object Model to separate UI actions from test logic
- Centralized WebDriver lifecycle using BaseTest
- Implemented thread-safe parallel execution using ThreadLocal WebDriver
- Added retry mechanism to handle intermittent UI failures
- Implemented TestNG Listeners for execution tracking
- Externalized environment configuration via properties file
- Data-driven validation using JSON test data
- Integrated Jenkins for automated regression execution



## 🧪 Automated Test Coverage

**Authentication**
- Valid login
- Invalid login validation

**Order Workflow (End-to-End)**
- Navigate to product page
- Select product
- Add to cart
- Checkout
- Order confirmation validation


## 📁 Project Structure
```
ui-automation-framework
│
├── src/main/java
│   ├── portfolio.pages
│   │     ├── BasePage
│   │     ├── LoginPage
│   │     ├── ProductPage
│   │     └── ConfirmCheckoutPage
│   │
│   └── portfolio.utility
│         └── ReportsUtil
│
├── src/test/java
│   ├── portfolio.tests
│   │     ├── LoginTest
│   │     └── PlaceOrderTest
│   │
│   └── portfolio.testComponents
│         ├── BaseTest
│         ├── Listener
│         └── Retry
│
├── src/main/resources
│   └── Global.properties
│
├── src/test/resources
│   └── invalidData.json
│
├── testng.xml
└── pom.xml
```



## ▶️ Running the Tests

Run using Maven:

```
mvn test 
```

Or execute via TestNG suite XML.

## 🤖 CI/CD Integration

The framework is integrated with Jenkins to support automated execution.
Test suites can be triggered automatically and executed in parallel for faster feedback.



## 🎯 Purpose
The project demonstrates how a scalable automation framework can support regression testing by automating stable user journeys, allowing manual testing to focus on new functionality and edge cases.



