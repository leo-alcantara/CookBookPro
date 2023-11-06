package cookBookPro.controller;

import org.springframework.http.ResponseEntity;
import cookBookPro.dto.RecipeCategoryDto;
import cookBookPro.dto.RecipeCategoryFormDto;
import cookBookPro.entity.RecipeCategory;

import java.util.List;

public interface RecipeCategoryController {

    ResponseEntity<RecipeCategoryDto> createRecipeCategory(RecipeCategoryFormDto formDto);

    ResponseEntity<RecipeCategoryDto> findById(Integer recipeCategoryId);

    ResponseEntity<List<RecipeCategoryDto>> findAll();

    ResponseEntity<RecipeCategoryDto> update(RecipeCategoryFormDto formDto);

    ResponseEntity<RecipeCategoryDto> delete(RecipeCategory recipeCategory);

    ResponseEntity<Void> clear();
}
