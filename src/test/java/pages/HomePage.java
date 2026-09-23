package pages;

import config.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    protected final WebDriver driver;
    protected WebDriverWait wait;

    // Locators
    private final By loginButton = By.linkText("Login");
    private final By categoryButton = By.id("category");
    private final By filterButton = By.id("filter-btn");
    private final By addRecipeButton = By.linkText("Add Recipe");
    private final By searchRecipe = By.id("search-query");
    private final By logoutButton = By.linkText("Logout");

    public HomePage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigReader.explicitWait()));

    }
}
