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

public class CartPage {
    private WebDriver driver;
    private PerformActions performActions;
    public String ExceptedProductName;
    public List<String> exceptedAddCartitems;


    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        performActions = new PerformActions(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));

    }

    @FindBy(xpath = "//tr[@class='item-info ']/td//div/strong/a")
    private List<WebElement> AddCartProductnames;
    @FindBy(xpath = "//ul[@class='actions']/li[@class='action-delete']")
    private List<WebElement> cartProductremove;
    @FindBy(xpath = "//ul[@class='unstyled top-nav']/li/a")
    private static WebElement myAccountLink;
    @FindBy(xpath = "//ul[@class='top-subnav__items']/li/a[text()='Log out']")
    private static WebElement logOutLink;


    public void checkout () {
        exceptedAddCartitems = new ArrayList<>();
        for (WebElement element : AddCartProductnames) {
            ExceptedProductName = element.getText();
            exceptedAddCartitems.add(ExceptedProductName);

        }
        Collections.sort(exceptedAddCartitems);
        System.out.println("excepted array2" + exceptedAddCartitems);
    }
    public void logout () {
        performActions.clickOnElement(myAccountLink);
        performActions.clickElementWithActions(logOutLink);
    }
    public void removeCartProducts() {
        for (WebElement element : cartProductremove) {
            performActions.clickElementWithActions(element);
            try {
                Thread.sleep(8000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

}






