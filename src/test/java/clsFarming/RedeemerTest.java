package clsFarming;

import base.BaseTests;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.MyProductsPage;
import pages.WelcomePage;

@Slf4j
public class RedeemerTest extends BaseTests {
    LoginPage loginPage;
    WelcomePage welcomePage;
    MyAccountPage myAccountPage;
    MyProductsPage myProductsPage;
    @BeforeTest
    public void baseInitialize() {
        loginPage = new LoginPage(webDriver);
        welcomePage = new WelcomePage(webDriver);
        myAccountPage = new MyAccountPage(webDriver);
        myProductsPage = new MyProductsPage(webDriver);
    }
    @Test
    public void redeemerMethod(){
        welcomePage.openWebSite();
        welcomePage.myAccountBtn.click();
        loginPage.loginAction();
        welcomePage.myAccountBtn.click();
        myAccountPage.redeem();
        myProductsPage.redeemAllProducts();

    }
}
