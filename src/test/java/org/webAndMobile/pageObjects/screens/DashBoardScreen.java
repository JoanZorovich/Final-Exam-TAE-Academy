package org.webAndMobile.pageObjects.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;


/**
 * DashBoard screen.
 *
 * @author Hans.Marquez
 */
public class DashBoardScreen extends BaseScreen {

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*android:id/button2\")")
    private AndroidElement dismissPreferenceUpdateButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*dismiss-icon\")")
    private AndroidElement dismissWelcome;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageView\").descriptionContains(\"Map\")")
    private AndroidElement mapButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().descriptionContains(\"More Options\")")
    private AndroidElement moreOptionsButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().descriptionContains(\"Buy tickets\")")
    private AndroidElement addPlansButton;

    /**
     * Constructor method.
     *
     * @param driver : AndroidDriver
     * @author Hans.Marquez
     */
    public DashBoardScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    /**
     * @author Joan.Zorovich
     *Evaluate whether the welcome and update preferences options are displayed and dismiss them
     */

    public void dismissStartOptions(){
        if (this.isElementAvailable(dismissWelcome, 25)){
            click(dismissWelcome);
        }
        if (this.isElementAvailable(dismissPreferenceUpdateButton, 25)){
            click(dismissPreferenceUpdateButton);
        }
    }


    /**
     * @author Hans.Marquez
     * Navigate to Login Screen from DashBoard Screen.
     */
    public MapScreen goToMapScreen() {
        dismissStartOptions();
        click(mapButton);
        return new MapScreen(getDriver());
    }

    /**
     * @author Joan.Zorovich
     * Navigate from DashBoard Screen to More options Screen.
     */

    public MoreOptionsScreen goToMoreOptionsScreen() {
        dismissStartOptions();
        click(moreOptionsButton);
        return new MoreOptionsScreen(getDriver());
    }

    /**
     * @author Joan.Zorovich
     * Navigate from DashBoard Screen to Add plans.
     */

    public AddPlansScreen goToAddPlansScreen() {
        dismissStartOptions();
        click(addPlansButton);
        return new AddPlansScreen(getDriver());
    }

}
