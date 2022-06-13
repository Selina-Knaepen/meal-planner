import { IonicModule } from '@ionic/angular';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { MealListPage } from './meal-list.page';

import { MealListPageRoutingModule } from './meal-list-routing.module';

@NgModule({
  imports: [
    IonicModule,
    CommonModule,
    FormsModule,
    MealListPageRoutingModule
  ],
  declarations: [MealListPage]
})
export class MealListPageModule {}
