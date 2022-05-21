
import { Ingredient } from "./ingredient";
import { WeekDays } from "./week-days";

export interface Meal {
    name: string;
    ingredients: Array<Ingredient>;
    portionSize: number;
    impossibleDays: Array<WeekDays>;
}
