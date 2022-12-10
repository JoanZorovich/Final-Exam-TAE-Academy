package org.webAndMobile.pageObjects.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;


import java.util.List;

import static io.appium.java_client.pagefactory.LocatorGroupStrategy.ALL_POSSIBLE;

// TODO: Auto-generated Javadoc

/**
 * Map screen.
 *
 * @author Hans.Marquez
 */
public class MapScreen extends BaseScreen {

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*categoryTitle\")")
    private AndroidElement categoryListButton;

    @AndroidFindBy(uiAutomator = "UiSelector().resourceIdMatches(\".*facilityTypeTitle\")")
    private List<AndroidElement> categoryList;

    @AndroidFindBy(uiAutomator = "UiSelector().resourceIdMatches(\".*filterDismissLayout\")")
    private AndroidElement categoryListContainer;

    @AndroidFindBy(uiAutomator = "UiSelector().descriptionContains(\"Hotels\")")
    private AndroidElement hotelsButton;

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*filterTitle.*\")")
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Filter\")")
    private AndroidElement filterButton;

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*toggleTitle.*\")")
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Show List\")")
    private AndroidElement showListButton;

    /**
     * Constructor method.
     *
     * @param driver the driver
     * @author Hans.Marquez
     */
    public MapScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    /**
     * @author Hans.Marquez
     * return true if Category List element is displayed in screen, otherwise false.
     */
    public boolean categoryIsDisplayed() {
        return isElementAvailable(categoryListButton);
    }

    /**
     * @author Joan.Zorovich
     * @return display a menu with different categories
     */
    public void clickOnCategoriesButton() {
        categoryListButton.click();
    }

    /**
     * @author Joan.Zorovich
     * @return true if the categories container element is displayed in screen, otherwise false.
     */
    public boolean categoriesContainerIsDisplayed(){
        return isElementAvailable(categoryListContainer);
    }
    /**
     * @author Joan.Zorovich
     * @return true if the categories list is not empty, otherwise false.
     */
    public boolean thereIsACategoriesList(){
        return categoryList.size()>0;
    }

    /**
     * @author Joan.Zorovich
     * @return true if the hotel option element is displayed in screen, otherwise false.
     */

    public boolean hotelsButtonIsDisplayed(){
        return isElementAvailable(hotelsButton);
    }

    /**
     * @author Hans.Marquez
     * return true if Filter Button element is displayed in screen, otherwise false.
     */
    public boolean filterIsDisplayed() {
        return isElementAvailable(filterButton);
    }

    /**
     * @author Hans.Marquez
     * return true if Show List Button element is displayed in screen, otherwise false.
     */
    public boolean showListIsDisplayed() {
        return isElementAvailable(showListButton);
    }

}
