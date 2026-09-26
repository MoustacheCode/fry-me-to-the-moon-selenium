package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeleteRecipePage extends BasePage {

    private final By deleteButton = By.cssSelector(".btn-delete");
    private final By cancelButton = By.cssSelector(".btn-cancel");

    public DeleteRecipePage(WebDriver driver) {
        super(driver);
    }

    public HomePage clickYesToDelete() {
        this.click(deleteButton);
        return new HomePage(driver);
    }

    public RecipePage clickCancel() {
        this.click(cancelButton);
        return new RecipePage(driver);
    }
}
