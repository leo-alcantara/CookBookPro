package cookBookPro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cookBookPro.DAO.RecipeIngredientDAOImpl;
import cookBookPro.dto.RecipeIngredientDto;
import cookBookPro.dto.RecipeIngredientFormDto;
import cookBookPro.entity.RecipeIngredient;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeIngredientServiceImpl implements RecipeIngredientService {

    private final RecipeIngredientDAOImpl recipeIngredientDAO;
    private final ConversionService convert;

    @Autowired
    public RecipeIngredientServiceImpl(RecipeIngredientDAOImpl recipeIngredientDAO, ConversionService convert) {
        this.recipeIngredientDAO = recipeIngredientDAO;
        this.convert = convert;
    }

    @Override
    @Transactional
    public RecipeIngredientDto createRecipeIngredient(RecipeIngredientFormDto formDto) {
        RecipeIngredient saved = recipeIngredientDAO.create(convert.toRecipeIngredient(formDto));
        return convert.toRecipeIngredientDto(saved);
    }

    @Override
    @Transactional
    public RecipeIngredientDto findById(Integer recipeIngredientId) {
        RecipeIngredient foundRecipeIngredient = recipeIngredientDAO.findById(recipeIngredientId);
        return convert.toRecipeIngredientDto(foundRecipeIngredient);
    }

    @Override
    @Transactional
    public List<RecipeIngredientDto> findAll() {
        List<RecipeIngredient> recipeIngredientList = recipeIngredientDAO.findAll();
        List<RecipeIngredientDto> recipeIngredientDtoList = new ArrayList<>();
        recipeIngredientList.forEach((ri) -> recipeIngredientDtoList.add(convert.toRecipeIngredientDto(ri)));
        return recipeIngredientDtoList;
    }

    @Override
    @Transactional
    public RecipeIngredientDto update(RecipeIngredientFormDto formDto) {
        RecipeIngredient original = recipeIngredientDAO.update(convert.toRecipeIngredient(formDto));
        return convert.toRecipeIngredientDto(original);
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
