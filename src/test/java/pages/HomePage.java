package pages;

import config.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }


    // Locators
    private final By loginButton = By.cssSelector("a[href='/login/']");
    private final By categoryButton = By.id("category");
    private final By filterButton = By.id("filter-btn");
    private final By addRecipeButton = By.cssSelector("a[href='/recipe/new']");
    private final By searchRecipe = By.id("search-query");
    private final By logoutButton = By.xpath("//button[contains(.,'Logout')]");


    public LoginPage clickLogin() {
        System.out.println(driver.getCurrentUrl());
        click(loginButton);
        return new LoginPage(driver);
    }

    public void clickLogout() {
        click(logoutButton);
    }

    public void searchRecipe(String recipeName) {
        type(searchRecipe, recipeName);
    }

    public void selectCategory(String category) {
        click(categoryButton);
    }

    public void clickFilter() {
        click(filterButton);
    }

    public AddRecipePage clickAddRecipe() {
        click(addRecipeButton);
        return new AddRecipePage(driver);
    }

    public boolean isLoggedIn() {
        return waitForVisible(logoutButton).isDisplayed();
    }




}
