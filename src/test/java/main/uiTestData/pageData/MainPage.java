package main.uiTestData.pageData;

import main.uiTestData.pageData.userAccount.miscellaneousTab.HealthIndicators.HealthIndicatorsTab;
import main.uiTestData.pageData.userAccount.UserAccount;
import main.uiTestData.testBase.PageBase;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends PageBase {

    public MainPage() {
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.navigate().to(config.url());
    }

    public void goTo_Auth() {
        open();
        new Header().signInButton.click();
    }

    public void goTo_HealthIndicatorsTab() {
        new Header()
                .open_userAccountMenu()
                .userAccount_DropDownMenu.click();
        new UserAccount()
                .miscellaneousTab.click();
        new HealthIndicatorsTab()
                .healthIndicatorsTab.click();
    }

    public MainPage auth(String username, String password) {
        open();
        new Header().signInButton.click();
        var auth = new SignInPage();
        auth.usernameInput.sendKeys(username);
        auth.passwordInput.sendKeys(password);
        auth.signInButton.click();
        return this;
    }
}
