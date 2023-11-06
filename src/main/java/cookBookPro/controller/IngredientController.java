package cookBookPro.controller;

import org.springframework.http.ResponseEntity;
import cookBookPro.dto.IngredientDto;
import cookBookPro.dto.IngredientFormDto;
import cookBookPro.entity.Ingredient;

import java.util.List;

public interface IngredientController {


    ResponseEntity<IngredientDto> createIngredient(IngredientFormDto formDto);

    ResponseEntity<IngredientDto> findById(Integer ingredientId);

    ResponseEntity<List<IngredientDto>> findAll();

    ResponseEntity<IngredientDto> update(IngredientFormDto formDto);

    ResponseEntity<IngredientDto> delete(Ingredient ingredient);

    ResponseEntity<Void> clear();

    ResponseEntity<IngredientDto> findIngredientByNameContainsIgnoreCase(String ingredientName);
}
