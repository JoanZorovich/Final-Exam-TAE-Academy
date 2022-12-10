package org.webAndMobile.runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
/**
 * Runner class for web automation
 */
@CucumberOptions(
        features = "src/test/java/org/webAndMobile/tests/features",
        glue = {"org.webAndMobile.tests.stepsDefinitions"},
        tags = "@webNavigation")

public class RunWebTests extends AbstractTestNGCucumberTests {
}
