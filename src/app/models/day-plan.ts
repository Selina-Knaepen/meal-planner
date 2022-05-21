import { WeekDay } from "@angular/common";
import { Meal } from "./meal";

export interface DayPlan {
    day: WeekDay;
    meal: Meal;
}