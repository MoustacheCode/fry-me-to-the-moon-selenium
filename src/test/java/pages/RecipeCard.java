package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RecipeCard extends BasePage {

    public RecipeCard(WebDriver driver) {
        super(driver);
    }

    private final By editRecipeButton = By.linkText("Edit");
    private final By viewRecipeButton = By.linkText("View");
    private final By deleteRecipeButton = By.linkText("Delete");
    private final By recipeTitle = By.cssSelector("h6.card-title");
    private final By recipeCategory = By.cssSelector("p.card-text");

    public AddRecipePage clickEditRecipeButton() {
        click(editRecipeButton);
        return new AddRecipePage(driver);
    }

    public RecipePage clickViewRecipeButton() {
        click(viewRecipeButton);
        return new RecipePage(driver);
    }

    public DeleteRecipePage clickDeleteRecipeButton() {
        click(deleteRecipeButton);
        return new DeleteRecipePage(driver);
    }

    // Refactored to Stream and List all recipes on the page
    public List<String> getRecipeTitle() {
        return driver.findElements(recipeTitle).stream().map(WebElement::getText).toList();
    }

    // Refactored to return all category results to return as a List
    public List<String> getRecipeCategory() {
        return driver.findElements(recipeCategory).stream().map(WebElement::getText).toList();
    }

}




