package org.webAndMobile.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * Runner class for Mobile automation
 */
@CucumberOptions(
        features = "src/test/java/org/webAndMobile/tests/features",
        glue = {"org.webAndMobile.tests.stepsDefinitions.mobile"},
        tags = "@mobileNavigation")

public class RunMobileTests extends AbstractTestNGCucumberTests{
}
