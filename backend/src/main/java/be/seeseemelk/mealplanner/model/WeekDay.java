package be.seeseemelk.mealplanner.model;

import java.time.DayOfWeek;

public enum WeekDay
{
	MONDAY,
	TUESDAY,
	WEDNESDAY,
	THURSDAY,
	FRIDAY,
	SATURDAY,
	SUNDAY,
	;

	public static WeekDay from(DayOfWeek dayOfWeek)
	{
		switch (dayOfWeek)
		{
		case MONDAY: return MONDAY;
		case TUESDAY: return TUESDAY;
		case WEDNESDAY: return WEDNESDAY;
		case THURSDAY: return THURSDAY;
		case FRIDAY: return FRIDAY;
		case SATURDAY: return SATURDAY;
		case SUNDAY: return SUNDAY;
		default:
			throw new IllegalArgumentException("Unknown day");
		}
	}
}
