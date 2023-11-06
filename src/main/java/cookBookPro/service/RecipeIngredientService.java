package cookBookPro.service;

import cookBookPro.dto.RecipeIngredientDto;
import cookBookPro.dto.RecipeIngredientFormDto;
import cookBookPro.entity.RecipeIngredient;

import java.util.List;

public interface RecipeIngredientService {

    RecipeIngredientDto createRecipeIngredient(RecipeIngredientFormDto formDto);

    RecipeIngredientDto findById(Integer recipeIngredientId);

    List<RecipeIngredientDto> findAll();

    RecipeIngredientDto update(RecipeIngredientFormDto formDto);

    RecipeIngredientDto delete(RecipeIngredient recipeIngredient);

    void clear();
}
