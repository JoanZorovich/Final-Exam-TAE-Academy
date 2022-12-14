package org.webAndMobile.tests.stepsDefinitions.web;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.webAndMobile.pageObjects.pages.HomePage;
import org.webAndMobile.pageObjects.pages.WatchPage;
import org.webAndMobile.tests.stepsDefinitions.web.WebHooks;
import org.webAndMobile.utils.reporting.Reporter;

public class WebSteps {

    private HomePage home;
    private WatchPage watchPage;

    private final String USER_NAME = "Joan!";
    private final String WELCOME_MESSAGE = "Welcome!";

    private static String EMAIL;

    @Given("User is on the ESPN home page")
    public void userIsOnTheESPNHomePage() {
        home = new HomePage(WebHooks.getDriver());
        Reporter.info("Validate main content in home page");
        Assert.assertTrue(home.isMainContentDisplayed(), "Main content is not displayed");
        Reporter.info("Navbar is displayed");
        Assert.assertTrue(home.isNavbarDisplayed(), "Navbar is not displayed");
    }

    @When("User goes to the login form to access to sign-up button")
    public void userGoesToTheLoginFormToAccessToSignUpButton() {
        home.placeMouseOverProfileLogo();
        Reporter.info("Validate profile Menu is displayed");
        Assert.assertTrue(home.isMainContentDisplayed(), "profile Menu is not displayed");
        home.clickOnLoginLink();

        home.switchToIframeForm();
        Reporter.info("----Validate log in modal is present----");
        Reporter.info("ESPN logo is displayed");
        Assert.assertTrue(home.isESPNFormLogoDisplayed(), "ESPN logo is not displayed");
        Reporter.info("Log In Button is displayed");
        Assert.assertTrue(home.isSubmitButtonDisplayed(), "Log In Button is not displayed");
        Reporter.info("Sign Up Button is displayed");
        Assert.assertTrue(home.isSignUpButtonDisplayed(), "Sign Up Button is not displayed");
        home.clickSignUpButton();

    }
    @And("Fill the sign up form successfully {string} {string} {string}")
    public void fillTheSignUpFormSuccessfully(String firstName, String lastName, String password) {
        Reporter.info("----Validate Sign Up modal is present----");
        Reporter.info("Sign Up title is displayed");
        Assert.assertTrue(home.isSignUpTitleDisplayed(), "Sign Up title is not displayed");
        Reporter.info("Fist Name input is present");
        Assert.assertTrue(home.isFirstNameInputDisplayed(), "Fist Name input is not present");
        Reporter.info("Last Name input is present");
        Assert.assertTrue(home.isLastNameInputDisplayed(), "Fist Name input is not present");
        Reporter.info("Email input is present");
        Assert.assertTrue(home.isEmailInputDisplayed(), "Fist Name input is not present");
        Reporter.info("Password input is present");
        Assert.assertTrue(home.isPasswordInputDisplayed(), "Fist Name input is not present");
        Reporter.info("Sign Up Button is displayed");
        Assert.assertTrue(home.isSubmitButtonDisplayed(), "Sign Up Button is not displayed");
        Reporter.info("Close Button is displayed");
        Assert.assertTrue(home.isCloseButtonDisplayed(), "Close Button is not displayed");
        EMAIL = home.getRandomEmail();
        home.typeSignUpInfo(firstName,lastName,EMAIL,password);
        home.clickOnSubmitButton();
    }
    @Then("Watch page should displays different carousels")
    public void watchPageShouldDisplaysDifferentCarousels() {
        Reporter.info("----Validate Watch Page Navigation----");
        watchPage = home.goToWatchPage();
        Reporter.info("There is at least one carousel on the Page");
        Assert.assertTrue(watchPage.thereIsACarousel(), "There is no carousel");
        Reporter.info("Each card in the first carousel has a title");
        Assert.assertTrue(watchPage.getCardsTitle(), "Not all cards have a title");
        Reporter.info("Each card in the first carousel has a Description");
        Assert.assertTrue(watchPage.getCardsDescription(), "Not all cards have a Description");
        watchPage.clickOnSecondCard();
        Reporter.info("Light Box is displayed");
        Assert.assertTrue(watchPage.isAContentBoxDisplayed(), "Light Box is not displayed");
        Reporter.info("Close light Box button is displayed");
        Assert.assertTrue(watchPage.isCloseLightBoxButton(), "Close Light Box is not displayed");
        watchPage.clickOnCloseLightBoxButton();
    }
    @And("User returns to home page")
    public void userReturnsToHomePage() {
        Reporter.info("----Return to home page from watch page----");
        watchPage.backToHomePage();
    }
    @And("User logs out from session")
    public void userLogsOutFromSession() {
        Reporter.info("----Validate log out----");
        Reporter.info("Validate if there is a logged in user");
        Assert.assertEquals(home.getUserName(),USER_NAME);
        home.logOutSession();
        Reporter.info("Log Out Link is displayed");
        Assert.assertTrue(home.isLogOutLinkDisplayed(), "Log Out Link is not displayed");
        Reporter.info("The user has logged out successfully");
        Assert.assertEquals(home.getWelcomeMessage(),WELCOME_MESSAGE);
    }
}









