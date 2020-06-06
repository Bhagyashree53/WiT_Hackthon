import {Component} from '@angular/core';

export interface PeriodicElement {
  name: string;
  position: number;
  weight: number;
  symbol: string;
}

const ELEMENT_DATA: PeriodicElement[] = [
  {position: 1, name: 'Garden area', weight: 120, symbol: 'Y'},
  {position: 1, name: 'Garden area', weight: 121, symbol: 'Y'},
  {position: 1, name: 'Garden area', weight: 122, symbol: 'Y'},
  {position: 1, name: 'Garden area', weight: 123, symbol: 'Y'},
  {position: 1, name: 'Garden area', weight: 124, symbol: 'Y'},
  {position: 1, name: 'Garden area', weight: 125, symbol: 'Y'},
];

/**
 * @title Basic use of `<table mat-table>`
 */
@Component({
  selector: 'seat-availability',
  styleUrls: ['seat-availability.component.css'],
  templateUrl: 'seat-availability.component.html',
})
export class SeatAvailibityComponent {
  displayedColumns: string[] = ['position', 'name', 'weight', 'symbol'];
  dataSource = ELEMENT_DATA;
}


/**  Copyright 2019 Google LLC. All Rights Reserved.
    Use of this source code is governed by an MIT-style license that
    can be found in the LICENSE file at http://angular.io/license */