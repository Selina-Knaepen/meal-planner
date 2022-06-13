package be.seeseemelk.mealplanner.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@AllArgsConstructor
@Builder
@Entity
@Getter
@NoArgsConstructor
@Setter
public class Ingredient
{
	@Id
	@GeneratedValue
	private long id;

	@ManyToOne
	private Meal meal;

	private String name;
	private String unit;
	private float amount;
}
