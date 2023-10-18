package se.lexicom.jpa_assignement.DAO;

import se.lexicom.jpa_assignement.entity.RecipeCategory;
import java.util.List;


public interface RecipeCategoryDAO extends GenericCRUDMethods <RecipeCategory, Integer>{

    List<RecipeCategory> findByNameContainsIgnoreCase(String categoryName);

}
