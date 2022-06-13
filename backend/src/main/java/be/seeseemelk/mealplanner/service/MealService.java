package be.seeseemelk.mealplanner.service;

import be.seeseemelk.mealplanner.controller.dto.CreateMeal;
import be.seeseemelk.mealplanner.exception.NoLegalMealException;
import be.seeseemelk.mealplanner.model.Meal;
import be.seeseemelk.mealplanner.model.MealBlacklist;
import be.seeseemelk.mealplanner.model.WeekDay;
import be.seeseemelk.mealplanner.repository.MealRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
public class MealService
{
	@Inject
	MealRepository repository;

	@Inject
	IngredientService ingredients;

	public List<Meal> getAllMeals()
	{
		return repository.listAll();
	}

	public Meal getMealById(long id)
	{
		return repository.findById(id);
	}

	public Meal createMeal(CreateMeal meal)
	{
		Meal storedMeal = Meal.builder()
			.name(meal.getName())
			.portionSize(meal.getPortionSize())
			.build();
		repository.persist(storedMeal);
		ingredients.saveIngredientsForMeal(storedMeal, meal.getIngredients());
		return storedMeal;
	}

	public Meal getRandomMealForDate(LocalDate date)
	{
		WeekDay weekDay = WeekDay.from(date.getDayOfWeek());
		return repository.getRandomMeals()
			.filter(meal -> !isBlacklistedOn(meal, weekDay))
			.findAny()
			.orElseThrow(() -> new NoLegalMealException("No meal is allowed on " + weekDay.name()));
	}

	private boolean isBlacklistedOn(Meal meal, WeekDay weekDay)
	{
		for (MealBlacklist blacklist : meal.getBlacklists())
		{
			if (blacklist.getDay().equals(weekDay))
				return true;
		}
		return false;
	}
}
