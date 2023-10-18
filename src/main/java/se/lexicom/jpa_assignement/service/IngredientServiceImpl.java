package se.lexicom.jpa_assignement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.lexicom.jpa_assignement.DAO.IngredientDAOImpl;
import se.lexicom.jpa_assignement.dto.IngredientDto;
import se.lexicom.jpa_assignement.dto.IngredientFormDto;
import se.lexicom.jpa_assignement.entity.Ingredient;

import java.util.ArrayList;
import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {

    //Initiate Vars
    private final IngredientDAOImpl ingredientDAO;
    private final ConversionService convert;

    //Autowired Constructor
    @Autowired
    public IngredientServiceImpl(IngredientDAOImpl ingredientDAO, ConversionService convert) {
        this.ingredientDAO = ingredientDAO;
        this.convert = convert;
    }

    @Override
    @Transactional
    public IngredientDto createIngredient(IngredientFormDto form) {

        //Use ingredientDAO.create method to create Ingredient
        Ingredient ingredientToCreate = ingredientDAO.create(convert.toIngredient(form));

        //Convert again and return the DTO Form
        return convert.toIngredientDto(ingredientToCreate);
    }

    @Override
    @Transactional
    public IngredientDto findById(Integer ingredientId) {

        //Use ingredientDAO.findById method to find Ingredient
        Ingredient foundIngredient = ingredientDAO.findById(ingredientId);

        //Convert again and return the DTO Form
        return convert.toIngredientDto(foundIngredient);
    }

    @Override
    @Transactional
    public List<IngredientDto> findAll() {

        //Use ingredientDAO.findAll method to get all Ingredients
        List<Ingredient> ingredientList = ingredientDAO.findAll();

        //Instantiate the DTO List
        List<IngredientDto> ingredientDtoList = new ArrayList<>();

        //Iterate through ingredientList and add a converted instance of the Ingredient to the List ingredientDtoList
        ingredientList.forEach((i) -> ingredientDtoList.add(convert.toIngredientDto(i)));

        //Return DTO List
        return ingredientDtoList;
    }

    @Override
    @Transactional
    public IngredientDto update(IngredientFormDto formDto) {

        //Use ingredientDAO.update method to update existing ingredient
        Ingredient ingredientToUpdate = ingredientDAO.update(convert.toIngredient(formDto));

        //Convert again and return the DTO Form
        return convert.toIngredientDto(ingredientToUpdate);
    }

    @Override
    @Transactional
    public void delete(Ingredient ingredient) {
        ingredientDAO.delete(ingredient);
    }

    @Override
    @Transactional
    public void clear() {
        ingredientDAO.clear();
    }

    @Override
    @Transactional
    public List<IngredientDto> findIngredientByNameContainsIgnoreCase(String ingredientName) {

        //Use ingredientDAO.findIngredientByNameContainsIgnoreCase method to get existing ingredient
        List<Ingredient> foundIngredients = ingredientDAO.findIngredientByNameContainsIgnoreCase(ingredientName);
        List<IngredientDto> convertedIngredients = new ArrayList<>();

        //Loop through List of foundIngredients and convert Ingredients to DTO and add to DTO List to be returned
        foundIngredients.forEach((ingredient) -> convertedIngredients.add(convert.toIngredientDto(ingredient)));

        //Return the DTO Form List
        return convertedIngredients;
    }
}
