package be.seeseemelk.mealplanner.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@AllArgsConstructor
@Builder
@Entity
@Getter
@NoArgsConstructor
@Setter
public class DayPlan extends PanacheEntityBase
{
	@Id
	@GeneratedValue
	private long id;

	@ManyToOne
	private Meal meal;

	private LocalDate date;
}
