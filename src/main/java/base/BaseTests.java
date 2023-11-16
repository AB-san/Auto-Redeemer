package base;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Slf4j
public class BaseTests {
    public static WebDriver webDriver;
    @BeforeTest
    public void initialize() throws IOException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments( "--enable-automation");
        chromeOptions.addArguments("start-maximized");
        chromeOptions.addArguments("--headless");
        webDriver = new ChromeDriver(chromeOptions);
        Properties properties = new Properties();
        properties.load(new FileInputStream(Paths.CLS_FARMING_PROPERTIES));
    }
    @AfterMethod
    public void terminate(){
        webDriver.close();
    }
}
