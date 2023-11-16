package pages;
import lombok.extern.slf4j.Slf4j;
import base.BaseActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.Reader;

@Slf4j
public class LoginPage extends BaseActions {
    public WebDriver webDriver;
    public LoginPage(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    @FindBy(xpath = "//input[@name='account']")
    public WebElement userNameInputField;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordInputField;

    @FindBy(xpath = "//button[@type='button']")
    public WebElement loginButton;

    @FindBy(xpath = "//div[contains(text(),'successful')]")
    public WebElement successPopup;

    @FindBy(xpath = "//span[contains(@class,'button') and text()='Ok']")
    public WebElement okayPopup;

    public void loginAction(){
        userNameInputField.sendKeys(Reader.getProperty("LOGIN_USER_ID"));
        passwordInputField.sendKeys(Reader.getProperty("LOGIN_PASSWORD"));
        click(loginButton);
        waitFor300MilliSec();
        Assert.assertTrue(checkIfElementIsDisplayed(successPopup),"Log in unsuccessful");
        click(okayPopup);
    }

}
