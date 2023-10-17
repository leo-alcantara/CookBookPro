package se.lexicom.jpa_assignement.dto;

public class RecipeInstructionDto {

    private int recipeInstructionId;
    private String recipeInstructions;

    //Constructors
    public RecipeInstructionDto() {
    }

    public RecipeInstructionDto(int recipeInstructionId, String recipeInstructions) {
        this.recipeInstructionId = recipeInstructionId;
        this.recipeInstructions = recipeInstructions;
    }

    //Getters and Setters
    public int getRecipeInstructionId() {
        return recipeInstructionId;
    }

    public void setRecipeInstructionId(int recipeInstructionId) {
        this.recipeInstructionId = recipeInstructionId;
    }

    public String getRecipeInstructions() {
        return recipeInstructions;
    }

    public void setRecipeInstructions(String recipeInstructions) {
        this.recipeInstructions = recipeInstructions;
    }

    @Override
    public String toString() {
        return "RecipeInstructionDto{" +
                "recipeInstructionId=" + recipeInstructionId +
                ", recipeInstructions='" + recipeInstructions + '\'' +
                '}';
    }
}
