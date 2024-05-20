package com.learn.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PerformActions {
    private WebDriver driver;
    Actions actions;
    public PerformActions(WebDriver driver){

        this.driver = driver;
    }

    public void clickElementWithActions(WebElement element) {
         actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
    }
    public void clickOnElement(WebElement element){
        element.click();

    }
    public static void typeValues(WebElement element, String text) {
        element.sendKeys(text);
    }
    public void hoverElementWithActions(WebElement element) {
         actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }
    public void scrollToElement(WebElement element)
    {
        actions.scrollToElement(element).build().perform();
    }
}
