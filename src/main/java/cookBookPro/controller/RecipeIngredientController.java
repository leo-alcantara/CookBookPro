package cookBookPro.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import cookBookPro.dto.RecipeIngredientDto;
import cookBookPro.dto.RecipeIngredientFormDto;
import cookBookPro.entity.RecipeIngredient;

import java.util.List;

public interface RecipeIngredientController {

    ResponseEntity<RecipeIngredientDto> createRecipeIngredient(RecipeIngredientFormDto formDto);

    ResponseEntity<RecipeIngredientDto> findById(Integer recipeIngredientId);

    ResponseEntity<List<RecipeIngredientDto>> findAll();

    ResponseEntity<RecipeIngredientDto> update(@RequestBody RecipeIngredientFormDto formDto);

    ResponseEntity<RecipeIngredientDto> delete(RecipeIngredient recipeIngredient);

    ResponseEntity<Void> clear();
}
