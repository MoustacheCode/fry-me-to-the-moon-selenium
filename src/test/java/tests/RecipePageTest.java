package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RecipeCard;
import pages.RecipePage;
import shared.BaseTest;

public class RecipePageTest extends BaseTest {
    public RecipePageTest() {

    }

    @Test
    public void userCanViewRecipe() {
        HomePage homePage = new HomePage(driver);
        RecipeCard recipeCard = new RecipeCard(driver);
        recipeCard.clickViewRecipeButton();
        RecipePage recipePage = new RecipePage(driver);
        Assert.assertTrue(recipePage.isTitleDisplayed(), "Failed to navigate to the Recipe: Title not displayed");
    }

    @Test
    public void userCanViewDescription() {
        HomePage homePage = new HomePage(driver);
        RecipeCard recipeCard = new RecipeCard(driver);
        recipeCard.clickViewRecipeButton();
        RecipePage recipePage = new RecipePage(driver);
        Assert.assertTrue(recipePage.isDescriptionDisplayed(), "Failed to navigate to the Recipe: Description not displayed");
    }

    @Test
    public void userCanViewInstructions() {
        HomePage homePage = new HomePage(driver);
        RecipeCard recipeCard = new RecipeCard(driver);
        recipeCard.clickViewRecipeButton();
        RecipePage recipePage = new RecipePage(driver);
        Assert.assertTrue(recipePage.areInstructionsReturned(), "Failed to navigate to the Recipe: Instructions not displayed");
    }

    @Test
    public void userCanViewIngredients() {
        HomePage homePage = new HomePage(driver);
        RecipeCard recipeCard = new RecipeCard(driver);
        recipeCard.clickViewRecipeButton();
        RecipePage recipePage = new RecipePage(driver);
        Assert.assertTrue(recipePage.areIngredientsReturned(), "Failed to navigate to the Recipe: Ingredients not displayed");
    }

    @Test
    public void userCanLeaveComment() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginpage = homePage.clickLogin();
        homePage = loginpage.successfullyLogin();
        RecipeCard recipeCard = new RecipeCard(driver);
        recipeCard.clickViewRecipeButton();
        RecipePage recipePage = new RecipePage(driver);
        recipePage.enterComment("This one is amazing!");
        recipePage = recipePage.clickAddComment();
        Assert.assertTrue(recipePage.isSuccessMessageShown());
    }
}