package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private By usernameInput = By.id("id_username");
    private By passwordInput = By.id("id_password");
    private By loginButton = By.cssSelector("button.btn-register");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public HomePage attemptLoginAs(String username, String password) {
        this.type(this.usernameInput, username);
        this.type(this.passwordInput, password);
        this.click(this.loginButton);
        return new HomePage(driver);
    }
}


