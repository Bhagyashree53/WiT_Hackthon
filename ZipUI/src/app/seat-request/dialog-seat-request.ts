import {Component} from '@angular/core';

@Component({
  selector: 'dialog-seat-request-warn',
  templateUrl: 'dialog-seat-request-warn.html',
})
export class SeatRequestWarnDialog{

}

@Component({
  selector: 'dialog-seat-request-failed',
  templateUrl: 'dialog-seat-request-failed.html',
})
export class SeatRequestFailedDialog{}


@Component({
  selector: 'dialog-seat-request-success',
  templateUrl: 'dialog-seat-request-success.html',
})
export class SeatRequestSuccessDialog{
  //EventEmitter
  //seatNo: Number = 12345;
}

