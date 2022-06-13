package be.seeseemelk.mealplanner.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@AllArgsConstructor
@Builder
@Entity
@Getter
@NoArgsConstructor
@Setter
public class Meal
{
	@Id
	@GeneratedValue
	private long id;

	private String name;
	private int portionSize;

	@OneToMany(mappedBy = "meal")
	private List<MealBlacklist> blacklists;
}
