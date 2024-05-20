package com.learn.Pages;

import com.learn.Utilities.PerformActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;;
    private PerformActions performActions;
    public String actualText;
    public String exceptedText;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        performActions = new PerformActions(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));

    }

    @FindBy(xpath = "//li[@class='top-nav__item customer-account']")
    private WebElement signInlink;
    @FindBy(xpath = "//*[name()='g' and @id='Icon-/-Basket']")
    private WebElement addBagIcon;

    @FindBy(id = "email")
    private WebElement eMailInputFiled;
    @FindBy(id = "pass")
    private WebElement passwordInputFiled;
    @FindBy(xpath = "//button[@id='send3']//span[text()='Sign In']")
    private WebElement siginBtn;
    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement acceptAllbtn;
    @FindBy(xpath = "//ul[@class='unstyled top-nav']/li/a")
    private WebElement myAccountLink;
    @FindBy(xpath = "//ul[@class='top-subnav__items']/li/a[text()='My Favourites']")
    private WebElement myFavourites;
    @FindBy(xpath = "//ul[@class='unstyled top-nav']/li/a")
    private WebElement SignInText;








public void login(String eMail,String pwd){
    performActions.clickOnElement(acceptAllbtn);
    performActions.clickOnElement(signInlink);
    performActions.typeValues(eMailInputFiled,eMail);
    performActions.typeValues(passwordInputFiled,pwd);
    try {
        Thread.sleep(2000);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
    performActions.clickOnElement(siginBtn);

    try {
        Thread.sleep(2000);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
}
public void clickMyAccount(){
    performActions.clickOnElement(myAccountLink);
    performActions.clickElementWithActions(myFavourites);
}
public void getSignInText(){
     actualText = SignInText.getText();
     exceptedText = "Sign In Icon / Sign In";


}
public void clickBagIcon(){

    performActions.clickElementWithActions(addBagIcon);
}






}
