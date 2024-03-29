package cookBookPro.DAO;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import cookBookPro.exceptions.ExceptionManager;
import cookBookPro.entity.RecipeIngredient;

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
        if (recipeIngredient == null) {
            throw new ExceptionManager("Can not persist item: " + recipeIngredient);
        }
        entityManager.persist(recipeIngredient);
        return recipeIngredient;
    }

    @Override
    @Transactional
    public RecipeIngredient delete(RecipeIngredient recipeIngredient) throws ExceptionManager {
        if (recipeIngredient == null) {
            throw new ExceptionManager("Can not delete item: " + recipeIngredient);
        }
        entityManager.remove(recipeIngredient);
        return recipeIngredient;
    }

    @Override
    @Transactional
    public List<RecipeIngredient> findAll() {
        return entityManager.createQuery("SELECT r FROM RecipeIngredient r", RecipeIngredient.class).getResultList();
    }

    @Override
    @Transactional
    public RecipeIngredient findById(Integer recipeIngredientId) throws ExceptionManager {
        if (recipeIngredientId == null) {
            throw new ExceptionManager("Can not find item: " + recipeIngredientId);
        }
        return entityManager.find(RecipeIngredient.class, recipeIngredientId);
    }

    @Override
    @Transactional
    public RecipeIngredient update(RecipeIngredient recipeIngredient) throws ExceptionManager {
        if (recipeIngredient == null) {
            throw new ExceptionManager("Can not update item: " + recipeIngredient);
        }
        return entityManager.merge(recipeIngredient);
    }

    @Override
    @Transactional
    public void clear() {
        entityManager.clear();
    }
}
