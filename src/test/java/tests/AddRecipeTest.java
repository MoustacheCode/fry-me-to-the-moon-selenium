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
}
