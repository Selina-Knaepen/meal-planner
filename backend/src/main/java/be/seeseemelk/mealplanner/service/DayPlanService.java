package be.seeseemelk.mealplanner.service;

import be.seeseemelk.mealplanner.model.DayPlan;
import be.seeseemelk.mealplanner.model.Meal;
import be.seeseemelk.mealplanner.repository.DayPlanRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class DayPlanService
{
	@Inject
	DayPlanRepository repository;

	@Inject
	MealService meals;

	public List<DayPlan> getDayPlanFor(LocalDate startDate, LocalDate endDate)
	{
		return repository.getDayPlansFor(startDate, endDate);
	}

	public List<DayPlan> getWeekPlan(LocalDate date)
	{
		return getDayPlanFor(getMonday(date), getSunday(date));
	}

	public List<DayPlan> generateWeekPlan(LocalDate date)
	{
		return generateDayPlan(getMonday(date), getSunday(date));
	}

	public List<DayPlan> generateDayPlan(LocalDate startDate, LocalDate endDate)
	{
		Map<LocalDate, DayPlan> plans = new HashMap<>();
		for (DayPlan dayPlan : getDayPlanFor(startDate, endDate))
		{
			plans.put(dayPlan.getDate(), dayPlan);
		}

		endDate = endDate.plusDays(1);
		List<DayPlan> storedPlans = new ArrayList<>();
		for (LocalDate date = startDate; date.isBefore(endDate); date = date.plusDays(1))
		{
			if (plans.containsKey(date))
			{
				storedPlans.add(plans.get(date));
			}
			else
			{
				Meal meal = meals.getRandomMealForDate(date);
				DayPlan dayPlan = DayPlan.builder()
						.date(date)
						.meal(meal)
						.build();
				repository.persist(dayPlan);
				storedPlans.add(dayPlan);

			}
		}
		return storedPlans;
	}

	private LocalDate getMonday(LocalDate date)
	{
		return date.with(ChronoField.DAY_OF_WEEK, DayOfWeek.MONDAY.getValue());
	}

	private LocalDate getSunday(LocalDate date)
	{
		return date.with(ChronoField.DAY_OF_WEEK, DayOfWeek.SUNDAY.getValue());
	}
}
