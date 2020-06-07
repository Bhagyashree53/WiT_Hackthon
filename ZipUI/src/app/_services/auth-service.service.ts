import { Injectable } from '@angular/core';
import {Observable, of} from 'rxjs';
import {User} from '../_models/user';

@Injectable({
  providedIn: 'root'
})
export class AuthServiceService {
  userData: any = [
    {
      username: 'avaidy19',
      password: 'avaidy19',
      role: 'admin'
    },
    {
        username: 'test',
        password: 'test',
        role: 'user'
     }
  ];
  value: any = {};
  constructor() { }
  login(data): Observable<any> {
    for(this.value of this.userData){
      if(data.username === this.value.username){
                  if(data.password === this.value.password){
                    sessionStorage.setItem("name",this.value.username);
                    return of(this.value.role);
                  }
                  else{
                    return of("Invalid password");
                  }
                }
    }
    return of("Invalid username");
  }
}
