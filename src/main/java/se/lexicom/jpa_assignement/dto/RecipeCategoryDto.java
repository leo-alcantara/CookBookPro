package se.lexicom.jpa_assignement.dto;

import java.util.List;

public class RecipeCategoryDto {

    private int recipeCategoryId;
    private String category;
    private List<RecipeDto> recipes;

    //Constructors
    public RecipeCategoryDto() {
    }

    public RecipeCategoryDto(int recipeCategoryId, String category, List<RecipeDto> recipes) {
        this.recipeCategoryId = recipeCategoryId;
        this.category = category;
        this.recipes = recipes;
    }

    public RecipeCategoryDto(String category) {
        this.category = category;
    }

    //Getters ans Setters
    public int getRecipeCategoryId() {
        return recipeCategoryId;
    }

    public void setRecipeCategoryId(int recipeCategoryId) {
        this.recipeCategoryId = recipeCategoryId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public List<RecipeDto> getRecipes() {
        return this.recipes;
    }

    public void setRecipes(List<RecipeDto> recipes) {
        this.recipes = recipes;
    }

    @Override
    public String toString() {
        return "RecipeCategoryDto{" +
                "recipeCategoryId=" + recipeCategoryId +
                ", category='" + category + '\'' +
                '}';
    }
}
