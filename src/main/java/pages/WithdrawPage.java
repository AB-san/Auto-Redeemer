package pages;

import base.BaseActions;
import base.Paths;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.Reader;

public class WithdrawPage extends BaseActions {
    public WebDriver webDriver;
    public WithdrawPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//p[normalize-space()='Total balance']/preceding-sibling::div")
    public WebElement totalBalance;

    @FindBy(xpath = "//input[@name='money']")
    public WebElement withdrawAmtInputField;

    @FindBy(xpath = "//input[@name='paypassword']")
    public WebElement withdrawPwdInputField;

    @FindBy(xpath = "//button[@type='button' and normalize-space()='Withdraw']")
    public WebElement withdrawButton;

    @FindBy(xpath = "//span[contains(@class,'button') and text()='Ok']")
    public WebElement okayPopup;

    @FindBy(xpath = "//div[contains(text(),'successful')]")
    public WebElement successPopup;

    public String getTotalBalance(){
        String balance = totalBalance.getText();
        return balance.substring(0, balance.indexOf("Rs"));
    }

    public void withdrawTotalBalance(){
        withdrawAmtInputField.sendKeys("1000");
        waitFor700MilliSec();
        withdrawPwdInputField.sendKeys(Reader.getProperty("LOGIN_WITHDRAW_PASSWORD"));
        waitFor700MilliSec();
        click(withdrawButton);
        Assert.assertTrue(checkIfElementIsDisplayed(successPopup),"Withdraw unsuccessful");
        click(okayPopup);
    }

}
