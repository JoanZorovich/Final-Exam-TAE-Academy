package org.webAndMobile.utils.mobile;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.support.PageFactory.initElements;

public abstract class MobileOperations {

    /**
     * The driver.
     */
    private final AndroidDriver<AndroidElement> driver;
    private final WebDriverWait wait;
    private final long waitDuration = 10L;

    /**
     * Constructor method for standard screens object.
     *
     * @param driver : AndroidDriver
     * @author Arley.Bolivar, Hans.Marquez
     */

    public MobileOperations(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, waitDuration);
        initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(0)), this);
    }

    public AndroidDriver<AndroidElement> getDriver() {
        return this.driver;
    }

    /**
     * Swipe vertical.
     *
     * @param percentage of swipe
     */
    @SuppressWarnings({"rawtypes", "unused"})
    public void swipeVertical(float percentage) {
        Dimension windowSize = driver.manage().window().getSize();
        int x = windowSize.getWidth()/2;
        int y = windowSize.getHeight()/2;

        TouchAction ta = new TouchAction(driver);
        ta.press(PointOption.point(x,y))
                .waitAction(WaitOptions.waitOptions((Duration.ofMillis(500)) ))
                .moveTo(PointOption.point(x, (int) (y*percentage)))
                .release()
                .perform();
    }


    /**
     * Wrapper for click  event specifying custom wait.
     *
     * @param element : AndroidElement
     * @author Hans.Marquez
     */
    public void click(AndroidElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }


    /**
     * Wrapper for click event.
     *
     * @param element : AndroidElement
     * @author Hans.Marquez
     */
    public void click(AndroidElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }


    /**
     * Wrapper for sendKeys event.
     *
     * @param element   : AndroidElement
     * @param sequence: String
     * @author Hans.Marquez
     */
    public void sendKeys(AndroidElement element, String sequence) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(sequence);
    }

    /**
     * Wrapper for Visibility event.
     *
     * @param element : AndroidElement
     * @author Hans.Marquez
     */
    public boolean isElementAvailable(AndroidElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    /**
     * Wrapper for Visibility event.
     *
     * @param element : AndroidElement
     * @param timeout : int
     * @author Hans.Marquez
     */
    public boolean isElementAvailable(AndroidElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    /**
     *Determines if a particular element is found in a list of elements
     * @param list of android elements
     * @param elementName android element name
     * @return true if the element is in the list otherwise returns false
     */

    public Boolean findAListElementName (List<AndroidElement> list, String elementName){
        List<Boolean> result = new ArrayList<>();
        list.forEach(element -> {
            result.add(element.getText().equalsIgnoreCase(elementName));
        });
        return result.contains(true);
    }

    /**
     * Determines if some elements are found in a list of elements
     * @param listElements list of android elements
     * @param elementsToFind List of android elements
     * @return true if the elements are in the list otherwise returns false
     */

    public Boolean findSomeListElements(List<AndroidElement> listElements, List<String> elementsToFind){
        List<Boolean> result = new ArrayList<>();
        elementsToFind.forEach(element -> {
            result.add(findAListElementName(listElements,element));
        });
        return !result.contains(false);
    }

}
