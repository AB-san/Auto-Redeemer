package pages.ClsFarming;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Reader;
import base.BaseActions;

import java.util.Properties;

@Slf4j
public class WelcomePage extends BaseActions {
    public WebDriver webDriver;
    public Properties properties;
    public WelcomePage(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
        properties = new Properties();
    }
    @FindBy(xpath = "//*[text()='My']")
    public WebElement myAccountBtn;
    public void openWebSite(){
        webDriver.get(Reader.getProperty("BASE_URL"));
    }
}