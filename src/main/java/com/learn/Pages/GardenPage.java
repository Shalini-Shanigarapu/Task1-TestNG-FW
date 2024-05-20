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

public class GardenPage {
    private WebDriver driver;
        private PerformActions performActions;
    public String acutualProductName;
    public List<String> actualWhishlistitems;
    public List<String> actualAddCartitems;

    public GardenPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        performActions = new PerformActions(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));

    }

    @FindBy(xpath = "//ul[@class='main_menu__list']//a[text()='Garden']")
    private WebElement gardenLink;
    @FindBy(xpath = "//a[text()='Seeds & Bulbs']")
    private WebElement subCategoryGardenSeed;
    @FindBy(css = "[class='total-count-product']")
    private static WebElement numofproductsList;
    @FindBy(xpath = "(//span[text()='Add'])[1]")
    private static WebElement numofproductsListscroll;
    @FindBy(xpath = "//div[@class='price-tag-block']//div/a")
    private static List<WebElement> numofproductswhishlist;

    @FindBy(xpath = "//a[@class='action towishlist addtowish fav']/ancestor::div[@class='price-tag-block']/following-sibling::div//a")
    private static List<WebElement> numofProductNames;

    @FindBy(xpath = "//div[@class='product-add-info']/div/following::form")
    private static List<WebElement> listofProductstoAdd;
    @FindBy(xpath = "//*[name()='g' and @id='Icon-/-Basket']")
    private WebElement addBagIcon;

    @FindBy(xpath = "//div[@class='tocart-qty']//parent::form//parent::div//preceding-sibling::span/a")
    private List<WebElement> numofProducttoAddart;



    public void selectsubCategoryGarden(){
        performActions.hoverElementWithActions(gardenLink);
        performActions.clickElementWithActions(subCategoryGardenSeed);
        performActions.scrollToElement(numofproductsListscroll);

    }
    public void addWishlist() {
        int count = 3;
        for (WebElement element : numofproductswhishlist) {
            performActions.clickElementWithActions(element);
            count--;
            if (count == 0) {
                break;
            }
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void getWhishListItems(){
        actualWhishlistitems = new ArrayList<>();
        for (WebElement element:numofProductNames) {
            acutualProductName = element.getText();
            actualWhishlistitems.add(acutualProductName);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        Collections.sort(actualWhishlistitems);
        System.out.println("Actual WishlistItems"+actualWhishlistitems);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    public void addCart(){
        int count = 3;
        for (WebElement element : listofProductstoAdd) {
            performActions.clickElementWithActions(element);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            count--;
            if (count == 0) {
                break;
            }
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    public void getAddcartProductNames(){
        int count = 3;
        actualAddCartitems = new ArrayList<>();
        for (WebElement element:numofProducttoAddart) {
            acutualProductName = element.getText();
            actualAddCartitems.add(acutualProductName);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            count--;
            if (count == 0) {
                break;
            }
        }
        Collections.sort(actualAddCartitems);
        System.out.println("actual array1"+actualAddCartitems);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    public void clickBagIcon(){
        performActions.clickElementWithActions(addBagIcon);
    }


}

