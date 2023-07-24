package main.uiTestData.pageData;

import main.uiTestData.testBase.PageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header extends PageBase {

    public Header() {
        PageFactory.initElements(driver, this);
    }

    public Header open_userAccountMenu() {
        userAccountMenu.click();
        return this;
    }

    @FindBy(xpath = "//a[@data-testid='signInBtn']")
    public WebElement signInButton;

    @FindBy(xpath = "//div[contains(@class,'login-menu-block')]//app-dropdown[@class='long']//a")
    public WebElement userAccountMenu;

    @FindBy(xpath = "//span[text()='Личный кабинет']/ancestor::a")
    public WebElement userAccount_DropDownMenu;
}
