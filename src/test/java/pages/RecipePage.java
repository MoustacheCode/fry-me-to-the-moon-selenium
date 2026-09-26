package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RecipePage extends BasePage {

    private final By recipeTitle = By.cssSelector("h1.recipe-title");
    private final By recipeDescription = By.cssSelector("p.recipe-description");
    private final By recipeIngredients = By.cssSelector("ul.ingredients li");
    private final By recipeInstructions = By.cssSelector("ol.instructions li");
    private final By commentInput = By.id("comment-box");
    private final By addCommentButton = By.cssSelector("button.btn.btn-primary.btn-sm");
    private final By successMessage = By.cssSelector("div.alert.alert-success");

    public RecipePage(WebDriver driver) {
        super(driver);
    }

    public boolean isTitleDisplayed() {
        return this.waitForVisible(recipeTitle).isDisplayed();
    }

    public boolean isDescriptionDisplayed() {
        return this.waitForVisible(recipeDescription).isDisplayed();
    }

    public boolean areIngredientsReturned() {
        List<WebElement> elements = this.waitForAllVisible(recipeIngredients);
        return !elements.isEmpty();

    }

    public boolean areInstructionsReturned() {
        List<WebElement> elements = this.waitForAllVisible(recipeInstructions);
        return !elements.isEmpty();
    }

    public void enterComment(String commentText) {
        WebElement inputField = this.waitForVisible(commentInput);
        inputField.clear();
        inputField.sendKeys(commentText);
    }

    public RecipePage clickAddComment() {
        this.click(addCommentButton);
        return new RecipePage(driver);
    }

    public boolean isSuccessMessageShown() {
        return this.waitForVisible(successMessage).isDisplayed();
    }

}
