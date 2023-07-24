package main.uiTestData.pageData;
import main.uiTestData.testBase.PageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends PageBase {

    public SignInPage() {
        PageFactory.initElements(driver, this);
    }

    public void signIn(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        signInButton.click();
    }

    @FindBy(xpath = "//input[@id='username']")
    public WebElement usernameInput;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//input[@id='kc-login']")
    public WebElement signInButton;
}
