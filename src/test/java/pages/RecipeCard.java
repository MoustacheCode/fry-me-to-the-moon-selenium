package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecipeCard extends BasePage {

    public RecipeCard(WebDriver driver) {
        super(driver);
    }

    private final By editRecipeButton = By.linkText("Edit");
    private final By viewRecipeButton = By.linkText("View");
    private final By deleteRecipeButton = By.linkText("Delete");

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

}




