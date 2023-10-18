package se.lexicom.jpa_assignement.DAO;

import se.lexicom.jpa_assignement.entity.Ingredient;
import java.util.List;

public interface IngredientDAO extends GenericCRUDMethods <Ingredient, Integer>{

    List<Ingredient> findIngredientByNameContainsIgnoreCase(String ingredientName);
}
