package be.seeseemelk.mealplanner.repository;

import be.seeseemelk.mealplanner.model.DayPlan;
import be.seeseemelk.mealplanner.model.Meal;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Sort;

import javax.enterprise.context.ApplicationScoped;
import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
public class DayPlanRepository implements PanacheRepository<DayPlan>
{
	public List<DayPlan> getDayPlansFor(Meal meal)
	{
		return find("meal", meal).list();
	}

	public List<DayPlan> getDayPlansFor(LocalDate startDate, LocalDate endDate)
	{
		return find("date between ?1 and ?2", Sort.ascending("date"), startDate, endDate).list();
	}
}
