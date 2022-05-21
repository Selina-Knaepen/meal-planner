import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { WeekPlanPage } from './week-plan.page';

const routes: Routes = [
  {
    path: '',
    component: WeekPlanPage,
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class WeekPlanPageRoutingModule {}
