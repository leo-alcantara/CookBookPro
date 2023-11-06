package cookBookPro.DAO;

import cookBookPro.entity.RecipeCategory;

public interface RecipeCategoryDAO extends GenericCRUDMethods <RecipeCategory, Integer>{

    RecipeCategory findByName(String categoryName);

}
