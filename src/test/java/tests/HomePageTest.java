package tests;

import org.junit.jupiter.api.Test;
import org.testng.Assert;
import pages.HomePage;
import pages.RecipeCard;
import shared.BaseTest;

public class HomePageTest extends BaseTest {
    public HomePageTest() {
    }

    @Test
    public void userCanSearchForRecipe() {
        HomePage homePage = new HomePage(driver);
        homePage.searchRecipe("Cheesecake");
        RecipeCard recipeCard = new RecipeCard(driver);
        Assert.assertEquals(recipeCard.getRecipeTitle(), "Smooth Vanilla Cheesecake");
    }

    @Test
    public void userCanSelectCategory() {
        HomePage homePage = new HomePage(driver);
        homePage.selectCategory("Desserts");
        homePage.clickFilter();
        RecipeCard recipeCard = new RecipeCard(driver);
        Assert.assertEquals(recipeCard.getRecipeCategory(), "Desserts");

    }
}
