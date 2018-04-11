import {Injectable} from '@angular/core';
import {Http } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';
import 'rxjs/add/observable/throw';
import {Headers, RequestOptions} from '@angular/http';

@Injectable()
export class ActivityService {
  constructor(private http: Http) {}

  getActivity(): Observable<any[]> {
    return this.http.get('http://localhost:8080/activities')
                    .map(response => response.json())
                    .catch(error => Observable.throw(error.statusText));
  }


}
