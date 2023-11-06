package cookBookPro.service;

import cookBookPro.dto.IngredientDto;
import cookBookPro.dto.IngredientFormDto;
import cookBookPro.entity.Ingredient;

import java.util.List;

public interface IngredientService {
    IngredientDto createIngredient(IngredientFormDto form);

    IngredientDto findById(Integer ingredientId);

    List<IngredientDto> findAll();

    IngredientDto update(IngredientFormDto formDto);

    IngredientDto delete(Ingredient ingredient);

    void clear();

    IngredientDto findIngredientByNameContainsIgnoreCase(String ingredientName);
}
