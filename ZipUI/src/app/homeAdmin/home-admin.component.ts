import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
interface Floor {
  value: string;
  viewValue: string;
}

interface Section {
  value: string;
  viewValue: string;
}
@Component({
  selector: 'app-home-admin',
  templateUrl: './home-admin.component.html',
  styleUrls: ['./home-admin.component.css']
})
export class HomeAdminComponent implements OnInit {

  constructor(private router: Router) { }

  selectedValue: string;
  selectedCar: string;
  selectedFloor: string;
  selectedSection: string;
  public loadTablevar:boolean = false;
  public isDisabledselectSection = true;
  public isDisabledloadbutton =  false;

  floors: Floor[] = [
    {value: '1', viewValue: '1'},
    {value: '2', viewValue: '2'},
    {value: '3', viewValue: '3'},
    {value: '4', viewValue: '4'}
  ];

  sections: Section[] = [
    {value: 'Garden Area', viewValue: 'Garden Area'},
    {value: 'IWM', viewValue: 'IWM'},
    {value: 'RFIT', viewValue: 'RFIT'}
  ];

  loadTable(){
    this.loadTablevar=true;
  }

  selectedfloorChanged(){
    console.log("change");
    this.isDisabledselectSection = false;
  }
  
  ngOnInit() {
  }
  
  logout() {
    this.router.navigate(['']);
  }



}
