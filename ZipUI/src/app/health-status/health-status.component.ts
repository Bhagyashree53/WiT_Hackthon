import { Component, OnInit, NgModule } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { User } from '../_models/user';
import { AuthServiceService } from '../_services/auth-service.service';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { HealthResultComponent } from '../health-status-result/health-result.component';
import { HealthIndex } from './health-index.interface';
import { HealthService } from '../_services/health.service';


@Component({
  selector: 'app-health-status',
  templateUrl: './health-status.component.html',
  styleUrls: ['./health-status.component.css']
})
export class HealthStatusComponent implements OnInit {
  formGroup: FormGroup;
  model: any = {};
  private health: HealthIndex = {
    userName: "",
    first_Name: "test",
    last_Name: "test",
    temparature: "",
    dryCough: false,
    bloodPressure: "",
    headache: false,
    status: "",
    lastUpdatedDate: "",
    spo2: ""
  };
  constructor(private router: Router, private matDialog: MatDialog, private healthService: HealthService) { }

  ngOnInit() {
    this.initForm();
  }
  initForm() {
    this.formGroup = new FormGroup({
      username: new FormControl('', Validators.required),
      password: new FormControl('', Validators.required),
    });

  }
  Check() {
    console.log(this.formGroup.value);
  }

  openDialog() {
    console.log(this.health)
    this.health.userName = "test"
    this.health.dryCough = parseInt(this.health.dryCough);
    this.health.headache = parseInt(this.health.headache);
    this.healthService.evaluateHealthCondition(this.health).subscribe((data: HealthIndex) => {
      console.log(data);
      this.health = data;

      const dialogConfig = new MatDialogConfig();
      dialogConfig.data = this.health
      this.matDialog.open(HealthResultComponent, dialogConfig);
    });
  }

}
