package org.webAndMobile.pageObjects.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;


import java.util.Arrays;
import java.util.List;

/**
 * Screen that appears when tap the first option from right
 * to left in the bottom bar.
 *
 * @author Joan.Zorovich
 */

public class MoreOptionsScreen extends BaseScreen {

    @AndroidFindBy(uiAutomator = "new UiSelector().descriptionContains(\"Tickets and Passes\")")
    private AndroidElement ticketsAndPassesButton;

    @AndroidFindBy(uiAutomator = "UiSelector().descriptionContains(\"Privacy & Legal button\")")
    private AndroidElement privacyAndLegalButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*content\")")
    private List<AndroidElement> categoryList;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*snowball_header_screen_name\")")
    private AndroidElement privacyAndLegalTitleScreen;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*txt_element\")")
    private List<AndroidElement> privacyAndLegalList;

    /**
     * Constructor method for standard screens object.
     *
     * @param driver : AndroidDriver
     * @author Arley.Bolivar, Hans.Marquez
     */
    public MoreOptionsScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    /**
     * Validate if Menu Options is display through the presence of an element
     * @author Joan.Zorovich
     * @return true if tickets And Passes Button is displayed , otherwise false.
     */
    public boolean menuOptionsScreenIsDisplayed(){
        return isElementAvailable(ticketsAndPassesButton);
    }

    /**
     * @author Joan.Zorovich
     * @return true if there is a plans option list, otherwise false.
     */
    public boolean privacyAndLegalButtonIsDisplayed(){
        return isElementAvailable(privacyAndLegalButton);
    }

    /**
     * @author Joan.Zorovich
     * @return true if there is a plans option list, otherwise false.
     */
    public void clickOnPrivacyAndLegal(){
        click(privacyAndLegalButton);
    }

    /**
     *Swipe the screen until find the right element
     * @author Joan.Zorovich
     * @return The screen where the privacy and legal button is displayed.
     */
    public void swipeUntilPrivacyAndLegalButton() {
        do {
            swipeVertical(-0.5f);
        }while (!privacyAndLegalButtonIsDisplayed());
    }

    /**
     * @author Joan.Zorovich
     * @return true if categories list has at least one category, otherwise false.
     */
    public boolean categoryListIsDisplayed(){
        return categoryList.size()>0;
    }

    /**
     * @author Joan.Zorovich
     * @return true if all strings in a list are in a menu
     */
    public boolean areAllElementsInTheList(){
        List<String> elementsToFind =
                Arrays.asList("My Profile","Property Rules","Link to Account","Help","Privacy & Legal");
        return findSomeListElements(categoryList,elementsToFind);
    }

    /**
     * @author Joan.Zorovich
     * @return true if privacyAnd Legal title Screen is displayed, otherwise false.
     */
    public boolean privacyAndLegalScreenIsDisplayed(){
        return isElementAvailable(privacyAndLegalTitleScreen);
    }

    /**
     * @author Joan.Zorovich
     * @return true if all strings in a list are in a menu
     */
    public boolean areAllPrivacyAndLegalOptionsInTheList(){
        List<String> elementsToFind =
                Arrays.asList("Privacy Policy","Terms of use","Supplemental Terms and Conditions"
                        ,"Legal Notices","Property Rules","Electronic Communications Disclosure");
        return findSomeListElements(privacyAndLegalList,elementsToFind);
    }
}
