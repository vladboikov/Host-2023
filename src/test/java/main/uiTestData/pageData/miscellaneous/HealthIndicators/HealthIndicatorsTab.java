package main.uiTestData.pageData.miscellaneous.HealthIndicators;

import main.uiTestData.testBase.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HealthIndicatorsTab extends PageBase {

    public HealthIndicatorsTab() {
        PageFactory.initElements(driver, this);
    }

    public void selectIndicatorFilterOption(String option) {
        driver.findElement(By.xpath(String.format("//li[@aria-label='%s']", option))).click();
        new WebDriverWait
                (driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated
                ((By.xpath(String.format("//div[@class='col indicator']/div[text()='%s']", option)))));
    }

    public HealthIndicatorsTab indicatorFilterMenuClick() {
        indicatorFilterMenu.click();
        return this;
    }

    public String getIndicatorColumnText() {
        return indicatorColumn.getText();
    }

    @FindBy(xpath = "//a[text()='Показатели здоровья']")
    public WebElement healthIndicatorsTab;

    @FindBy(xpath = "//div[@class='clearfix td']")
    public List<WebElement> entriesList;

    @FindBy(xpath = "//div[@class='create-block']/a")
    public WebElement addNewEntryButton;

    @FindBy(xpath = "//div[@class='indicator-filter']//div[@aria-haspopup='listbox']")
    public WebElement indicatorFilterMenu;

    @FindBy(xpath = "//div[@class='col indicator']/div[contains(@class,'break-word')]")
    public WebElement indicatorColumn;

    @FindBy(xpath = "(//div[@class='col val']/div[contains(@class,'break-word')])[1]")
    public WebElement firstValueColumn;

    @FindBy(xpath = "//i[contains(@class,'settings')]/ancestor::a")
    public WebElement settingsButton;
}
