package com.learn.Tests;

import com.learn.Base.Base;
import com.learn.Pages.CreateAccountPage;
import com.learn.Pages.GardenPage;
import com.learn.Pages.HomePage;
import com.learn.Pages.WhishlistPage;
import com.learn.Utilities.PerformActions;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class CreateAccountAndWishlist extends Base {
    HomePage homePage;
    CreateAccountPage createAccountPage;
    GardenPage gardenPage;
    WhishlistPage whishlistPage;
    PerformActions performActions;

    @BeforeMethod
    public void intializePages() {
        homePage = new HomePage(driver);
        performActions = new PerformActions(driver);
        createAccountPage = new CreateAccountPage(driver);
        gardenPage = new GardenPage(driver);
        whishlistPage = new WhishlistPage(driver);
    }

    @Test
    public void wishlist(){
        createAccountPage.createAccount();
        createAccountPage.clickSubmit();
        gardenPage.selectsubCategoryGarden();
        gardenPage.addWishlist();
        gardenPage.getWhishListItems();
        homePage.clickMyAccount();
        whishlistPage.whishList();
        Assert.assertEquals(gardenPage.actualWhishlistitems, whishlistPage.exceptedWishlistitems);
        whishlistPage.logOut();
    }

}
