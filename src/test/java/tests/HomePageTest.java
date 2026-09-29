package tests;

import org.junit.jupiter.api.Test;
import org.testng.Assert;
import pages.HomePage;
import shared.BaseTest;

public class HomePageTest extends BaseTest {
    public HomePageTest() {
    }

    @Test
    public void userCanSearchForRecipe() {
        HomePage homePage = new HomePage(driver);
        homePage.searchRecipe("Cheesecake");
        Assert.assertTrue(homePage.recipeExists("Cheesecake");
    }
}
