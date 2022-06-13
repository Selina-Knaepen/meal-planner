package be.seeseemelk.mealplanner;

import be.seeseemelk.mealplanner.model.DayPlan;
import be.seeseemelk.mealplanner.repository.DayPlanRepository;
import be.seeseemelk.mealplanner.service.DayPlanService;
import be.seeseemelk.mealplanner.service.MealService;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@QuarkusTest
public class DayPlanServiceTest
{
	@Inject
	DayPlanService service;

	@InjectMock
	MealService mealService;

	@InjectMock
	DayPlanRepository repository;

	@Test
	void testGetWeekPlanWithEmptyWeekPlan()
	{
		List<DayPlan> plans = service.getWeekPlan(LocalDate.now());
		assertThat(plans, empty());
	}

	@Test
	void testGenerateWeekPlan()
	{
		when(mealService.getRandomMealForDate(any())).thenReturn(MockData.LASAGNE);
		when(repository.getDayPlansFor(any(), any())).thenReturn(Collections.emptyList());

		List<DayPlan> plans = service.generateWeekPlan(LocalDate.now());

		assertThat(plans, hasSize(7));
		assertThat(plans.get(0).getMeal().getName(), equalTo(MockData.LASAGNE.getName()));
		verify(repository, times(7)).persist(any(DayPlan.class));
	}
}
