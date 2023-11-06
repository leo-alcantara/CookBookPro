package cookBookPro.service;

import cookBookPro.dto.RecipeInstructionDto;
import cookBookPro.dto.RecipeInstructionFormDto;
import cookBookPro.entity.RecipeInstruction;

import java.util.List;

public interface RecipeInstructionService {

    RecipeInstructionDto createRecipeInstruction(RecipeInstructionFormDto formDto);

    RecipeInstructionDto findById(Integer recipeInstructionId);

    List<RecipeInstructionDto> findAll();

    RecipeInstructionDto update(RecipeInstructionFormDto formDto);

    RecipeInstructionDto delete(RecipeInstruction recipeInstruction);

    void clear();
}
