package com.learn.Pages;

import com.learn.Utilities.PerformActions;
import net.bytebuddy.utility.RandomString;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.Random;

public class CreateAccountPage {
    private WebDriver driver;
    private PerformActions performActions;

    public CreateAccountPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        performActions = new PerformActions(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));

    }

    @FindBy(xpath = "//li[@class='top-nav__item customer-account']")
    private WebElement signInlink;
    @FindBy(id = "onetrust-reject-all-handler")
    private WebElement rejectCookiesBtn;
    @FindBy(xpath = "//a[text()='Create an Account']")
    private WebElement createAnAccountBtn;
    @FindBy(id = "firstname")
    private WebElement firstNameInputFiled;
    @FindBy(id = "lastname")
    private WebElement lastNameInputFiled;
    @FindBy(id = "email_address")
    private WebElement emailInputFiled;
    @FindBy(id = "password")
    private WebElement passwordInputFiled;
    @FindBy(id = "password-confirmation")
    private WebElement confirmpwdInputFiled;
    @FindBy(xpath = "//span[text()='Submit']")
    private WebElement submitBtn;







    public void setFnLn() {
        String randomfn = RandomString.make();
        String firstName = randomfn;
        firstNameInputFiled.sendKeys(firstName);
        String randomln = RandomString.make();
        String lastName = randomln;
        lastNameInputFiled.sendKeys(lastName);
    }
    public void setEmail() {
        String randomMail = RandomString.make();
        String email = randomMail+"@yopmail.com";
        System.out.println(email);
        emailInputFiled.sendKeys(email);

    }
    public void enterPasswordConfirmPwd() {
        String upper = "ABCDEFGHIJKLMNOPQRSTUVXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String splCharacters = "<>~!@#$%^&*)=_+-}]{[/?.,(";
        String combination = upper + lower + numbers + splCharacters;
        int length = 10;
        char[] password = new char[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            password[i] = combination.charAt(random.nextInt(combination.length()));
        }
        System.out.println("Random Generated Password: " + new String(password));
        WebElement RandomPassword = passwordInputFiled;
        RandomPassword.sendKeys(new String(password));
        System.out.println(new String(password));
        confirmpwdInputFiled.sendKeys(new String(password));


    }
    public void createAccount(){
        performActions.clickElementWithActions(rejectCookiesBtn);
        performActions.clickOnElement(signInlink);
        performActions.clickOnElement(createAnAccountBtn);
        setFnLn();
        setEmail();
        enterPasswordConfirmPwd();
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void clickSubmit(){
        performActions.clickOnElement(submitBtn);

    }
}
