# qa-appium-mobile

Mobile Testing with Appium + BrowserStack — Java and Python
QA Automation Study Plan.

## Stack
- Appium Java Client 8.6.0 + TestNG
- Appium Python Client 4.3.0 + pytest
- BrowserStack App Automate (Samsung Galaxy S23 — Android 13)

## Structure
qa-appium-mobile/
├── java/
│   ├── pom.xml
│   ├── testng.xml
│   └── src/test/java/
│       ├── config/BrowserStackConfig.java
│       ├── pages/ApiDemosHomePage.java
│       └── tests/
│           ├── BaseTest.java
│           └── ApiDemosTest.java
└── python/
├── requirements.txt
├── pytest.ini
├── conftest.py
├── pages/home_page.py
└── tests/test_api_demos.py
## Run

### Java
```bash
cd java
mvn test
```

### Python
```bash
cd python
pip install -r requirements.txt
pytest
```

## Results
View live sessions at BrowserStack App Automate dashboard:
https://app-automate.browserstack.com/dashboard
