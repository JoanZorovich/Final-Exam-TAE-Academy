package org.webAndMobile.tests.stepsDefinitions.mobile;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.webAndMobile.utils.mobile.ConfigCapabilities;
import org.webAndMobile.utils.mobile.MobileDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class MobileHooks {

    public static MobileDriver driver;

    @Before
    public void environmentSetUp() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        ConfigCapabilities.deviceSetUp(capabilities);
        ConfigCapabilities.applicationSetUp(capabilities);
        try {
            driver = new MobileDriver(new AndroidDriver<AndroidElement>(
                    new URL("http://127.0.0.1:4723/wd/hub"), capabilities));
        } catch (MalformedURLException exception) {
            exception.printStackTrace();
        }
    }

    @After
    public void tearDown() {
        driver.getDriver().quit();
    }


    public static AndroidDriver<AndroidElement> getDriver() {
        return driver.getDriver();
    }
}

