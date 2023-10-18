package se.lexicom.jpa_assignement.dto;

//import se.lexicom.jpa_assignement.dto.RecipeDto;

import java.util.List;

public class RecipeCategoryFormDto {

    private String category;
    //@JsonBackReference
    private List<RecipeFormDto> recipes;


    //Constructors
    public RecipeCategoryFormDto() {
    }

    public RecipeCategoryFormDto(String category) {
        this.category = category;
    }

    public RecipeCategoryFormDto(String category, List<RecipeFormDto> recipes) {
        this.category = category;
        this.recipes = recipes;
    }

    //Getters and Setters
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<RecipeFormDto> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<RecipeFormDto> recipes) {
        this.recipes = recipes;
    }
}
