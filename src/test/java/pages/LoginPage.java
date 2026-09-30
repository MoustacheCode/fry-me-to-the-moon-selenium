package pages;

import config.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    private final By usernameInput = By.id("id_username");
    private final By passwordInput = By.id("id_password");
    private final By loginButton = By.cssSelector("button.btn-register");
    private final By error = By.cssSelector("ul.errorlist.nonfield li");

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public void attemptLoginAs(String username, String password) {
        this.type(this.usernameInput, username);
        this.type(this.passwordInput, password);
        this.click(this.loginButton);
    }

    public HomePage successfullyLogin() {
        this.type(this.usernameInput, ConfigReader.standardUsername());
        this.type(this.passwordInput, ConfigReader.standardPassword());
        this.click(this.loginButton);
        return new HomePage(driver);
    }

    public String getErrorMessage() {
        return this.textOf(this.error);
    }




}


