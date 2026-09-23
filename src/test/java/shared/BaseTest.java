package shared;

import config.ConfigReader;
import config.WebDriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    protected WebDriver driver;

    public BaseTest() {

    }

    @BeforeEach
    public void setup() {

        this.driver = WebDriverFactory.createDriver(ConfigReader.browser());
        this.driver.get(ConfigReader.baseUrl());

    }

    @AfterEach
    public void teardown() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }
}
