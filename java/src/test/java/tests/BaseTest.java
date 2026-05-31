package tests;

import config.BrowserStackConfig;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class BaseTest {

    protected AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setApp(BrowserStackConfig.APP_URL);

        HashMap<String, Object> bstackOptions = new HashMap<>();
        bstackOptions.put("deviceName",  "Samsung Galaxy S23");
        bstackOptions.put("osVersion",   "13.0");
        bstackOptions.put("projectName", "QA Automation Study");
        bstackOptions.put("buildName",   "Day 7 - Appium Mobile");
        bstackOptions.put("sessionName", "ApiDemos Tests - Java");
        bstackOptions.put("userName",    BrowserStackConfig.USERNAME);
        bstackOptions.put("accessKey",   BrowserStackConfig.ACCESS_KEY);
        options.setCapability("bstack:options", bstackOptions);

        driver = new AndroidDriver(new URL(BrowserStackConfig.REMOTE_URL), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        System.out.println("Driver iniciado - sesion BrowserStack activa");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Driver cerrado");
        }
    }
}