package cookBookPro.service;

import cookBookPro.dto.RecipeDto;
import cookBookPro.dto.RecipeFormDto;
//import cookBookPro.entity.Recipe;

import java.util.Collection;
import java.util.List;

public interface RecipeService {

    RecipeDto createRecipe(RecipeFormDto formDto);

    RecipeDto findById(Integer recipeId);

    List<RecipeDto> findAll();

    RecipeDto update(RecipeFormDto formDto);

    RecipeDto delete(Integer recipeId);

    void clear();

    List<RecipeDto> findRecipeByNameContainsIgnoreCase(String recipeName);

    List<RecipeDto> findRecipeByIngredientNameContainsIgnoreCase(String ingredientName);

    List<RecipeDto> findRecipeByCategoryContainsIgnoreCase(String categoryName);

    List<RecipeDto> findRecipeSeveralCategories(Collection<String> recipeCategories);
}
