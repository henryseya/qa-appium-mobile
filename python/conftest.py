import pytest
from appium import webdriver
from appium.options.android import UiAutomator2Options

BS_USERNAME   = "henryherrera_GprjUl"
BS_ACCESS_KEY = "4pLTyz7SmXR2M7ymtqpy"
BS_APP_URL    = "bs://1722f453dee853f03928032080c09a837b6ae525"
BS_REMOTE_URL = f"https://{BS_USERNAME}:{BS_ACCESS_KEY}@hub.browserstack.com/wd/hub"


@pytest.fixture(scope="class")
def driver():
    options = UiAutomator2Options()
    options.app = BS_APP_URL

    options.set_capability("bstack:options", {
        "deviceName":  "Samsung Galaxy S23",
        "osVersion":   "13.0",
        "projectName": "QA Automation Study",
        "buildName":   "Day 7 - Appium Mobile",
        "sessionName": "ApiDemos Tests - Python",
        "userName":    BS_USERNAME,
        "accessKey":   BS_ACCESS_KEY,
    })

    _driver = webdriver.Remote(
        command_executor=BS_REMOTE_URL,
        options=options
    )
    _driver.implicitly_wait(15)
    print("\nDriver iniciado - sesion BrowserStack activa")

    yield _driver

    _driver.quit()
    print("\nDriver cerrado")