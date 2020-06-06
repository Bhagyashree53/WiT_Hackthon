import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef } from "@angular/material/dialog";

import {
    MAT_DIALOG_DATA
  } from "@angular/material/dialog";
  
@Component({
    selector: 'health-result',
    templateUrl: './health-result.component.html',
    styleUrls: ['./health-result.component.css']
})
export class HealthResultComponent implements OnInit {

    constructor(public dialogRef: MatDialogRef<HealthResultComponent>, 
        @Inject(MAT_DIALOG_DATA) public data: any) { }
    ngOnInit() {
    }

    close() {
        this.dialogRef.close("Thanks for using me!");
    }

}
