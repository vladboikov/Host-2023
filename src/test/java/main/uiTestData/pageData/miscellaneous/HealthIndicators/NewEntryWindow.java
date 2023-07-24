package main.uiTestData.pageData.miscellaneous.HealthIndicators;

import main.uiTestData.testBase.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewEntryWindow extends PageBase {

    public NewEntryWindow() {
        PageFactory.initElements(driver, this);
    }

    public NewEntryWindow addNewEntry(int day, String month, String year, String temperature,
                                      String weight, String pressure_1, String pressure_2,
                                      String sugarLevel, String pulse, String mood, String alcoholLevel,
                                      String ambivalence, String healthStatus, String skinCondition) throws InterruptedException {
        calendarInput.click();
        setDate(day, month, year);
        temperatureInput.sendKeys(temperature);
        weightInput.sendKeys(weight);
        pressureInput_1.sendKeys(pressure_1);
        pressureInput_2.sendKeys(pressure_2);
        sugarLevelInput.sendKeys(sugarLevel);
        pulseInput.sendKeys(pulse);
        moodInput.sendKeys(mood);
        alcoholLevelInput.sendKeys(alcoholLevel);
        ambivalenceInput.sendKeys(ambivalence);
        healthStatusInput.sendKeys(healthStatus);
        skinConditionInput.sendKeys(skinCondition);
        submitButton.click();
        return this;
    }

    public void setDate(int day, String month, String year) throws InterruptedException {
        String monthValue = getMonthValueText();
        String yearValue = getYearValueText();

        while (!(monthValue.equals(month) && yearValue.equals(year))) {
            prevButton.click();
            monthValue = getMonthValueText();
            yearValue = getYearValueText();
            Thread.sleep(200);
        }
        calendar_selectDay(day);
    }

    public String getMonthValueText() {
        return monthValue.getText();
    }

    public String  getYearValueText() {
        return yearValue.getText();
    }

    public void calendar_selectDay(int day) {
        driver.findElement(By.xpath(String.format("(//a[contains(@class,'ui-state-default')])[%d]", day))).click();
    }

    @FindBy(xpath = "//span[contains(@class,'ui-datepicker-month')]")
    public WebElement monthValue;

    @FindBy(xpath = "//span[contains(@class,'ui-datepicker-year')]")
    public WebElement yearValue;

    @FindBy(xpath = "//span[contains(@class,'ui-datepicker-prev')]")
    public WebElement prevButton;

    @FindBy(xpath = "//div[@role='dialog']//p-calendar//input")
    public WebElement calendarInput;

    @FindBy(xpath = "//p[text()='Температура']//ancestor::div[@class='ui-g ng-star-inserted']//input")
    public WebElement temperatureInput;

    @FindBy(xpath = "//p[text()='Вес']//ancestor::div[@class='ui-g ng-star-inserted']//input")
    public WebElement weightInput;

    @FindBy(xpath = "//p[text()='Давление']//ancestor::div[@class='ui-g ng-star-inserted']//input[@formcontrolname='1']")
    public WebElement pressureInput_1;

    @FindBy(xpath = "//p[text()='Давление']//ancestor::div[@class='ui-g ng-star-inserted']//input[@formcontrolname='2']")
    public WebElement pressureInput_2;

    @FindBy(xpath = "//p[text()='Уровень сахара в крови']//ancestor::div[@class='ui-g ng-star-inserted']//input")
    public WebElement sugarLevelInput;

    @FindBy(xpath = "//p[text()='Пульс']//ancestor::div[@class='ui-g ng-star-inserted']//input")
    public WebElement pulseInput;

    @FindBy(xpath = "//p[text()='Настроение']//ancestor::div[@class='ui-g ng-star-inserted']//textarea")
    public WebElement moodInput;

    @FindBy(xpath = "//p[text()='Алкоголь в крови']//ancestor::div[@class='ui-g ng-star-inserted']//input")
    public WebElement alcoholLevelInput;

    @FindBy(xpath = "//p[text()='Амбивалентность']//ancestor::div[@class='ui-g ng-star-inserted']//input")
    public WebElement ambivalenceInput;

    @FindBy(xpath = "//p[text()='Общее состояние здоровья']//ancestor::div[@class='ui-g ng-star-inserted']//textarea")
    public WebElement healthStatusInput;

    @FindBy(xpath = "//p[text()='Состояние кожных покровов']//ancestor::div[@class='ui-g ng-star-inserted']//textarea")
    public WebElement skinConditionInput;

    @FindBy(xpath = "//form[contains(@class,'ng-valid')]//button")
    public WebElement submitButton;

    @FindBy(xpath = "//div[contains(@class,'message')]//div[text()='Успешно']/ancestor::p-toastitem")
    public WebElement message_newEntryCreated;
}
