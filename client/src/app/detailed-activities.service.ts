import { Injectable } from '@angular/core';
import {ActivitySchedule} from './ActivitySchedule';
import { Http,Response,Headers } from '@angular/http';
import { Observable }     from 'rxjs/Observable';
import {TokenTest} from './TokenTest';
@Injectable()
export class DetailedActivitiesService {
  constructor(private http:Http) { }

  getDetailedActivities(id){
    let headers = new Headers();
    headers.append('Content-Type','application/json');


    headers.append('token','92957');
    console.log("TOKEN IS  "+TokenTest.token);
    return this.http.get("http://localhost:8080/activities/"+id,{headers:headers})
    .map(res => res.json());
  }

}
