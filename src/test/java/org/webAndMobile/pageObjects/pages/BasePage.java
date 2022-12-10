package org.webAndMobile.pageObjects.pages;

import org.webAndMobile.utils.web.WebOperations;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
/**
 * Base Class for web pages
 */
public class BasePage extends WebOperations {
    @FindBy(id="global-nav")
    private WebElement navbar;

    /**
     * BasePage constructor method
     * @param driver web driver
     */
    public BasePage(WebDriver driver) {
        super(driver);
    }
    public boolean isNavbarDisplayed(){
        return navbar.isDisplayed();
    }


}
