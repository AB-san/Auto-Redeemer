package pages.ClsFarming;

import base.BaseActions;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Slf4j
public class MyProductsPage extends BaseActions {
    public WebDriver webDriver;
    public MyProductsPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//*[@class='receive' and normalize-space() = 'get']")
    public List<WebElement> getButtons;

    @FindBy(xpath = "//span[contains(@class,'button') and text()='Ok']")
    public WebElement okayPopup;

    @FindBy(xpath = "//*[contains(@class,'arrow-back')]")
    public WebElement backButton;

    public void redeemAllProducts(){
        log.info(String.valueOf(getButtons.size()));
        getButtons.forEach(button -> {
            click(button);
            waitFor300MilliSec();
            click(okayPopup);
        });
    }
    public void goBackToAccountsPage(){
        click(backButton);
        waitFor700MilliSec();
    }
}
