# 🧪 E-Commerce UI Automation Framework 🚀
**Selenium WebDriver + Java + TestNG**

## 📌 Overview

This project is a scalable UI automation framework built using Selenium WebDriver with Java following the Page Object Model (POM) design pattern.

It automates an end-to-end e-commerce order workflow — from login to order confirmation — replicating real user behaviour.

The goal of this framework is to:
 - Reduce repetitive regression effort 🔁
 - Improve release confidence ✅
 - Allow manual testing to focus on exploratory scenarios 🧠


## 🛠 Tech Stack

| Category | Tools |
| :--- | :--- |
| **Language** | Java (JDK 17) ☕ |
| **Automation** | Selenium WebDriver 🌐 |
| **Test Framework** | TestNG 🧩 |
| **Build Tool** | Maven 📦 |
| **Design Pattern** | Page Object Model 🏗️ |
| **Test Data** | JSON + Properties 📄 |




## ✨ Framework Highlights

- 🧱 Centralized WebDriver management (BaseTest)
- 🧭 Clean Page Object Model structure
- 📂 Data-driven testing using JSON
- ⚙️ Environment configuration via properties file
- 🔄 Retry mechanism for flaky tests
- 🧑‍⚖️ TestNG Listeners for execution tracking
- 🧵 Thread-safe parallel execution using ThreadLocal
- 🚀 Parallel execution support
- 🤖 Jenkins integrated execution pipeline

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
├── 📂 pages
│     ├── BasePage
|     ├── LoginPage       
│     ├── ProductPage
│     └── ConfirmCheckoutPage
│
├── 📂 tests
│     ├── LoginTest
│     └── PlaceOrderTest
│
├── 📂 base
│     └── BaseTest (driver setup & initialization)
│
├── 📂 utilities
│     ├── ReportsUtil
│     ├── Listener
│     └── Retry
│
├── 📂 test-data
│     └── invalidData.json
│
├── ⚙️ config
│     └── Global.properties
│
├── 🧪 testng.xml
└── 📦 pom.xml
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

During manual testing, stable workflows like login and purchase had to be repeatedly verified every release.
This framework automates those regression scenarios so manual testing effort can focus on edge cases and new feature validation.
