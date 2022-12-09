package org.webAndMobile.pageObjects.pages;

import org.webAndMobile.utils.web.WebOperations;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasePage extends WebOperations {
    @FindBy(id="global-nav")
    private WebElement navbar;


    public BasePage(WebDriver driver) {

        super(driver);
    }
    public boolean isNavbarDisplayed(){
        return navbar.isDisplayed();
    }


}
