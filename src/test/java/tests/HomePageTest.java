package tests;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.Assert;
import pages.*;
import shared.BaseTest;

public class HomePageTest extends BaseTest {
    public HomePageTest() {
    }

    @Test
    public void userCanSearchForRecipe() {
        HomePage homePage = new HomePage(driver);
        homePage.searchRecipe("Honey");
        homePage.clickFilter();
        RecipeCard recipeCard = new RecipeCard(driver);
        // Refactored to return results and make sure at least one of the returned results contains expected result
        Assert.assertTrue(recipeCard.getRecipeTitle().contains("Honey Garlic Chicken Stir-Fry"));
    }


    @Test
    public void userCanSelectCategory() {
        HomePage homePage = new HomePage(driver);
        homePage.selectCategory("Desserts");
        homePage.clickFilter();
        RecipeCard recipeCard = new RecipeCard(driver);
        // Refactored to return all results as a List, and checks all results match expected result
        Assert.assertTrue(recipeCard.getRecipeCategory().stream().allMatch(category -> category.equals("Desserts")));

    }

    @Test
    public void userCanClickAddRecipe() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginpage = homePage.clickLogin();
        homePage = loginpage.successfullyLogin();
        System.out.println(driver.getCurrentUrl());
        homePage.clickAddRecipe();
        AddRecipePage addRecipePage = new AddRecipePage(driver);
        Assert.assertTrue(addRecipePage.isRecipeUrlCorrect());
    }

    @Test
    public void userCanClickLogOut() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginpage = homePage.clickLogin();
        homePage = loginpage.successfullyLogin();
        homePage.clickLogout();
        Assert.assertTrue(homePage.isLoggedOut());
    }
}
