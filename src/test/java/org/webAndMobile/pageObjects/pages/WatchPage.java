package org.webAndMobile.pageObjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
/**
 * Class that contains all the web elements and methods of the Watch page
 */
public class WatchPage extends BasePage{

    @FindBy(css= "section.Carousel.relative")
    private List<WebElement> carousels;

    @FindBy(css= "div.Carousel__Wrapper--canScrollRight li")
    private List<WebElement> firstCarouselCards;


    @FindBy(css = "div.Carousel__Wrapper--canScrollRight li:nth-child(2)")
    private WebElement secondCard;

    @FindBy(css = "section.lightbox__contentBox")
    private WebElement lightBox;

    @FindBy(css = "div.lightbox__closebtn__wrap")
    private WebElement closeLightBoxButton;

    /**
     * WatchPage constructor method
     * @param driver web driver
     */
    public WatchPage(WebDriver driver) {
        super(driver);
    }

    public boolean thereIsACarousel(){
        return carousels.size()>0;
    }
    public void clickOnSecondCard(){
        super.clickAnElement(secondCard);
    }
    public boolean isAContentBoxDisplayed(){
        super.waitForVisibility(lightBox);
        return lightBox.isDisplayed();
    }
    public boolean isCloseLightBoxButton(){
        waitForVisibility(closeLightBoxButton);
        return closeLightBoxButton.isDisplayed();
    }
    public void clickOnCloseLightBoxButton(){
        super.clickAnElement(closeLightBoxButton);
    }

    public HomePage backToHomePage(){
        super.backToPage();
        return new HomePage(getDriver());
    }

    public int cardsNumber(){
        return firstCarouselCards.size();
    }

    public boolean getCardsTitle(){
        List<WebElement> titlesList = new ArrayList<>();
        firstCarouselCards.forEach(element -> {
            titlesList.add(element.findElement(By.cssSelector("h2.WatchTile__Title")));
        });
        return titlesList.size() == firstCarouselCards.size();
    }

    public boolean getCardsDescription(){
        List<WebElement> descriptionsList = new ArrayList<>();
        firstCarouselCards.forEach(element -> {
            descriptionsList.add(element.findElement(By.cssSelector("div.WatchTile__Meta")));
        });
        return descriptionsList.size() == firstCarouselCards.size();
    }

}
