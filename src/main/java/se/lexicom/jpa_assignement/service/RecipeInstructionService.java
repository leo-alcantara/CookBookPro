package se.lexicom.jpa_assignement.service;

import se.lexicom.jpa_assignement.dto.RecipeInstructionDto;
import se.lexicom.jpa_assignement.form.RecipeInstructionFormDto;
import se.lexicom.jpa_assignement.model.RecipeInstruction;

import java.util.List;

public interface RecipeInstructionService {

    RecipeInstructionDto createRecipeInstruction(RecipeInstructionFormDto formDto);

    RecipeInstructionDto findById(Integer recipeInstructionId);

    List<RecipeInstructionDto> findAll();

    RecipeInstructionDto update(RecipeInstructionFormDto formDto);

    RecipeInstructionDto delete(RecipeInstruction recipeInstruction);

    void clear();
}
