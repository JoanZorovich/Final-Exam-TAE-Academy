package org.webAndMobile.utils.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.PageFactory.initElements;

public class WebOperations {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final Actions action;

    public WebOperations(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(7L));
        this.action = new Actions(driver);
        initElements(driver, this);
    }

    public WebDriver getDriver() {
        return driver;
    }

    protected Actions getAction() {
        return action;
    }


    public void clickAnElement(WebElement element){
        waitForClickable(element);
        element.click();
    }

    public void placeMouseOverElement(WebElement element){
        waitForVisibility(element);
        action.moveToElement(element).perform();
    }

    public void typeOnInput(WebElement element, String text){
        waitForVisibility(element);
        element.sendKeys(text);
    }

    public void waitForVisibility(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }


    public void waitForClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void switchToIframe(WebElement element){
        getDriver().switchTo().frame(element);
    }

    public void refreshBrowser(){
        driver.navigate().refresh();
    }

    public void backToPage(){
        driver.navigate().back();
    }

    public void waitForElementPresence(String locator, Duration timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(locator)));
    }


}

