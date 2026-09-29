package tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import pages.HomePage;
import pages.RecipeCard;
import pages.RecipePage;
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

    @Test
    public void userCanViewRecipe() {
        HomePage homePage = new HomePage(driver);
        RecipeCard recipeCard = new RecipeCard(driver);
        recipeCard.clickViewRecipeButton();
        RecipePage recipePage = new RecipePage(driver);
        Assert.assertTrue(recipePage.isTitleDisplayed(), "Failed to navigate to the Recipe: Title not displayed");
    }
}
