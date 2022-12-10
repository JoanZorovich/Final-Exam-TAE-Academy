package org.webAndMobile.tests.stepsDefinitions.mobile;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.webAndMobile.pageObjects.screens.*;
import org.webAndMobile.utils.reporting.Reporter;


public class MobileSteps {

    private TutorialScreen tutorialScreen;
    private DashBoardScreen dashBoard;
    private MapScreen map;
    private MoreOptionsScreen options;
    private AddPlansScreen plans;
    @Given("User is on Disneyland dashboard screen")
    public void userIsOnDisneylandDashboardScreen() {
        tutorialScreen = new TutorialScreen(MobileHooks.getDriver());
        tutorialScreen.startPermissionsProcess();
        dashBoard = tutorialScreen.shareLocationPermissions();
    }
    @When("User taps the Map Button available e in the bottom bar")
    public void userTapsTheMapButtonAvailableEInTheBottomBar() {
        Reporter.info("----Start navigation to Map Screen -----");
        map = dashBoard.goToMapScreen();
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
    @When("User taps on menu button")
    public void userTapsOnMenuButton() {
        Reporter.info("----Start navigation to More Options Screen -----");
        options = dashBoard.goToMoreOptionsScreen();
        Reporter.info("Swipe action");
        options.swipeUntilPrivacyAndLegalButton();
    }
    @And("Tap on Privacy & legal")
    public void tapOnPrivacyLegal() {
        Reporter.info("Tap on Privacy & legal button");
        options.clickOnPrivacyAndLegal();
    }
    @Then("User can see a list of options")
    public void userCanSeeAListOfOptions() {
        Reporter.info("Valida Privacy & legal Screen");
        Assert.assertTrue(options.privacyAndLegalScreenIsDisplayed(), "P&L Screen not displayed");

        Reporter.info("Required Privacy & Legal options are listed");
        Assert.assertTrue(options.areAllPrivacyAndLegalOptionsInTheList(), "not all P&L options are in the list");
    }

    @When("User taps on  Add Plans Button")
    public void userTapsOnAddPlansButton() {
        Reporter.info("----Start navigation to Plans Screen -----");
        plans = dashBoard.goToAddPlansScreen();
    }

    @Then("User can see the Plan list")
    public void userCanSeeThePlanList() {
        Reporter.info("Add Plans Option List is displayed");
        Assert.assertTrue(plans.plansOptionListIsDisplayed(), "Plans Option List is not displayed");
    }

    @And("Check if the Reserve Dining Option is in the list")
    public void checkIfTheReserveDiningOptionIsInTheList() {
        Reporter.info(" Reserve Dining Option is in the list");
        Assert.assertTrue(plans.isReserveDiningOptionInTheList(), "Reserve dining option is not displayed");

        Reporter.info(" Reserve Dining is enable");
        plans.clickOnReserveDiningButton();
        Assert.assertTrue(plans.isCheckDiningTitleDisplayed(), "Reserve dining Screen is not displayed");
    }
}
