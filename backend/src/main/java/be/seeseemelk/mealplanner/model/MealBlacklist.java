package be.seeseemelk.mealplanner.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class MealBlacklist extends PanacheEntityBase
{
	@Id
	@GeneratedValue
	private long id;

	@ManyToOne
	private Meal meal;

	private WeekDay day;
}
