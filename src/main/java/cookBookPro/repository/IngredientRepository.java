package cookBookPro.repository;

import org.springframework.data.repository.CrudRepository;
import cookBookPro.entity.Ingredient;

import java.util.List;

public interface IngredientRepository extends CrudRepository<Ingredient, Integer> {

    List<Ingredient> findByIngredientName(String ingredientName);
}
