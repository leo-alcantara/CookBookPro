package se.lexicom.jpa_assignement.dto;

public class IngredientFormDto {


    private String ingredientName;

    //Constructors
    public IngredientFormDto() {
    }

    public IngredientFormDto(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    //Getters and Setters
    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }
}
