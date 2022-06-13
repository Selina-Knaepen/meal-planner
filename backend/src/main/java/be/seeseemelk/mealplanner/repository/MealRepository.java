package be.seeseemelk.mealplanner.repository;

import be.seeseemelk.mealplanner.model.Meal;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.stream.Stream;

@ApplicationScoped
public class MealRepository implements PanacheRepository<Meal>
{
	public Stream<Meal> getRandomMeals()
	{
		return stream("order by random()");
	}
}
