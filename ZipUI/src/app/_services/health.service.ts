import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { HealthIndex } from '../health-status/health-index.interface';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class HealthService {

  constructor(private httpClient: HttpClient) { }
  evaluateHealthCondition(healthData : HealthIndex)  {
    let url = "http://localhost:8081/healthIndex"
      return this.httpClient.post(url, healthData);
  }
}