import { Component, Input, OnInit } from '@angular/core';
import { Meal } from 'src/app/models/meal';

@Component({
  selector: 'app-meal-item',
  templateUrl: './meal-item.component.html',
  styleUrls: ['./meal-item.component.scss'],
})
export class MealItemComponent implements OnInit {
  @Input() meal: Meal;
  isCollapsed = false;

  constructor() { }

  ngOnInit() {}

  changeIsCollapsed() {
    this.isCollapsed = !this.isCollapsed;
  }
}
