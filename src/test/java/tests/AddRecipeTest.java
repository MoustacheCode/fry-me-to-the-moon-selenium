package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddRecipePage;
import pages.HomePage;
import pages.LoginPage;
import pages.RecipeCard;
import shared.BaseTest;

public class AddRecipeTest extends BaseTest {
    public AddRecipeTest() {

    }

    @Test
    public void userCanCreateRecipe() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginpage = homePage.clickLogin();
        homePage = loginpage.successfullyLogin();
        AddRecipePage addRecipePage = homePage.clickAddRecipe();
        addRecipePage.enterTitle("Rik's Test Recipe");
        addRecipePage.enterDescription("A delicious Test Recipe in under 30 minutes!");
        addRecipePage.enterInstructions("Bake Test in over for 25 minutes");
        addRecipePage.enterIngredients("Add 500g of Test to oven dish");
        addRecipePage.selectCategory("Snacks");
        addRecipePage.enterCookTime(25);
        addRecipePage.saveRecipe();
        RecipeCard recipeCard = new RecipeCard(driver);
        Assert.assertEquals(recipeCard.getRecipeTitle(), "Rik's Test Recipe");

    }

    @Test
    public void userCanCancelRecipe() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginpage = homePage.clickLogin();
        homePage = loginpage.successfullyLogin();
        AddRecipePage addRecipePage = homePage.clickAddRecipe();
        addRecipePage.enterTitle("Rik's Cancel Recipe");
        addRecipePage.enterDescription("A delicious Test Recipe to be cancelled in 2 seconds!");
        addRecipePage.enterInstructions("Turn off the oven");
        addRecipePage.enterIngredients("Throw it all in the bin because we've changed our minds!");
        addRecipePage.selectCategory("Snacks");
        addRecipePage.enterCookTime(25);
        addRecipePage.cancelRecipe();
        HomePage redirectedHomePage = new HomePage(driver);
        Assert.assertTrue(redirectedHomePage.isLoggedIn(), "The user was not redirected back after cancel");
    }

}
