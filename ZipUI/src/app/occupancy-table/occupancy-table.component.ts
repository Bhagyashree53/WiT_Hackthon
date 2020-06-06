import { Component, OnInit } from '@angular/core';
import {SelectionModel} from '@angular/cdk/collections';
import {MatTableDataSource} from '@angular/material/table';

export interface SeatsTable {
  seatNumber: number;
  availability: string;
}

const SEAT_DATA: SeatsTable[] = [
  {seatNumber: 1, availability: 'yes'},
  {seatNumber: 2, availability: 'yes'},
  {seatNumber: 3, availability: 'yes'},
  {seatNumber: 4, availability: 'yes'},
  {seatNumber: 5, availability: 'yes'},
  {seatNumber: 6, availability: 'yes'},
  {seatNumber: 7, availability: 'yes'},
  {seatNumber: 8, availability: 'yes'},
  {seatNumber: 9, availability: 'yes'},
  {seatNumber: 10, availability: 'yes'},
];



@Component({
  selector: 'occupancy-table',
  templateUrl: './occupancy-table.component.html',
  styleUrls: ['./occupancy-table.component.css']
})
export class OccupancyTableComponent {

  displayedColumns: string[] = ['select','seatNumber', 'availability'];
  //dataSource = SEAT_DATA;
  constructor() { }

  ngOnInit() {
  }
  dataSource = new MatTableDataSource<SeatsTable>(SEAT_DATA);
  selection = new SelectionModel<SeatsTable>(true, []);

  /** Whether the number of selected elements matches the total number of rows. */
  isAllSelected() {
    const numSelected = this.selection.selected.length;
    const numRows = this.dataSource.data.length;
    return numSelected === numRows;
  }

  /** Selects all rows if they are not all selected; otherwise clear selection. */
  masterToggle() {
    console.log("all")
    this.isAllSelected() ?
        this.selection.clear() :
        this.dataSource.data.forEach(row => this.selection.select(row));
  }

  /** The label for the checkbox on the passed row */
  checkboxLabel(row?: SeatsTable): string {
    //console.log(row.seatNumber);
    if (!row) {
      return `${this.isAllSelected() ? 'select' : 'deselect'} all`;  
    }
    return `${this.selection.isSelected(row) ? 'deselect' : 'select'} row ${row.seatNumber + 1}`;

  }

  UpdateSeatAvailability(){
    console.log(this.selection.selected);
  }
 

}
