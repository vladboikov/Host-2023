package tests.uiTests;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import main.uiTestData.pageData.*;
import main.uiTestData.pageData.miscellaneous.HealthIndicators.HealthIndicatorsTab;
import main.uiTestData.pageData.miscellaneous.HealthIndicators.NewEntryWindow;
import main.uiTestData.testBase.TestBase;
import main.uiTestData.utils.Authorization;
import main.uiTestData.utils.healthIndicators.IndicatorsFilterOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class tests extends TestBase {

    @Test
    @Owner("Влад Б.")
    @Description("Проверка успешкой авторизации")
    public void auth_success() {
        new MainPage()
                .goTo_Auth();

        new SignInPage()
                .signIn(Authorization.USERNAME, Authorization.PASSWORD);

        Assert.assertTrue(new Header().userAccountMenu.isDisplayed(),
                "Неудачная авторизация");
    }

    @Test
    @Owner("Влад")
    @Description("Проверка перехода во вкладку 'Показатели здоровья'")
    public void goToHealthIndicators() {
        new MainPage()
                .auth(Authorization.USERNAME, Authorization.PASSWORD)
                .goTo_HealthIndicatorsTab();

        Assert.assertTrue(new HealthIndicatorsTab().entriesList.size() > 5,
                "Не загрузился список записей");
    }

    @Test
    @Owner("Влад Б.")
    @Description("Проверка создания новой записи")
    public void addNewEntry() throws InterruptedException {
        new MainPage()
                .auth(Authorization.USERNAME, Authorization.PASSWORD)
                .goTo_HealthIndicatorsTab();

        new HealthIndicatorsTab()
                .addNewEntryButton.click();

        // Не нашел, как взаимодействовать с данным календарем через JS, поэтому реализовал так.
        // Данный метод можно еще усовершествовать.
        new NewEntryWindow()
                .addNewEntry(23,
                             "Апрель",
                             "2023",
                             "366",
                             "77",
                             "110",
                             "90",
                             "",
                             "",
                             "",
                             "0",
                             "",
                             "",
                             "");

        Assert.assertTrue(new NewEntryWindow().message_newEntryCreated.isDisplayed());
    }

    @Test
    @Owner("Влад Б.")
    @Description("Проверка работы фильтра в показателях")
    public void setIndicatorFilter() throws InterruptedException {
        String filterOption = IndicatorsFilterOptions.MOOD;

        new MainPage()
                .auth(Authorization.USERNAME, Authorization.PASSWORD)
                .goTo_HealthIndicatorsTab();

        new HealthIndicatorsTab()
                .indicatorFilterMenuClick()
                .selectIndicatorFilterOption(filterOption);

        Assert.assertEquals(new HealthIndicatorsTab().getIndicatorColumnText(), filterOption,
                "Некорректно выставился фильтр в колонке показателей");
    }
}
