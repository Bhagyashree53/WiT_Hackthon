import { Component, OnInit, NgModule } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import {User} from '../_models/user';
import {AuthServiceService} from '../_services/auth-service.service';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  formGroup: FormGroup;
  model: any = {};
  constructor(private authService: AuthServiceService, private router: Router) { }

  ngOnInit() {
  this.initForm();
  }
  initForm(){
    this.formGroup = new FormGroup({
    username: new FormControl('',Validators.required),
    password: new FormControl('',Validators.required),
    });

  }
  Login(){
  if(this.formGroup.valid){
    this.authService.login(this.formGroup.value).subscribe(result=>{
    console.log("returned data");
    console.log(result);
    if(result === "user"){
      this.router.navigate(['homeUser']);
    } else if(result === "admin") {
      this.router.navigate(['homeAdmin'])
    }
    });
  }
  }

}
