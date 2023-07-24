package main.uiTestData.testBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

abstract public class PageBase {
    protected static WebDriver driver;
    protected static WebDriverWait wait;

    public static void setDriver(WebDriver webDriver, WebDriverWait webDriverWait) {
        driver = webDriver;
        wait = webDriverWait;
    }
}
