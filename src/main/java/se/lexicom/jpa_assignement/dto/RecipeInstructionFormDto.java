package se.lexicom.jpa_assignement.dto;

public class RecipeInstructionFormDto {

    private String recipeInstructions;

    //Constructors
    public RecipeInstructionFormDto() {
    }

    public RecipeInstructionFormDto(String recipeInstructions) {
        this.recipeInstructions = recipeInstructions;
    }

    //Getters and Setters
    public String getRecipeInstructions() {
        return recipeInstructions;
    }

    public void setRecipeInstructions(String recipeInstructions) {
        this.recipeInstructions = recipeInstructions;
    }

}
