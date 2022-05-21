import { WeekDay } from "@angular/common";
import { Ingredient } from "./ingredient";

export interface Meal {
    name: string;
    ingredients: Array<Ingredient>;
    portionSize: number;
    possibleDays: Array<WeekDay>;
}
