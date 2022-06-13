package be.seeseemelk.mealplanner;

import be.seeseemelk.mealplanner.model.Meal;

public final class MockData
{
	private MockData() {}

	public static final Meal LASAGNE = Meal.builder()
		.id(1)
		.name("Lasagne")
		.portionSize(2)
		.build();
}
