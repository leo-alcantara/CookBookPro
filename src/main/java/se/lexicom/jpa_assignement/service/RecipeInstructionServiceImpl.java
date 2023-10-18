package se.lexicom.jpa_assignement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.lexicom.jpa_assignement.DAO.RecipeInstructionDAOImpl;
import se.lexicom.jpa_assignement.dto.RecipeInstructionDto;
import se.lexicom.jpa_assignement.dto.RecipeInstructionFormDto;
import se.lexicom.jpa_assignement.entity.RecipeInstruction;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeInstructionServiceImpl implements RecipeInstructionService {

    //Initiate Vars
    private final RecipeInstructionDAOImpl recipeInstructionDAO;
    private final ConversionService convert;

    //Autowired Constructor
    @Autowired
    public RecipeInstructionServiceImpl(RecipeInstructionDAOImpl recipeInstructionDAO, ConversionService convert) {
        this.recipeInstructionDAO = recipeInstructionDAO;
        this.convert = convert;
    }

    @Override
    @Transactional
    public RecipeInstructionDto createRecipeInstruction(RecipeInstructionFormDto formDto) {

        //Use recipeInstructionDAO.create method to create RecipeInstruction
        RecipeInstruction saved = recipeInstructionDAO.create(convert.toRecipeInstruction(formDto));

        //Convert again and return the DTO Form
        return convert.toRecipeInstructionDto(saved);
    }

    @Override
    public RecipeInstructionDto findById(Integer recipeInstructionId) {

        //Use recipeInstructionDAO.findById method to find RecipeInstruction
        RecipeInstruction foundRecipeInstruction = recipeInstructionDAO.findById(recipeInstructionId);

        //Convert again and return the DTO Form
        return convert.toRecipeInstructionDto(foundRecipeInstruction);
    }

    @Override
    public List<RecipeInstructionDto> findAll() {

        //Use recipeInstructionDAO.findAll method to get all RecipeInstruction
        List<RecipeInstruction> recipeInstructionList = recipeInstructionDAO.findAll();

        //Instantiate the DTO List
        List<RecipeInstructionDto> recipeInstructionDtoList = new ArrayList<>();

        //Iterate through recipeInstructionList and add a converted instance of the RecipeInstruction to the List recipeInstructionDtoList
        recipeInstructionList.forEach((ri) -> recipeInstructionDtoList.add(convert.toRecipeInstructionDto(ri)));

        //Return DTO List
        return recipeInstructionDtoList;
    }

    @Override
    public RecipeInstructionDto update(RecipeInstructionFormDto formDto) {

        //Use recipeInstructionDAO.update method to update existing RecipeInstruction
        RecipeInstruction original = recipeInstructionDAO.update(convert.toRecipeInstruction(formDto));

        //Convert again and return the DTO Form
        return convert.toRecipeInstructionDto(original);
    }

    @Override
    public RecipeInstructionDto delete(RecipeInstruction recipeInstruction) {
        recipeInstructionDAO.delete(recipeInstruction);
        return convert.toRecipeInstructionDto(recipeInstruction);
    }

    @Override
    public void clear() {
    }
}
