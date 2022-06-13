package be.seeseemelk.mealplanner.controller.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CreateMeal
{
	private String name;
	private List<CreateIngredient> ingredients = new ArrayList<>();
	private int portionSize;
}
