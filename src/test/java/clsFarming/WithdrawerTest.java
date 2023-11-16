package clsFarming;

import base.BaseTests;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;

public class WithdrawerTest extends BaseTests {
    LoginPage loginPage;
    WelcomePage welcomePage;
    MyAccountPage myAccountPage;
    MyProductsPage myProductsPage;
    WithdrawPage withdrawPage;
    @BeforeTest
    public void baseInitialize() {
        loginPage = new LoginPage(webDriver);
        welcomePage = new WelcomePage(webDriver);
        myAccountPage = new MyAccountPage(webDriver);
        myProductsPage = new MyProductsPage(webDriver);
        withdrawPage = new WithdrawPage(webDriver);
    }

    @Test
    public void withdrawMethod(){
        welcomePage.openWebSite();
        welcomePage.myAccountBtn.click();
        loginPage.loginAction();
        welcomePage.myAccountBtn.click();
        myAccountPage.withdrawFunds();
        withdrawPage.withdrawTotalBalance();
    }
}
