import { IonicModule } from '@ionic/angular';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { WeekPlanPage } from './week-plan.page';

import { WeekPlanPageRoutingModule } from './week-plan-routing.module';
import { ComponentsModule } from 'src/app/components/components.module';

@NgModule({
  imports: [
    IonicModule,
    CommonModule,
    FormsModule,
    WeekPlanPageRoutingModule,
    ComponentsModule
  ],
  declarations: [WeekPlanPage]
})
export class WeekPlanPageModule {}
