package org.webAndMobile.tests.stepsDefinitions.web;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.webAndMobile.utils.reporting.Reporter;
import org.webAndMobile.utils.web.Driver;

public class WebHooks {
    private static Driver driver;


    @Before
    public void webTestSetUp() {
        String url = "https://www.espnqa.com/?src=com&_adblock=true&espn=cloud";
        driver = new Driver("chrome");
        Reporter.info("Deleting cookies");
        driver.getDriver().manage().deleteAllCookies();
        Reporter.info("Navigating to: " + url);
        driver.getDriver().get(url);
        driver.getDriver().manage().window().maximize();
    }


    @After
    public void tearDown() {
        Reporter.info("Quitting driver");
        driver.getDriver().quit();
    }

    public static WebDriver getDriver() {
        return driver.getDriver();
    }
}
