package org.webAndMobile.pageObjects.pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class HomePage extends BasePage {

    @FindBy(className = "main-content")
    private WebElement mainContent;
    @FindBy(id = "global-scoreboard")
    private WebElement scoreBoard;
    @FindBy(id = "global-user-trigger")
    private WebElement userProfileLogo;
    @FindBy(className = "global-user")
    private WebElement profileUserMenu;
    @FindBy(css = "li a[tref=\"/members/v3_1/login\"]")
    private WebElement loginLink;
    @FindBy (id = "oneid-iframe")
    private WebElement iframeUserForm;
    @FindBy(id = "logo")
    private WebElement espnFormLogo;
    @FindBy(css = "h2#Title")
    private WebElement signUpTitle;
    @FindBy(id = "InputFirstName")
    private WebElement firstNameInput;
    @FindBy(id = "InputLastName")
    private WebElement lastNameInput;
    @FindBy(id = "InputEmail")
    private WebElement emailInput;
    @FindBy(id = "password-new")
    private WebElement passwordInput;
    @FindBy(id = "close")
    private WebElement closeButton;
    @FindBy(id = "InputLoginValue")
    private WebElement inputUser;
    @FindBy(id = "InputPassword")
    private WebElement inputPassword;
    @FindBy(id = "BtnSubmit")
    private WebElement submitButton;
    @FindBy(id = "BtnCreateAccount")
    private WebElement signUpButton;
    @FindBy(css = "li.display-user>span")
    private WebElement welcomeUser;
    @FindBy(css = "div.global-user li:last-child a.small")
    private WebElement logOutLink;
    @FindBy(css = "li.display-user")
    private WebElement welcomeMessage;
    @FindBy(css = "li a[tref=\"/members/v3_1/modifyAccount\"]")
    private WebElement ESPNProfile;
    @FindBy(id = "AccountDeleteLink")
    private WebElement deleteAccountLink;
    @FindBy (css = ".promo-banner-container iframe")
    private WebElement promoBanner;
    @FindBy (css = "div.PromoBanner__CloseBtn")
    private WebElement closeBanner;
    @FindBy (css = "li.pillar.watch")
    private WebElement watchLink;
    @FindBy(css = "p.text-block.text-left")
    private WebElement textBox;
    @FindBy(id = "TextSuccess")
    private WebElement successDeleteText;
    @FindBy(css = "form.form-section.account-deleted-gating")
    private WebElement accountDeletedMessage;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isMainContentDisplayed(){
       return mainContent.isDisplayed();
    }
    public boolean isScoreBoardDisplayed(){
        return scoreBoard.isDisplayed();
    }
    public boolean isUserProfileLogoDisplayed(){
        return userProfileLogo.isDisplayed();
    }
    public void placeMouseOverProfileLogo(){
        super.placeMouseOverElement(userProfileLogo);
    }
    public boolean isProfileMenuDisplayed(){
        super.waitForVisibility(profileUserMenu);
        return profileUserMenu.isDisplayed();
    }
    public void clickOnLoginLink(){
        super.clickAnElement(loginLink);
    }
    public void switchToIframeForm(){
        super.waitForVisibility(iframeUserForm);
        super.switchToIframe(iframeUserForm);
    }

    public boolean isESPNFormLogoDisplayed(){
        return espnFormLogo.isDisplayed();
    }
    public boolean isSignUpButtonDisplayed(){
        return signUpButton.isDisplayed();
    }
    public void clickSignUpButton(){
        super.clickAnElement(signUpButton);
    }
    public boolean isSubmitButtonDisplayed(){
        return submitButton.isDisplayed();
    }

    public boolean isSignUpTitleDisplayed(){
        return signUpTitle.isDisplayed();
    }
    public boolean isFirstNameInputDisplayed(){
        return firstNameInput.isDisplayed();
    }
    public boolean isLastNameInputDisplayed(){
        return lastNameInput.isDisplayed();
    }
    public boolean isEmailInputDisplayed(){
        return emailInput.isDisplayed();
    }
    public boolean isPasswordInputDisplayed(){
        return passwordInput.isDisplayed();
    }

    public boolean isCloseButtonDisplayed(){
        return closeButton.isDisplayed();
    }


    public void typeSignUpInfo(String firstName, String lastName, String email, String password){
        super.typeOnInput(firstNameInput, firstName);
        super.typeOnInput(lastNameInput, lastName);
        super.typeOnInput(emailInput, email);
        super.typeOnInput(passwordInput, password);
    }
    public void typeLoginInfo(String email, String password){
        super.typeOnInput(inputUser, email);
        super.typeOnInput(inputPassword, password);
        super.clickAnElement(submitButton);
    }
    public String getUserName(){
        super.placeMouseOverElement(userProfileLogo);
        return welcomeUser.getText();
    }
    public WatchPage goToWatchPage(){
        super.clickAnElement(watchLink);
        return new WatchPage(getDriver());
    }
    public boolean isLogOutLinkDisplayed(){
        super.placeMouseOverElement(userProfileLogo);
        return logOutLink.isDisplayed();
    }
    public void logOutSession(){;
        super.placeMouseOverElement(userProfileLogo);
        super.clickAnElement(logOutLink);
    }
    public String getWelcomeMessage(){
        super.refreshBrowser();
        super.placeMouseOverElement(userProfileLogo);
        return welcomeMessage.getText();
    }
    public void doLogin(String email, String password){
        placeMouseOverProfileLogo();
        clickOnLoginLink();
        switchToIframeForm();
        typeLoginInfo(email, password);
    }


    public boolean isESPNProfileLinkDisplayed(){
        placeMouseOverProfileLogo();
        return ESPNProfile.isDisplayed();
    }
    public void clickOnESPNProfileLink(){
        placeMouseOverProfileLogo();
        super.clickAnElement(ESPNProfile);
    }

    public void clickOnDeleteAccountLink(){
        waitForVisibility(deleteAccountLink);
        clickAnElement(deleteAccountLink);
    }

    public void clickOnSubmitButton(){
        super.isElementDisplayed(submitButton,3);
        super.clickAnElement(submitButton);
    }

    public void clickOnDeleteAccountButton(){
        super.waitForVisibility(submitButton);
        super.clickAnElement(submitButton);
    }



    public boolean isTextBoxDisplayed(){
        super.waitForVisibility(textBox);
        return textBox.isDisplayed();
    }

    public boolean isSuccessDeleteTextDisplayed(){
        super.waitForVisibility(successDeleteText);
        return successDeleteText.isDisplayed();
    }

    public boolean isAccountDeletedMessageDisplayed(){
        super.waitForVisibility(accountDeletedMessage);
        return accountDeletedMessage.isDisplayed();
    }

    public void closePromoBanner(){
        if(isPromoBannerDisplayed()){
            super.switchToIframe(promoBanner);
            super.clickAnElement(closeBanner);
        }
    }

    public boolean isPromoBannerDisplayed() {
        boolean banner = false;
        try {
            super.waitForElementPresence(".promo-banner-container iframe", 5);
        } catch (TimeoutException e) {
            banner = true;
        }
        return banner;
    }

}
