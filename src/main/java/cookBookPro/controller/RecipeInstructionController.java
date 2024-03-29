package cookBookPro.controller;

import org.springframework.http.ResponseEntity;
import cookBookPro.dto.RecipeInstructionDto;
import cookBookPro.dto.RecipeInstructionFormDto;
import cookBookPro.entity.RecipeInstruction;

import java.util.List;

public interface RecipeInstructionController {

    ResponseEntity<RecipeInstructionDto> createRecipeInstructions(RecipeInstructionFormDto formDto);

    ResponseEntity<RecipeInstructionDto> findById(Integer recipeInstructionId);

    ResponseEntity<List<RecipeInstructionDto>> findAll();

    ResponseEntity<RecipeInstructionDto> update(RecipeInstructionFormDto formDto);

    ResponseEntity<RecipeInstructionDto> delete(RecipeInstruction recipeInstruction);

    ResponseEntity<Void> clear();
}
