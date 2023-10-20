package se.lexicom.jpa_assignement.DAO;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexicom.jpa_assignement.exceptions.ExceptionManager;
import se.lexicom.jpa_assignement.entity.Recipe;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.Collection;
import java.util.List;

@Repository
public class RecipeDAOImpl implements RecipeDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public Recipe create(Recipe recipe) throws ExceptionManager {

        //Check if input parameters is null, if null throw exception
        if (recipe == null) {
            throw new ExceptionManager("Can not save item: " + recipe);
        }

        //If not null, call entityManager and persist and return instance
        entityManager.persist(recipe);
        return recipe;
    }

    @Override
    @Transactional
    public Recipe delete(Recipe recipe) throws ExceptionManager {

        //Check if input parameters is null, if null throw exception
        /*if (recipe == null) {
            throw new ExceptionManager(recipe + " recipe does not exist in the database.");
        }*/

        //If not null, call entityManager and remove and return instance
        entityManager.remove(recipe);
        return recipe;
    }

    @Override
    @Transactional
    public List<Recipe> findAll() {

        //Use entityManager Query Creator to search DB and return List of Recipes
        return entityManager.createQuery("SELECT r FROM Recipe r", Recipe.class).getResultList();
    }

    @Override
    @Transactional
    public Recipe findById(Integer recipeId) {

        //Check if input parameters is null, if null throw exception
        if (recipeId == null) {
            throw new ExceptionManager("Can not find Recipe with Id: " + recipeId);
        }
        
        //If not null, call entityManager find method and return Recipe instance with matching Id
        return entityManager.find(Recipe.class, recipeId);
    }

    @Override
    @Transactional
    public Recipe update(Recipe recipe) {

        //Check if input parameters is null, if null throw exception
        if (recipe == null) {
            throw new ExceptionManager("Can not update item: " + recipe);
        }

        //If not null, call entityManager merge method to update Recipe instance and return it
        return entityManager.merge(recipe);
    }

    @Override
    @Transactional
    public void clear() {

        //Clear Recipe DB
        entityManager.clear();
    }

    @Override
    @Transactional
    public List<Recipe> findRecipeByNameContainsIgnoreCase(String recipeName) throws ExceptionManager {

        //Check if input parameters is null, if null throw exception
        //if (recipeName == null) throw new ExceptionManager("Can not find item: " + recipeName);

        //If not null, query DB to get Recipe based on the name inputed and return List of Recipes
        return entityManager.createQuery("SELECT r FROM Recipe r WHERE UPPER(r.recipeName) LIKE UPPER(CONCAT('%', ?1 , '%'))", Recipe.class)
                .setParameter(1, recipeName).getResultList();
    }

    @Override
    @Transactional
    public List<Recipe> findRecipeByIngredientNameContainsIgnoreCase(String ingredientName) throws ExceptionManager {

        //Check if input parameters is null, if null throw exception
        //if (ingredientName == null) throw new ExceptionManager("There is no such ingredient called: " + ingredientName);

        //If not null, query DB to get Recipe based on the ingredient name inputed and return List of Recipes
        return entityManager.createQuery("SELECT r FROM Recipe r JOIN FETCH r.ingredients AS ri WHERE UPPER(ri.ingredient.ingredientName) LIKE UPPER(CONCAT('%', ?1, '%'))", Recipe.class)
                .setParameter(1, ingredientName).getResultList();
    }

    @Override
    @Transactional
    public List<Recipe> findRecipeByCategoryContainsIgnoreCase(String categoryName) throws ExceptionManager {

        //Check if input parameters is null, if null throw exception
        //if (categoryName == null) throw new ExceptionManager("There is no such category called: " + categoryName);

        //If not null, query DB to get Recipes based on the Categories names inputed and return List of Recipes
        return entityManager.createQuery("SELECT r FROM Recipe r JOIN FETCH r.categories AS rc WHERE UPPER(rc.category) LIKE UPPER(CONCAT('%', ?1 , '%'))", Recipe.class)
                .setParameter(1, categoryName).getResultList();
    }

    @Override
    @Transactional
    public List<Recipe> findRecipeSeveralCategories(Collection<String> recipeCategories) throws ExceptionManager {
        
        //Check if input parameters is null, if null throw exception
        //if (recipeCategories == null) throw new ExceptionManager("There is no such category called: " + recipeCategories);

        //If not null, query DB to get Recipes based on the List of Categories names inputed and return List of Recipes
        return entityManager.createQuery("SELECT r FROM Recipe r JOIN FETCH r.categories AS rc WHERE rc.category in (:recipeCategory)", Recipe.class)
                .setParameter("recipeCategory", recipeCategories).getResultList();
    }


}
