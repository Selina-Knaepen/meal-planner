package be.seeseemelk.mealplanner.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateIngredient
{
	private String name;
	private String unit;
	private float amount;
}
