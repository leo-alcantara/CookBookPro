package se.lexicom.jpa_assignement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.lexicom.jpa_assignement.DAO.RecipeCategoryDAOImpl;
import se.lexicom.jpa_assignement.dto.RecipeCategoryDto;
import se.lexicom.jpa_assignement.dto.RecipeCategoryFormDto;
import se.lexicom.jpa_assignement.entity.RecipeCategory;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeCategoryServiceImpl implements RecipeCategoryService {

    //Initiate Vars
    private final RecipeCategoryDAOImpl recipeCategoryDAO;
    private final ConversionService convert;

    //Autowired Constructor
    @Autowired
    public RecipeCategoryServiceImpl(RecipeCategoryDAOImpl recipeCategoryDAO, ConversionService convert) {
        this.recipeCategoryDAO = recipeCategoryDAO;
        this.convert = convert;
    }

    @Override
    @Transactional
    public RecipeCategoryDto createRecipeCategory(RecipeCategoryFormDto form) {

        //Use recipeCategoryDAO.create method to create RecipeCategory
        RecipeCategory recipeCatToCreate = recipeCategoryDAO.create(convert.toRecipeCategory(form));

        //Convert again and return the DTO Form
        return convert.toRecipeCategoryDto(recipeCatToCreate);
    }

    @Override
    @Transactional
    public RecipeCategoryDto findById(Integer recipeCategoryId) {

        //Use recipeCategoryDAO.findById method to find existing RecipeCategory
        RecipeCategory foundRecipeCategory = recipeCategoryDAO.findById(recipeCategoryId);

        //Convert again and return the DTO Form
        return convert.toRecipeCategoryDto(foundRecipeCategory);
    }

    @Override
    @Transactional
    public List<RecipeCategoryDto> findAll() {

        //Use recipeCategoryDAO.findAll method to get all RecipeCategory
        List<RecipeCategory> recipeCategoryList = recipeCategoryDAO.findAll();

        //Instantiate the DTO List
        List<RecipeCategoryDto> recipeCategoryDtoList = new ArrayList<>();

        //Iterate through recipeCategoryList and add a converted instance of the RecipeCategory to the List recipeCategoryDtoList
        recipeCategoryList.forEach((rc) -> recipeCategoryDtoList.add(convert.toRecipeCategoryDto(rc)));

        //Return DTO List
        return recipeCategoryDtoList;
    }

    @Override
    @Transactional
    public RecipeCategoryDto update(RecipeCategoryFormDto formDto) {

        //Use recipeCategoryList.update method to update existing RecipeCategory
        RecipeCategory original = recipeCategoryDAO.update(convert.toRecipeCategory(formDto));

        //Convert again and return the DTO Form
        return convert.toRecipeCategoryDto(original);
    }

    @Override
    @Transactional
    public void delete(RecipeCategory recipeCategory) {
        recipeCategoryDAO.delete(recipeCategory);
    }

    @Override
    @Transactional
    public void clear() {
        recipeCategoryDAO.clear();
    }

    @Override
    @Transactional
    public List<RecipeCategoryDto> findByNameIContainsIgnoreCase(String categoryName) {

        //Use recipeCategoryList.findByNameIContainsIgnoreCase method to get existing ingredient
        List<RecipeCategory> foundRecipeCats = recipeCategoryDAO.findByNameIContainsIgnoreCase(categoryName);
        List<RecipeCategoryDto> convertedRecipeCats = new ArrayList<>();

        //Loop through List of foundRecipeCats and convert RecipeCategory to DTO and add to DTO List to be returned
        for(RecipeCategory recipeCats : foundRecipeCats) {
            RecipeCategoryDto recipecatsDto = convert.toRecipeCategoryDto(recipeCats);
            convertedRecipeCats.add(recipecatsDto);
        }

        //Return the DTO Form List
        return convertedRecipeCats;
    }
}
