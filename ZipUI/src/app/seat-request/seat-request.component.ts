import {Component, OnInit} from '@angular/core';
import {MatDialog} from '@angular/material/dialog';
import { SeatRequestSuccessDialog, SeatRequestFailedDialog, SeatRequestWarnDialog} from './dialog-seat-request';


interface Seat {
    floor: string;
    section: string;
}

@Component({
  selector: 'seat-request',
  styleUrls: ['seat-request.component.css'],
  templateUrl: 'seat-request.component.html',
})
export class SeatRequestComponent implements OnInit {
    constructor(public dialog: MatDialog) {}

    showSeats: boolean;
    healthStatus: boolean;
    healthStatusValid: boolean;
    seatNo: number;
    loginT: String;
    availableSeats: number
    ngOnInit() {
        this.showSeats = false;
    }
    
    seats: Seat[] = [
        {floor: '0', section: 'Garden Area'},
        {floor: '1', section: 'IWM'},
        {floor: '2', section: 'RFIT'}
    ];

    isSeatsAvailable(form){
        console.log(form.floor);
        console.log(form.section);
        //backend service call to get # of seats for floor & section combination
        this.availableSeats = 5;
        this.showSeats = true;

        console.log(form.value);
        // form.reset();
    }

    validateAndBookSeat() {
        //backend service call - get values healthStatus & healthStatusValid
        
        this.healthStatus = true;
        this.healthStatusValid = true;

        // if(this.healthStatusValid === false) {
        //     this.dialog.open(SeatRequestWarnDialog);
        //     return;
        // }

        // if(this.healthStatus === false) {
        //     this.dialog.open(SeatRequestFailedDialog);
        //     return;
        // }

        if(this.healthStatus === true && this.healthStatus === true) {
            //backend service call to book seat use floor & section
            this.seatNo = 1334;
            if(this.seatNo != null)
            this.dialog.open(SeatRequestSuccessDialog)
            console.log(this.seatNo);
        }

    }

}
