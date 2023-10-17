package se.lexicom.jpa_assignement.DAO;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexicom.jpa_assignement.exceptions.ExceptionManager;
import se.lexicom.jpa_assignement.entity.RecipeIngredient;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RecipeIngredientDAOImpl implements RecipeIngredientDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public RecipeIngredient create(RecipeIngredient recipeIngredient) throws ExceptionManager {

        //Check if input parameters is null, if null throw exception
        if (recipeIngredient == null) {
            throw new ExceptionManager("Can not persist item: " + recipeIngredient);
        }

        //If not null, call entityManager and persist and return instance
        entityManager.persist(recipeIngredient);
        return recipeIngredient;
    }

    @Override
    @Transactional
    public RecipeIngredient delete(RecipeIngredient recipeIngredient) throws ExceptionManager {

        //Check if input parameters is null, if null throw exception
        if (recipeIngredient == null) {
            throw new ExceptionManager("Can not delete item: " + recipeIngredient);
        }

        //If not null, call entityManager and remove and return instance
        entityManager.remove(recipeIngredient);
        return recipeIngredient;
    }

    @Override
    @Transactional
    public List<RecipeIngredient> findAll() {

        //Use entityManager Query Creator to search DB and return List of RecipeIngredient
        return entityManager.createQuery("SELECT r FROM RecipeIngredient r", RecipeIngredient.class).getResultList();
    }

    @Override
    @Transactional
    public RecipeIngredient findById(Integer recipeIngredientId) throws ExceptionManager {

        //Check if input parameters is null, if null throw exception
        if (recipeIngredientId == null) {
            throw new ExceptionManager("Can not find item: " + recipeIngredientId);
        }

        //If not null, call entityManager find method and return RecipeIngredient instance with matching Id
        return entityManager.find(RecipeIngredient.class, recipeIngredientId);
    }

    @Override
    @Transactional
    public RecipeIngredient update(RecipeIngredient recipeIngredient) throws ExceptionManager {

        //Check if input parameters is null, if null throw exception
        if (recipeIngredient == null) {
            throw new ExceptionManager("Can not update item: " + recipeIngredient);
        }

        //If not null, call entityManager merge method to update RecipeIngredient instance and return it
        return entityManager.merge(recipeIngredient);
    }

    @Override
    @Transactional
    public void clear() {

        //Clear RecipeIngredient DB
        entityManager.clear();
    }
}
