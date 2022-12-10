package org.webAndMobile.utils.mobile;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

/**
 * Mobile driver class
 */

public class MobileDriver {
    private final AndroidDriver<AndroidElement> driver;

    /**
     * Constructor method
     * @param driver Mobile driver
     */
    public MobileDriver(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
    }

    /**
     * Allows to get the mobile driver
     * @return Android Driver
     */

    public AndroidDriver<AndroidElement> getDriver() {
        return this.driver;
    }
}
