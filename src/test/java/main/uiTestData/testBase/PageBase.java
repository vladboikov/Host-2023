package main.uiTestData.testBase;

import main.uiTestData.utils.owner.FrameworkConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

abstract public class PageBase {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    public static FrameworkConfig config = ConfigFactory.create(FrameworkConfig.class);

    public static void setDriver(WebDriver webDriver, WebDriverWait webDriverWait) {
        driver = webDriver;
        wait = webDriverWait;
    }
}
