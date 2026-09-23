package pages;

import config.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    protected final WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigReader.explicitWait()));

    }

    public WebElement waitForVisible(By locator) {

        return (WebElement)this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public List<WebElement> waitForAllVisible(By locator) {

        return this.wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));

    }

    public WebElement waitForClickable(By locator) {

        return (WebElement)this.wait.until(ExpectedConditions.elementToBeClickable(locator));

    }

    public void type(By locator, String inputText) {

        WebElement element = this.waitForVisible(locator);
        element.clear();
        element.sendKeys(inputText);

    }

    public void click(By locator) {

        WebElement element = this.waitForClickable(locator);
        element.click();

    }

    public String textOf(By locator) {

        return this.waitForVisible(locator).getText();

    }

}
