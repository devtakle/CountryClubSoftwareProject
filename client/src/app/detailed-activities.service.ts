import { Injectable } from '@angular/core';
import {ActivitySchedule} from './ActivitySchedule';
import { Http, Response, Headers } from '@angular/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class DetailedActivitiesService {
  constructor(private http: Http) { }

  getDetailedActivities(id) {
    const headers = new Headers();
    headers.append('Content-Type', 'application/json');


    headers.append('token', localStorage.getItem('token'));

    return this.http.get('http://localhost:8080/activities/' + id, {headers: headers})
    .map(res => res.json());
  }

}
