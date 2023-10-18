package se.lexicom.jpa_assignement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.lexicom.jpa_assignement.DAO.RecipeIngredientDAOImpl;
import se.lexicom.jpa_assignement.dto.RecipeIngredientDto;
import se.lexicom.jpa_assignement.dto.RecipeIngredientFormDto;
import se.lexicom.jpa_assignement.entity.RecipeIngredient;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeIngredientServiceImpl implements RecipeIngredientService {
    
    //Initiate Vars
    private final RecipeIngredientDAOImpl recipeIngredientDAO;
    private final ConversionService convert;

    //Autowired Constructor
    @Autowired
    public RecipeIngredientServiceImpl(RecipeIngredientDAOImpl recipeIngredientDAO, ConversionService convert) {
        this.recipeIngredientDAO = recipeIngredientDAO;
        this.convert = convert;
    }

    @Override
    @Transactional
    public RecipeIngredientDto createRecipeIngredient(RecipeIngredientFormDto formDto) {

         //Use recipeIngredientDAO.create method to create RecipeIngredient
        RecipeIngredient saved = recipeIngredientDAO.create(convert.toRecipeIngredient(formDto));

        //Convert again and return the DTO Form
        return convert.toRecipeIngredientDto(saved);
    }

    @Override
    @Transactional
    public RecipeIngredientDto findById(Integer recipeIngredientId) {

        //Use recipeIngredientDAO.findById method to find Ingredient
        RecipeIngredient foundRecipeIngredient = recipeIngredientDAO.findById(recipeIngredientId);

        //Convert again and return the DTO Form
        return convert.toRecipeIngredientDto(foundRecipeIngredient);
    }

    @Override
    @Transactional
    public List<RecipeIngredientDto> findAll() {

        //Use recipeIngredientDAO.findAll method to get all RecipeIngredient
        List<RecipeIngredient> recipeIngredientList = recipeIngredientDAO.findAll();

        //Instantiate the DTO List
        List<RecipeIngredientDto> recipeIngredientDtoList = new ArrayList<>();

        //Iterate through recipeIngredientList and add a converted instance of the RecipeIngredient to the List recipeIngredientDtoList
        recipeIngredientList.forEach((ri) -> recipeIngredientDtoList.add(convert.toRecipeIngredientDto(ri)));

        //Return DTO List
        return recipeIngredientDtoList;
    }

    @Override
    @Transactional
    public RecipeIngredientDto update(RecipeIngredientFormDto formDto) {

        //Use recipeIngredientDAO.update method to update existing RecipeIngredient
        RecipeIngredient recipeIngredientToUpdate = recipeIngredientDAO.update(convert.toRecipeIngredient(formDto));

        //Convert again and return the DTO Form
        return convert.toRecipeIngredientDto(recipeIngredientToUpdate);
    }

    @Override
    @Transactional
    public RecipeIngredientDto delete(RecipeIngredient recipeIngredient) {
        recipeIngredientDAO.delete(recipeIngredient);
        return convert.toRecipeIngredientDto(recipeIngredient);
    }

    @Override
    @Transactional
    public void clear() {
        recipeIngredientDAO.clear();
    }
}
