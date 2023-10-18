package se.lexicom.jpa_assignement.DAO;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexicom.jpa_assignement.exceptions.ExceptionManager;
import se.lexicom.jpa_assignement.entity.RecipeCategory;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RecipeCategoryDAOImpl implements RecipeCategoryDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public RecipeCategory create(RecipeCategory recipeCategory) throws ExceptionManager {

        //Check if input parameters is null, if null throw exception
        if (recipeCategory == null) {
            throw new ExceptionManager("Can not save item: " + recipeCategory);
        }

        //If not null, call entityManager and persist and return instance
        entityManager.persist(recipeCategory);
        return recipeCategory;
    }

    @Override
    @Transactional
    public RecipeCategory delete(RecipeCategory recipeCategory) throws ExceptionManager {

        //Check if input parameters is null, if null throw exception
        if (recipeCategory == null) {
            throw new ExceptionManager("Can not delete item: " + recipeCategory);
        }

        //If not null, call entityManager and remove instance
        entityManager.remove(recipeCategory);
        return recipeCategory;
    }

    @Override
    @Transactional
    public List<RecipeCategory> findAll() {

        //Use entityManager Query Creator to search DB and return List of RecipeCategory
        return entityManager.createQuery("SELECT rc FROM RecipeCategory rc", RecipeCategory.class).getResultList();
    }

    @Override
    @Transactional
    public RecipeCategory findById(Integer recipeCategoryId) throws ExceptionManager {

        //Check if input parameters is null, if null throw exception
        if (recipeCategoryId == null) {
            throw new ExceptionManager("Can not delete item: " + recipeCategoryId);
        }

        //If not null, call entityManager find method and return RecipeCategory instance with matching Id
        return entityManager.find(RecipeCategory.class, recipeCategoryId);
    }

    @Override
    @Transactional
    public RecipeCategory update(RecipeCategory recipeCategory) {

        //Check if input parameters is null, if null throw exception
        if(recipeCategory == null) {
            throw new ExceptionManager("Can not update item: " + recipeCategory);
        }

        //If not null, call entityManager merge method to update recipeCategory instance and return it
        return entityManager.merge(recipeCategory);
    }

    @Override
    @Transactional
    public void clear() {

        //Clear recipeCategory DB
        entityManager.clear();
    }

    @Override
    public List<RecipeCategory> findByNameContainsIgnoreCase(String categoryName) {

        //Query DB to get RecipeCategory based on the name inputed, get result list. 
        List<RecipeCategory> recipeCategories = entityManager.createQuery("SELECT rc FROM RecipeCategory rc WHERE UPPER(rc.category) LIKE UPPER(CONCAT('%', ?1 , '%'))", RecipeCategory.class)
                .setParameter(1, categoryName).getResultList();
        
        //Check if List is empty, return null if empty
        if (recipeCategories.isEmpty()) {
            return null;
        }
        
        //Return List if not Empty
        return recipeCategories;
    }
}
