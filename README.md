# API Automation Framework

## 📌 Project Overview
This project is a Java-based API automation testing framework built to validate RESTful API functionality.  
The framework automates HTTP requests and verifies responses to ensure APIs work correctly and are stable before release.

It covers:
- Positive test scenarios
- Negative test scenarios
- Edge case validations  
and generates detailed execution reports.

---

## 🛠 Tech Stack
- **Java**
- **REST Assured**
- **TestNG**
- **Maven**
- **Postman**
- **Extent Reports**
- **Git**

---

## 🚀 Features
- Automated GET and POST API tests  
- Data-driven testing using TestNG DataProvider  
- Validation of:
  - HTTP status codes
  - Response body
  - Headers  
- Logging of request and response  
- HTML execution reports using Extent Reports  
- Centralized configuration using BaseTest  
- Test suite execution using TestNG XML  
- Maven-based execution  

---

## 🌐 API Used
Public test API:
https://jsonplaceholder.typicode.com


Endpoints covered:
- GET `/users`
- POST `/posts`
- Invalid endpoints for negative testing

---

## 📂 Project Structure

api-automation-framework
│── pom.xml
│── testng.xml
│
└── src/test/java
├── base
│ └── BaseTest.java
├── tests
│ ├── GetUsersTest.java
│ ├── CreatePostTest.java
│ └── PostApiNegativeAndEdgeTest.java
└── utils
└── ExtentReportManager.java


---

## ▶ How to Run Tests

### Option 1: Run using TestNG XML
Right click on:

testng.xml → Run


### Option 2: Run using Maven (Recommended) 
From project root:
```bash
mvn test
```

---

## 📊 Test Report
After execution, open:

target/ExtentReport.html

This report shows:
- Test names
- Pass/Fail status
- Execution details

---

## 🧪 Testing Approach
- APIs are first validated manually using Postman.
- Automation is then implemented using REST Assured.
- Both success and failure scenarios are tested.
- Data-driven testing is used to run the same test with multiple datasets.


----
