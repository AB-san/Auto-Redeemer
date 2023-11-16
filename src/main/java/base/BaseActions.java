package base;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

@Slf4j
public class BaseActions {
    static WebDriver webDriver;
    static {
        webDriver = BaseTests.webDriver;
    }
    public static void click(WebElement element) {
        if (element == null) {
            log.info("Failed to find the element to click");
        } else {
            log.info("Clicking : " + element.getText());
            try {
                element.click();
            } catch (Exception e) {
                try{
                    clickUsingJavaScript(webDriver, element);
                }catch (Exception exception){
                    Actions actions = new Actions(webDriver);
                    actions.moveToElement(element).click();
                }
            }
        }
    }

    public static void waitFor300MilliSec() {
        try {
            Thread.sleep(300L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void waitFor700MilliSec() {
        try {
            Thread.sleep(700L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean checkIfElementIsDisplayed(WebElement element) {
        try {
            element.isDisplayed();
                    return true;
        } catch (NoSuchElementException noSuchElementException) {
            return false;
        }
    }

    public static void moveToElement(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public static void waitTill(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    public static void scroll(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void waitUntilElementIsInvisibile(WebDriver webdriver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(webdriver, Duration.ofSeconds(60));
        Boolean elementToBeClickable = wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public static void waitUntilElementIsClickable(WebDriver webdriver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(webdriver, Duration.ofSeconds(60));
        wait.until(elementToBeClickable(element));
    }

    public static void clickUsingJavaScript(WebDriver driverweb, WebElement element) {
        ((JavascriptExecutor) driverweb).executeScript("arguments[0].click();", element);
    }

}

