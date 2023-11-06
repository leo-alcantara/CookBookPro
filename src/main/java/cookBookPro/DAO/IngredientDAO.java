package cookBookPro.DAO;

import cookBookPro.entity.Ingredient;

public interface IngredientDAO extends GenericCRUDMethods <Ingredient, Integer>{

    Ingredient findIngredientByNameContainsIgnoreCase(String ingredientName);
}
