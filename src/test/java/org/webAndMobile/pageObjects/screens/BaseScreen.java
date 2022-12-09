package org.webAndMobile.pageObjects.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.webAndMobile.utils.mobile.MobileOperations;

public class BaseScreen extends MobileOperations {
    public BaseScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }
}
