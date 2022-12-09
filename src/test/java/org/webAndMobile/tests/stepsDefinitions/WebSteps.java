package org.webAndMobile.tests.stepsDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.webAndMobile.pageObjects.pages.HomePage;
import org.webAndMobile.utils.reporting.Reporter;

public class WebSteps {

    private HomePage home;
    @Given("User is on the ESPN home page")
    public void userIsOnTheESPNHomePage() {
        home = new HomePage(WebHooks.getDriver());
        Reporter.info("Validate main content in home page");
        Assert.assertTrue(home.isMainContentDisplayed(), "Main content is not displayed");
        Reporter.info("Navbar is displayed");
        Assert.assertTrue(home.isNavbarDisplayed(), "Navbar is not displayed");
    }

    @When("User sign up successfully {string} {string} {string} {string}")
    public void userSignUpSuccessfully(String firstName, String lastName, String email, String password) {
        home.placeMouseOverProfileLogo();
        Reporter.info("Validate profile Menu is displayed");
        Assert.assertTrue(home.isMainContentDisplayed(), "profile Menu is not displayed");
        home.clickOnLoginLink();
        home.switchToIframeForm();

        Reporter.info("ESPN logo is displayed");
        Assert.assertTrue(home.isESPNFormLogoDisplayed(), "ESPN logo is not displayed");
        Reporter.info("Log In Button is displayed");
        Assert.assertTrue(home.isSubmitButtonDisplayed(), "Log In Button is not displayed");
        Reporter.info("Sign Up Button is displayed");
        Assert.assertTrue(home.isSignUpButtonDisplayed(), "Sign Up Button is not displayed");

        home.clickSignUpButton();


    }

    @Then("Watch page should displays different carousels")
    public void watchPageShouldDisplaysDifferentCarousels() {
    }

    @And("User returns to home page")
    public void userReturnsToHomePage() {
    }

    @And("User logs out from session")
    public void userLogsOutFromSession() {
    }

}
