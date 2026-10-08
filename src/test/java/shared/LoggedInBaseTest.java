package shared;

import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import pages.LoginPage;

public class LoggedInBaseTest extends BaseTest {

    @BeforeMethod
    public void loginBeforeTest() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginpage = homePage.clickLogin();
        loginpage.successfullyLogin();
        System.out.println("Pre-Test Login worked");
    }
}
