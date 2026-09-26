package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AddRecipePage extends BasePage {

    private final By titleInput = By.id("id_title");
    private final By descriptionInput = By.id("id_description");
    private final By ingredientsInput = By.id("id_ingredients");
    private final By instructionsInput = By.id("id_steps");
    // private final By imageInput = By.id("id_image");
    private final By categorySelect = By.id("id_category");
    private final By cookTimeInput = By.id("id_cook_time_minutes");
    private final By saveRecipeButton = By.xpath("//button[text()='Save Recipe']");
    private final By cancelRecipeButton = By.cssSelector(".btn-cancel");




    public AddRecipePage(WebDriver driver) {
        super(driver);
    }

    public void enterTitle(String title) {
        type(titleInput, title);
    }

    public void enterDescription(String description) {
        type(descriptionInput, description);
    }

    public void enterIngredients(String ingredients) {
        type(ingredientsInput, ingredients);
    }

    public void enterInstructions(String instructions) {
        type(instructionsInput, instructions);
    }

//    public void enterImage() {
//
//    }

    public void selectCategory(String category) {
        Select categories = new Select(waitForVisible(categorySelect));
        categories.selectByVisibleText(category);
    }

    public void enterCookTime(Integer cookTime) {
        type(cookTimeInput, String.valueOf(cookTime));
    }

    public HomePage saveRecipe() {
        click(this.saveRecipeButton);
        return new HomePage(driver);
    }

    public HomePage cancelRecipe() {
        click(this.cancelRecipeButton);
        return new HomePage(driver);
    }






}


