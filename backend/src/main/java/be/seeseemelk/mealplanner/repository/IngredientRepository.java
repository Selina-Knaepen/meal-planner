package be.seeseemelk.mealplanner.repository;

import be.seeseemelk.mealplanner.model.Ingredient;
import be.seeseemelk.mealplanner.model.Meal;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class IngredientRepository implements PanacheRepository<Ingredient>
{
	public List<Ingredient> findIngredientsFor(Meal meal)
	{
		return find("meal", meal).list();
	}
}
