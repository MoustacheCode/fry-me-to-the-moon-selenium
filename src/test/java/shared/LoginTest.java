package shared;

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
}
