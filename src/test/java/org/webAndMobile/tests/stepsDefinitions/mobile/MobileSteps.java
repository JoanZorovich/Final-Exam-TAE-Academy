package org.webAndMobile.tests.stepsDefinitions.mobile;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.webAndMobile.pageObjects.screens.DashBoardScreen;
import org.webAndMobile.pageObjects.screens.MapScreen;
import org.webAndMobile.pageObjects.screens.TutorialScreen;
import org.webAndMobile.utils.reporting.Reporter;


public class MobileSteps {

    private TutorialScreen tutorialScreen;
    private DashBoardScreen dashBoardScreen;
    private MapScreen map;
    @Given("User is on Disneyland dashboard screen")
    public void userIsOnDisneylandDashboardScreen() {
        tutorialScreen = new TutorialScreen(MobileHooks.getDriver());
        tutorialScreen.startPermissionsProcess();
        dashBoardScreen = tutorialScreen.shareLocationPermissions();
    }
    @When("User taps the Map Button available e in the bottom bar")
    public void userTapsTheMapButtonAvailableEInTheBottomBar() {
        Reporter.info("----Start navigation to Map Screen -----");
        map = dashBoardScreen.goToMapScreen();
    }
    @And("User taps Attractions List")
    public void userTapsAttractionsList() {
        map.clickOnCategoriesButton();
    }
    @Then("User can see different categories to select, including hotels")
    public void userCanSeeDifferentCategoriesToSelectIncludingHotels() {
        Reporter.info("Validate categories container");
        Assert.assertTrue(map.categoriesContainerIsDisplayed(), "The is not a container");
        Reporter.info("Validate there are categories to select");
        Assert.assertTrue(map.thereIsACategoriesList(), "Empty List");
        Reporter.info("Validate Hotels button");
        Assert.assertTrue(map.hotelsButtonIsDisplayed(), "Hotels button not displayed");
    }
}
