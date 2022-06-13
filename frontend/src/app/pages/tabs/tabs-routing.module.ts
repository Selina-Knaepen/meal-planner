import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TabsPage } from './tabs.page';

const routes: Routes = [
  {
    path: 'tabs',
    component: TabsPage,
    children: [
      {
        path: 'meal-list',
        loadChildren: () => import('../meal-list/meal-list.module').then(m => m.MealListPageModule)
      },
      {
        path: 'week-plan',
        loadChildren: () => import('../week-plan/week-plan.module').then(m => m.WeekPlanPageModule)
      },
      {
        path: 'shopping-list',
        loadChildren: () => import('../shopping-list/shopping-list.module').then(m => m.ShoppingListPageModule)
      },
      {
        path: '',
        redirectTo: '/tabs/week-plan',
        pathMatch: 'full'
      }
    ]
  },
  {
    path: '',
    redirectTo: '/tabs/week-plan',
    pathMatch: 'full'
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
})
export class TabsPageRoutingModule {}
