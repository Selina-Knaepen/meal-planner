import { IonicModule } from '@ionic/angular';
import { RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { WeekPlanPage } from './week-plan.page';
import { ExploreContainerComponentModule } from '../explore-container/explore-container.module';

import { WeekPlanPageRoutingModule } from './week-plan-routing.module';

@NgModule({
  imports: [
    IonicModule,
    CommonModule,
    FormsModule,
    ExploreContainerComponentModule,
    WeekPlanPageRoutingModule
  ],
  declarations: [WeekPlanPage]
})
export class WeekPlanPageModule {}
