import { Meal } from "./meal";
import { WeekDays } from "./week-days";

export interface DayPlan {
    day: WeekDays;
    meal: Meal;
}