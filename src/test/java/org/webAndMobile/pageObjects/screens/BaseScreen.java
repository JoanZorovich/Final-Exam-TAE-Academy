package org.webAndMobile.pageObjects.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.webAndMobile.utils.mobile.MobileOperations;

/**
 * Base Class for mobile screens
 */
public class BaseScreen extends MobileOperations {
    /**
     * BaseScreen constructor method
     * @param driver android driver
     */
    public BaseScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }
}
