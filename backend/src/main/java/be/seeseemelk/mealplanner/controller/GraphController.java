package be.seeseemelk.mealplanner.controller;

import be.seeseemelk.mealplanner.controller.dto.CreateMeal;
import be.seeseemelk.mealplanner.model.DayPlan;
import be.seeseemelk.mealplanner.model.Ingredient;
import be.seeseemelk.mealplanner.model.Meal;
import be.seeseemelk.mealplanner.service.DayPlanService;
import be.seeseemelk.mealplanner.service.IngredientService;
import be.seeseemelk.mealplanner.service.MealService;
import io.vertx.core.cli.annotations.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Query;
import org.eclipse.microprofile.graphql.Source;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@GraphQLApi
public class GraphController
{
	@Inject
	MealService meals;

	@Inject
	IngredientService ingredients;

	@Inject
	DayPlanService dayPlans;

	@Query("meals")
	@Description("Get all meals")
	public List<Meal> getAllMeals()
	{
		return meals.getAllMeals();
	}

	@Query("meal")
	public Meal getMealById(long id)
	{
		return meals.getMealById(id);
	}

	@Query("weekPlan")
	public List<DayPlan> getWeekPlan(LocalDate currentDay)
	{
		return dayPlans.getWeekPlan(currentDay);
	}

	@Mutation
	@Transactional
	public Meal createMeal(CreateMeal meal)
	{
		return meals.createMeal(meal);
	}

	/*@Mutation
	@Transactional
	public ShoppingList generateShoppingList()
	{
		return null;
	}*/

	public List<Ingredient> ingredients(@Source Meal meal)
	{
		return ingredients.getIngredientsFor(meal);
	}
}
