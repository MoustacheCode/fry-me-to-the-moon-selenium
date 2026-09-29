package shared;

import config.ConfigReader;
import config.WebDriverFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    protected WebDriver driver;

    public BaseTest() {

    }

    @BeforeMethod
    public void setup() {

        this.driver = WebDriverFactory.createDriver(ConfigReader.browser());
        this.driver.get(ConfigReader.baseUrl());

    }

    @AfterMethod
    public void teardown() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }
}
