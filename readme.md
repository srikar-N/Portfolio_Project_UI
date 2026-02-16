# 🧪 E-Commerce UI Automation Framework 🚀
**Selenium WebDriver + Java + TestNG**

## 📌 Overview

This project is a UI automation framework built using Selenium WebDriver with Java, designed to mimic a real regression testing workflow.

Rather than automating isolated test cases, the framework focuses on automating stable user journeys while keeping exploratory and edge-case validation manual.

A representative e-commerce purchase flow (Login → Product → Checkout → Confirmation) is automated to demonstrate framework design, maintainability, and CI-friendly execution.

Key goals:
- Minimize repetitive regression effort
- Provide consistent validation across executions
- Enable faster feedback through parallel execution




## 🛠 Tech Stack

| Category | Tools |
| :--- | :--- |
| **Language** | Java (JDK 17) ☕ |
| **Automation** | Selenium WebDriver 🌐 |
| **Test Framework** | TestNG 🧩 |
| **Build Tool** | Maven 📦 |
| **Design Pattern** | Page Object Model 🏗️ |
| **Test Data** | JSON + Properties 📄 |




## ✨ Framework Design Highlights

- Implemented Page Object Model to separate UI actions from test logic
- Centralized driver lifecycle management using BaseTest
- Implemented thread-safe parallel execution using ThreadLocal WebDriver
- Added Retry mechanism to handle flaky UI behaviour
- Integrated TestNG Listeners for execution tracking and debugging
- Externalized configuration using properties file
- Data-driven validation using JSON test data
- Integrated Jenkins execution for automated regression runs
ne

## 🧪 Automated Test Coverage
1. 🔐 Authentication
    - Valid login
    -  Invalid login validation

2. 🧾 Order Workflow (End-to-End)

    - Navigate to product page
    - Select product
    - Add product to cart
    - Checkout process
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

To simulate real-world regression cycles, a representative e-commerce workflow was automated (login → product selection → checkout → confirmation).

The goal was not the specific application, but designing a maintainable automation strategy where stable flows are automated and manual testing can focus on exploratory and edge-case validation.


