package com.learn.Pages;

import com.learn.Utilities.PerformActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WhishlistPage {
    private WebDriver driver;
    private PerformActions performActions;
    public String ExceptedProductName;
    public List<String> exceptedWishlistitems;

    public WhishlistPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        performActions = new PerformActions(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));

    }


    @FindBy(xpath = "//div[contains(@class,'product-det')]/p/span[contains(@class,'product-name')]")
    private List<WebElement> whishlistProductnames;

    @FindBy(xpath = "//ul[@class='unstyled top-nav']/li/a")
    private WebElement myAccountLink;
    @FindBy(xpath = "//ul[@class='top-subnav__items']/li/a[text()='Log out']")
    private WebElement logOutLink;



    public void whishList(){
        exceptedWishlistitems=new ArrayList<>();
        for(WebElement element:whishlistProductnames){
            ExceptedProductName=element.getText();
            exceptedWishlistitems.add(ExceptedProductName);
        }
        Collections.sort(exceptedWishlistitems);
        System.out.println("Excepted WhitelistItems"+ exceptedWishlistitems);
    }
    public void logOut(){
        performActions.clickOnElement(myAccountLink);
        performActions.clickElementWithActions(logOutLink);
    }

}
