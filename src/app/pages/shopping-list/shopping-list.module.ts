import { IonicModule } from '@ionic/angular';
import { RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ShoppingListPage } from './shopping-list.page';

import { ShoppingListPageRoutingModule } from './shopping-list-routing.module';

@NgModule({
  imports: [
    IonicModule,
    CommonModule,
    FormsModule,
    RouterModule.forChild([{ path: '', component: ShoppingListPage }]),
    ShoppingListPageRoutingModule,
  ],
  declarations: [ShoppingListPage]
})
export class ShoppingListPageModule {}
