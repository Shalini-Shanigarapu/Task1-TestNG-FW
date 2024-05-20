package com.learn.Base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.sql.DriverManager;

public class Base {
    protected WebDriver driver;
    WebDriverFactory webDriverFactory;
    @Parameters("browserType")
    @BeforeClass
    public void initialize(String browserType){
        webDriverFactory = new WebDriverFactory(driver);
        driver = webDriverFactory.intalizeBrowser(browserType);

    }
    @Parameters("url")
    @BeforeMethod
    public void launchApplication(String url){
        driver.get(url);



    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }



}
