import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MealItemComponent } from './meal-item/meal-item.component';



@NgModule({
  declarations: [
    MealItemComponent
  ],
  imports: [
    CommonModule
  ],
  exports: [
    MealItemComponent
  ]
})
export class ComponentsModule { }
