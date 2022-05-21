import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MealListPage } from './meal-list.page';

const routes: Routes = [
  {
    path: '',
    component: MealListPage,
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MealListPageRoutingModule {}
