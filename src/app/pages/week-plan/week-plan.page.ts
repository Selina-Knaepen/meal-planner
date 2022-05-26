import { Component, OnInit } from '@angular/core';
import { DayPlan } from '../../models/day-plan';
import { WeekDays } from '../../models/week-days';

@Component({
  selector: 'app-week-plan',
  templateUrl: 'week-plan.page.html',
  styleUrls: ['week-plan.page.scss']
})
export class WeekPlanPage implements OnInit {
  public plan: Array<DayPlan>;

  constructor() {}

  ngOnInit() {
    this.plan = [
      {
        day: WeekDays.Monday,
        meal: {
          name: 'Food 1',
          ingredients: [
            {
              name: 'Milk',
              amount: 1,
              unit: 'litre'
            }
          ],
          portionSize: 2,
          impossibleDays: []
        }
      },
      {
        day: WeekDays.Wednesday,
        meal: {
          name: 'Food 2',
          ingredients: [],
          portionSize: 2,
          impossibleDays: []
        }
      },
      {
        day: WeekDays.Tuesday,
        meal: {
          name: 'Food 3',
          ingredients: [],
          portionSize: 2,
          impossibleDays: []
        }
      },
      {
        day: WeekDays.Thursday,
        meal: {
          name: 'Food 4',
          ingredients: [],
          portionSize: 2,
          impossibleDays: []
        }
      },
      {
        day: WeekDays.Saturday,
        meal: {
          name: 'Food 5',
          ingredients: [],
          portionSize: 2,
          impossibleDays: []
        }
      },
      {
        day: WeekDays.Friday,
        meal: {
          name: 'Food 6',
          ingredients: [],
          portionSize: 2,
          impossibleDays: []
        }
      },
      {
        day: WeekDays.Sunday,
        meal: {
          name: 'Food 7',
          ingredients: [],
          portionSize: 2,
          impossibleDays: []
        }
      }
    ];

    const weekdayOrder = Object.values(WeekDays);

    this.plan.sort((a, b) => weekdayOrder.indexOf(a.day) - weekdayOrder.indexOf(b.day));
  }
}
