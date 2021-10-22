package se.lexicom.jpa_assignement.service;

import se.lexicom.jpa_assignement.dto.IngredientDto;
import se.lexicom.jpa_assignement.model.form.IngredientFormDto;
import se.lexicom.jpa_assignement.model.Ingredient;

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
