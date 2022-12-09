package org.webAndMobile.tests.stepsDefinitions.mobile;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.webAndMobile.pageObjects.screens.DashBoardScreen;
import org.webAndMobile.pageObjects.screens.TutorialScreen;


public class MobileSteps {

    private TutorialScreen tutorialScreen;
    private DashBoardScreen dashBoardScreen;
    @Given("User is on Disneyland dashboard screen")
    public void userIsOnDisneylandDashboardScreen() {
        tutorialScreen = new TutorialScreen(MobileHooks.getDriver());
        tutorialScreen.startPermissionsProcess();
        dashBoardScreen = tutorialScreen.shareLocationPermissions();
    }

    @When("User taps the Map Button available e in the bottom bar")
    public void userTapsTheMapButtonAvailableEInTheBottomBar() {
    }

    @And("User taps Attractions List")
    public void userTapsAttractionsList() {
    }

    @Then("User can see different categories to select, including hotels")
    public void userCanSeeDifferentCategoriesToSelectIncludingHotels() {
    }
}
