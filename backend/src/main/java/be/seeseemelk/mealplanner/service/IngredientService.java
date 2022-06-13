package be.seeseemelk.mealplanner.service;

import be.seeseemelk.mealplanner.controller.dto.CreateIngredient;
import be.seeseemelk.mealplanner.model.Ingredient;
import be.seeseemelk.mealplanner.model.Meal;
import be.seeseemelk.mealplanner.repository.IngredientRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class IngredientService
{
	@Inject
	IngredientRepository repository;

	//@Inject
	//IngredientBlacklistRepository blacklistRepository;

	public List<Ingredient> getIngredientsFor(Meal meal)
	{
		return repository.findIngredientsFor(meal);
	}

	public void saveIngredientsForMeal(Meal storedMeal, List<CreateIngredient> ingredients)
	{
		for (CreateIngredient ingredient : ingredients)
		{
			Ingredient storedIngredient = Ingredient.builder()
				.amount(ingredient.getAmount())
				.name(ingredient.getName())
				.unit(ingredient.getUnit())
				.meal(storedMeal)
				.build();
			repository.persist(storedIngredient);
		}
	}
}
