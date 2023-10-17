package se.lexicom.jpa_assignement.DAO;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexicom.jpa_assignement.exceptions.ExceptionManager;
import se.lexicom.jpa_assignement.entity.RecipeInstruction;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

@Repository
public class RecipeInstructionDAOImpl implements RecipeInstructionDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public RecipeInstruction create(RecipeInstruction recipeInstruction) throws ExceptionManager {

        //Check if input parameters is null, if null throw exception
        if (recipeInstruction == null) {
            throw new ExceptionManager("Can not persist item: " + recipeInstruction);
        }

        //If not null, call entityManager and persist and return instance
        entityManager.persist(recipeInstruction);
        return recipeInstruction;
    }

    @Override
    @Transactional
    public RecipeInstruction delete(RecipeInstruction recipeInstruction) throws ExceptionManager {

        //Check if input parameters is null, if null throw exception
        if (recipeInstruction == null) {
            throw new ExceptionManager("Can not delete item: " + recipeInstruction);
        }
        entityManager.remove(recipeInstruction);
        return recipeInstruction;
    }

    @Override
    @Transactional
    public List<RecipeInstruction> findAll() {

        //Use entityManager Query Creator to search DB and return List of ingredients
        return entityManager.createQuery("SELECT r FROM RecipeInstruction r", RecipeInstruction.class).getResultList();
    }

    @Override
    @Transactional
    public RecipeInstruction findById(Integer recipeInstructionId) throws ExceptionManager {

        //Check if input parameters is null, if null throw exception
        if (recipeInstructionId == null) {
            throw new ExceptionManager("Can not find item: " + recipeInstructionId);
        }

        //If not null, call entityManager find method and return RecipeInstruction instance with matching Id
        return entityManager.find(RecipeInstruction.class, recipeInstructionId);
    }

    @Override
    @Transactional
    public RecipeInstruction update(RecipeInstruction recipeInstruction) {

        //Check if input parameters is null, if null throw exception
        if (recipeInstruction == null) {
            throw new ExceptionManager("Can not update item: " + recipeInstruction);
        }

        //If not null, call entityManager merge method to update ingredient instance and return it
        return entityManager.merge(recipeInstruction);
    }

    @Override
    @Transactional
    public void clear() {

        //Clear RecipeInstruction DB
        entityManager.clear();
    }

}
