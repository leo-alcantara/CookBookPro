package se.lexicom.jpa_assignement.DAO;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexicom.jpa_assignement.exceptions.ExceptionManager;
import se.lexicom.jpa_assignement.entity.Ingredient;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class IngredientDAOImpl implements IngredientDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public Ingredient create(Ingredient ingredient) throws ExceptionManager {

        //Check if input parameters is null, if null throw exception
        //if (ingredient == null) throw new ExceptionManager("Can not persist item: " + ingredient);


        //If not null, call entityManager and persist and return instance
        entityManager.persist(ingredient);
        return ingredient;
    }

    @Override
    @Transactional
    public Ingredient delete(Ingredient ingredient) throws ExceptionManager {

        //Check if input parameters is null, if null throw exception
        if (ingredient == null) {
            throw new ExceptionManager("Can not remove item: " + ingredient);
        }

        //If not null, call entityManager and remove and return instance
        entityManager.remove(ingredient);
        return ingredient;
    }

    @Override
    @Transactional
    public List<Ingredient> findAll() {

        //Use entityManager Query Creator to search DB and return List of ingredients 
        return entityManager.createQuery("SELECT i FROM Ingredient i", Ingredient.class).getResultList();
    }

    @Override
    @Transactional
    public Ingredient findById(Integer ingredientId) throws ExceptionManager {

        //Check if input parameters is null, if null throw exception
        if (ingredientId == null) {
            throw new ExceptionManager("Can not find Ingredient with Id: " + ingredientId);
        }

        //If not null, call entityManager find method and return ingredient instance with matching Id
        return entityManager.find(Ingredient.class, ingredientId);
    }

    @Override
    @Transactional
    public Ingredient update(Ingredient ingredient) throws ExceptionManager {

        //Check if input parameters is null, if null throw exception
        if (ingredient == null) {
            throw new ExceptionManager("Can not update item: " + ingredient);
        }

        //If not null, call entityManager merge method to update ingredient instance and return it
        return entityManager.merge(ingredient);
    }

    @Override
    @Transactional
    public void clear() {

        //Clear ingredients DB
        entityManager.clear();
    }


    @Override
    @Transactional
    public List<Ingredient> findIngredientByNameContainsIgnoreCase(String ingredientName) throws ExceptionManager {

        //Check if input parameters is null, if null throw exception
        //if (ingredientName == null) throw new ExceptionManager("Can not find item: " + ingredientName);


        //If not null, query DB to get ingredient based on the name inputed and making the use of streams get first result in case of duplicates and return it if found else throw exception
        List<Ingredient> ingredients = entityManager.createQuery("SELECT i FROM Ingredient i WHERE UPPER(i.ingredientName) LIKE UPPER(CONCAT('%', :ingredientName, '%'))", Ingredient.class)
                .setParameter("ingredientName", ingredientName).getResultList();

        return ingredients;
    }

}

