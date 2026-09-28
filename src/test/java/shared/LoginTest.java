package shared;

import config.ConfigReader;
import org.junit.jupiter.api.Test;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    public LoginTest() {
    }

    @Test
    public void validDetailsLoginSuccessfully() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginpage = homePage.clickLogin();
        homePage = loginpage.successfullyLogin();
        Assert.assertTrue(homePage.isLoggedIn());
    }

    @Test
    public void incorrectDetailsShowsError() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickLogin();
        loginPage.attemptLoginAs("Rik", "INVALID PASSWORD");
        String errorMessage = loginPage.getErrorMessage();

        String expectedErrorMessage = "Please enter a correct username and password. Note that both fields may be case-sensitive.";
        Assert.assertEquals(errorMessage, expectedErrorMessage);

    }
}
