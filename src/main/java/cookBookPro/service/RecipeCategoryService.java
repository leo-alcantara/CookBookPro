package cookBookPro.service;

import cookBookPro.dto.RecipeCategoryDto;
import cookBookPro.dto.RecipeCategoryFormDto;
import cookBookPro.entity.RecipeCategory;

import java.util.List;

public interface RecipeCategoryService {

    RecipeCategoryDto createRecipeCategory(RecipeCategoryFormDto form);

    RecipeCategoryDto findById(Integer recipeCategoryId);

    List<RecipeCategoryDto> findAll();

    RecipeCategoryDto update(RecipeCategoryFormDto formDto);

    RecipeCategoryDto delete(RecipeCategory recipeCategory);

    void clear();
}
