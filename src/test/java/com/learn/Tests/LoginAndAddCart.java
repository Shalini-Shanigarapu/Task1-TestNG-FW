package com.learn.Tests;

import com.learn.Base.Base;
import com.learn.Pages.CartPage;
import com.learn.Pages.CreateAccountPage;
import com.learn.Pages.GardenPage;
import com.learn.Pages.HomePage;
import com.learn.TestData.ExcelTestData;
import com.learn.Utilities.PerformActions;
import org.apache.poi.ss.formula.functions.T;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginAndAddCart extends Base {

    HomePage homePage;
    CreateAccountPage createAccountPage;
    GardenPage gardenPage;
    CartPage cartPage;
    PerformActions performActions;

    @BeforeMethod
    public void intializePages() {
        homePage = new HomePage(driver);
        performActions = new PerformActions(driver);
        createAccountPage = new CreateAccountPage(driver);
        gardenPage = new GardenPage(driver);
        cartPage = new CartPage(driver);


    }
    @Test(dataProvider = "LoginData", dataProviderClass = ExcelTestData.class)
    public void loginCart(String eMail, String pwd) throws InterruptedException {
        homePage.login(eMail, pwd);
        Thread.sleep(5000);
        //homePage.clickBagIcon();
        //cartPage.removeCartProducts();
        gardenPage.selectsubCategoryGarden();
        Thread.sleep(3000);
        gardenPage.addCart();
        gardenPage.getAddcartProductNames();
        gardenPage.clickBagIcon();
        cartPage.checkout();
        Assert.assertEquals(gardenPage.actualAddCartitems,cartPage.exceptedAddCartitems);
        cartPage.logout();











    }
}
