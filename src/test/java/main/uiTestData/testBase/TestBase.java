package main.uiTestData.testBase;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import static utils.ChromeUtils.destroyChrome;

public class TestBase {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    public static String initialWindow;

    @BeforeMethod
    public void setUp() {
        destroyChrome(); //продублирован kill хромпроцесса в начале, т.к. иногда с этим возникали проблемы и процессы копились, нагружая машину
        var options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("enable-automation");
        options.addArguments("--no-sandbox");
        options.addArguments("disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");
//        options.addArguments("--headless=new");
        options.addArguments("disable-infobars");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("disable-browser-side-navigation");
        options.addArguments("disable-gpu");
        driver = new ChromeDriver(options);

        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.IGNORE);
        initialWindow = driver.getWindowHandle();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        PageBase.setDriver(driver, wait);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
        destroyChrome();
    }
}
