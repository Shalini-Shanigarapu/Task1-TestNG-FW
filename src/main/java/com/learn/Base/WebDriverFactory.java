package com.learn.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverFactory {
    private WebDriver driver;

    public WebDriverFactory(WebDriver driver){

        this.driver = driver;
    }
    public WebDriver intalizeBrowser(String browser) {
        if(browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("firefox")) {

            driver = new FirefoxDriver();
        }
        else if(browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }
        else if(browser.equalsIgnoreCase("Safari")) {
            driver = new SafariDriver();
        }
        driver.manage().window().maximize();
        return driver;
    }

}
