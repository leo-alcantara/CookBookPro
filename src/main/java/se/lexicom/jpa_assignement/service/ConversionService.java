package se.lexicom.jpa_assignement.service;

import org.springframework.stereotype.Component;
import se.lexicom.jpa_assignement.dto.*;
import se.lexicom.jpa_assignement.entity.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class ConversionService {

    //INGREDIENT CONVERTER
    public Ingredient toIngredient(IngredientFormDto formDto) {
        return new Ingredient(0, formDto.getIngredientName());
    }

    public IngredientDto toIngredientDto(Ingredient ingredient) {
        return new IngredientDto(ingredient.getIngredientId(), ingredient.getIngredientName());
    }


    //RECIPE CATEGORY CONVERTER
    public RecipeCategory toRecipeCategory(RecipeCategoryFormDto formDto) {

        //Initiate List of Recipes
        List<Recipe> recipes = new ArrayList<>();

        //convert recipeFormDto from formDto.getRecipes()
        for(RecipeFormDto recipeFormDto : formDto.getRecipes()) {
            recipes.add(toRecipe(recipeFormDto));
        };
        
        return new RecipeCategory(0, formDto.getCategory(), recipes);
    }

    public RecipeCategoryDto toRecipeCategoryDto(RecipeCategory recipeCategory) {
        return toRecipeCategoryDto(recipeCategory, true);
    }

    private RecipeCategoryDto toRecipeCategoryDto(RecipeCategory recipeCategory, boolean convertRecipes) {

        //Initiate List of RecipesDTO
        List<RecipeDto> recipeDtoList = new ArrayList<>();

        //If boolean is true convert Recipes
        if (convertRecipes) {
            for (Recipe recipe : recipeCategory.getRecipes()) {
                recipeDtoList.add(toRecipeDto(recipe));
            }
        }
        
        return new RecipeCategoryDto(recipeCategory.getRecipeCategoryId(), recipeCategory.getCategory(), recipeDtoList);
    }


    //RECIPE INGREDIENT CONVERTER
    public RecipeIngredient toRecipeIngredient(RecipeIngredientFormDto formDto) {

        //Instantiate List of RecipeIngredient to input in recipe, so later we can return RecipeIngredient
        List<RecipeIngredient> recipeIngredients = new ArrayList<>();
        
        //Instantiate RecipeIngredient using conversion methods and add instance to List
        RecipeIngredient recipeIngredient = new RecipeIngredient(toIngredient(formDto.getIngredient()), formDto.getAmount(), formDto.getMeasurement(), toRecipe(formDto.getRecipe()));
        recipeIngredients.add(recipeIngredient);

        //Instantiate Set of RecipeCategory to input in recipe, so later we can return RecipeIngredient
        Set<RecipeCategory> recipeCategories = new HashSet<>();

        //Loop through RecipeCategoryFormDto from formDto.getRecipe().getCategories() and convert to RecipeCategory to add to Set recipeCategories
        for(RecipeCategoryFormDto rcf : formDto.getRecipe().getCategories()) {
            recipeCategories.add(toRecipeCategory(rcf));
        }

        RecipeInstruction recipeInstruction = new RecipeInstruction(formDto.getRecipe().getInstructions());

        Recipe recipe = new Recipe(formDto.getRecipe().getRecipeName(), recipeIngredients, recipeInstruction, recipeCategories);

        Ingredient ingredient = toIngredient(formDto.getIngredient());

        return new RecipeIngredient(0, ingredient, formDto.getAmount(), formDto.getMeasurement(), recipe);
    }

    public RecipeIngredientDto toRecipeIngredientDto(RecipeIngredient recipeIngredient) {
        return new RecipeIngredientDto(recipeIngredient.getRecipeIngredientId(), toIngredientDto(recipeIngredient.getIngredient()), recipeIngredient.getAmount(), recipeIngredient.getMeasurement(), toRecipeDto(recipeIngredient.getRecipe()));
    }


    //RECIPE INSTRUCTION CONVERTER
    public RecipeInstruction toRecipeInstruction(RecipeInstructionFormDto formDto) {
        return new RecipeInstruction(0, formDto.getRecipeInstructions());
    }

    public RecipeInstructionDto toRecipeInstructionDto(RecipeInstruction recipeInstruction) {
        return new RecipeInstructionDto(recipeInstruction.getRecipeInstructionId(), recipeInstruction.getRecipeInstructions());
    }


    //RECIPE CONVERTER
    public Recipe toRecipe(RecipeFormDto formDto) {
        //Extract Instructions from Input parameter.
        RecipeInstruction instruction = new RecipeInstruction(0, formDto.getInstructions());

        //Instantiate Set of RecipeCategory
        Set<RecipeCategory> categories = new HashSet<>();

        //Loop through RecipeCategoryFormDto from formDto.getCategories() and convert to RecipeCategory to add to Set categories
        for(RecipeCategoryFormDto rcf : formDto.getCategories()) {
            categories.add(toRecipeCategory(rcf));
        }
        
        //Instantiate List of RecipeIngredient
        List<RecipeIngredient> recipeIngredientList = new ArrayList<>();

        //Loop through RecipeIngredientFormDto from formDto.getIngredients() and convert to RecipeIngredient to add to List RecipeIngredient
        for (RecipeIngredientFormDto ri : formDto.getIngredients()) {
            recipeIngredientList.add(toRecipeIngredient(ri));
        }

        return new Recipe(formDto.getRecipeName(), recipeIngredientList, instruction, categories);
    }

    public RecipeDto toRecipeDto(Recipe recipe) {

        //Instantiate List RecipeIngredientDto to add converted RecipeIngredientDto fetched from Input Recipe
        List<RecipeIngredientDto> ingredientsDto = new ArrayList<>();

        //Loop through RecipeIngredient from recipe.getIngredients() and convert to RecipeIngredientDto to add to List ingredientsDto
        for (RecipeIngredient ri : recipe.getIngredients()) {
            ingredientsDto.add(toRecipeIngredientDto(ri));
        }

        RecipeInstructionDto recipeInstructionDto = new RecipeInstructionDto(recipe.getInstructions().getRecipeInstructionId(),
                recipe.getInstructions().getRecipeInstructions());
        
        //Instantiate List RecipeCategoryDto to add converted RecipeCategoryDto fetched from Input Recipe
        List<RecipeCategoryDto> recipeCategoryDtoList = new ArrayList<>();

        //Loop through RecipeCategory from recipe.getCategories() and convert to RecipeCategoryDto to add to List recipeCategoryDtoList
        for (RecipeCategory recipeCategory : recipe.getCategories()) {
            recipeCategoryDtoList.add(toRecipeCategoryDto(recipeCategory, false));
        }

        return new RecipeDto(recipe.getRecipeId(), recipe.getRecipeName(), ingredientsDto, recipeInstructionDto, recipeCategoryDtoList);
    }
}
