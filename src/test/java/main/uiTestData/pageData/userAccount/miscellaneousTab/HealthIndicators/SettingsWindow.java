package main.uiTestData.pageData.userAccount.miscellaneousTab.HealthIndicators;

import main.uiTestData.testBase.PageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SettingsWindow extends PageBase {

    public SettingsWindow() {
        PageFactory.initElements(driver, this);
    }

    public SettingsWindow setLimits(String minTemperature, String maxTemperature) {
        setMinTemperature(minTemperature);
        setMaxTemperature(maxTemperature);
        submitButton.click();
        return this;
    }

    public void setMinTemperature(String min) {
        minTemperatureInput.clear();
        minTemperatureInput.sendKeys(min);
    }

    public void setMaxTemperature(String max) {
        maxTemperatureInput.clear();
        maxTemperatureInput.sendKeys(max);
    }

    @FindBy(xpath = "//p[text()='Температура']//parent::div//parent::div//input[@formcontrolname='min']")
    public WebElement minTemperatureInput;

    @FindBy(xpath = "//p[text()='Температура']//parent::div//parent::div//input[@formcontrolname='max']")
    public WebElement maxTemperatureInput;

    @FindBy(xpath = "//form[contains(@class,'ng-valid')]//button")
    public WebElement submitButton;
}
