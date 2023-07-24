package main.uiTestData.pageData;

import main.uiTestData.testBase.PageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserAccount extends PageBase {

    public UserAccount() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@routerlink='card']")
    public WebElement miscellaneousTab;
}
