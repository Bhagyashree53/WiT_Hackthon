import { Component, OnInit } from '@angular/core';
import {UpdateConfirmDialogue} from'./dialogue-popup';
import {MatDialog} from '@angular/material/dialog';

export interface SeatsMap{
  seatNumber: number;
  availability: number;
}


@Component({
  selector: 'seat-map',
  templateUrl: './seat-map.component.html',
  styleUrls: ['./seat-map.component.css']
})
export class SeatMapComponent implements OnInit {

  constructor(public dialog: MatDialog){}

  Seats: SeatsMap[] = [
    {seatNumber: 1, availability: 0},
    {seatNumber: 2, availability: 1},
    {seatNumber: 3, availability: 1},
    {seatNumber: 4, availability: 0},
    {seatNumber: 5, availability: 0},
    {seatNumber: 6, availability: 1},
    {seatNumber: 7, availability: 1},
    {seatNumber: 8, availability: 0},
    {seatNumber: 9, availability: 1},
    {seatNumber: 10, availability: 0},
    {seatNumber: 11, availability: 1},
    {seatNumber: 12, availability: 0},
  ];
  ngOnInit() {
  }

  UpdateSeatAvailability(){
    console.log("update");
    this.dialog.open(UpdateConfirmDialogue);
  }

  change(seat){
    console.log("change");
    let updateItem = this.Seats.find(this.findIndexToUpdate, seat.seatNumber);
    let index = this.Seats.indexOf(updateItem);
    console.log("old"+seat.availability);
    if(seat.availability==0)
    {
      seat.availability=1;
    }
    else{
      seat.availability=0;
    }
    console.log("new"+seat.availability);
    this.Seats[index] = seat;
  }

  findIndexToUpdate(newItem) { 
        return newItem.id === this;
  }


}
