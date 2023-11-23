package pages.ClsFarming;

import base.BaseActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage extends BaseActions {
    public WebDriver webDriver;
    public MyAccountPage(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    @FindBy(xpath = "//strong[normalize-space()='My Order']")
    public WebElement myOrderButton;

    @FindBy(xpath = "//h2[normalize-space()='Withdraw']")
    public WebElement withdrawButton;

    public void redeem(){
        click(myOrderButton);
        waitFor700MilliSec();
    }

    public void withdrawFunds() {
        click(withdrawButton);
    }
}
