package org.webAndMobile.pageObjects.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;


import java.util.List;

/**
 * Screen that appears when tap the  middle  option in the bottom bar.
 *
 * @author Joan.Zorovich
 */

public class AddPlansScreen extends BaseScreen {

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*actionSheetItemText\")")
    private List<AndroidElement> plansOptionList;

    @AndroidFindBy(uiAutomator = "new UiSelector().descriptionContains(\"Check Dining Availability\")")
    private AndroidElement reserveDiningButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*snowball_header_screen_name\")")
    private AndroidElement checkDiningTitle;

    /**
     * Constructor method for standard screens object.
     *
     * @param driver : AndroidDriver
     * @author Joan.Zorovich
     */
    public AddPlansScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    /**
     * @author Joan.Zorovich
     * @return true if there is a plans option list, otherwise false.
     */
    public boolean plansOptionListIsDisplayed(){
        return plansOptionList.size()>0;
    }


    /**
     * @author Joan.Zorovich
     * @return true if "Check Dining Availability" is listed in the plans, otherwise false.
     */
    public boolean isReserveDiningOptionInTheList(){
        String optionName= "Check Dining Availability";
        return findAListElementName(plansOptionList, optionName);
    }

    /**
     * Display "Check Dining Availability Screen".
     * @author Joan.Zorovich
     */
    public void clickOnReserveDiningButton(){
        click(reserveDiningButton);
    }

    /**
     * @author Joan.Zorovich
     * @return true if "Check Dining Availability" screen is enable, otherwise false.
     */
    public boolean isCheckDiningTitleDisplayed(){
        return checkDiningTitle.isDisplayed();
    }


}
