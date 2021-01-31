import { Injectable } from '@angular/core';
import {Http, Response, Headers} from '@angular/http'
import {MemberLogin} from './MemberLogin';
import'rxjs/add/operator/map';
@Injectable()
export class RegisterService {

  constructor(private http: Http) { }
  createAccount(memberLogin:MemberLogin){
    let headers = new Headers();

    headers.append('Content-Type','application/json');

    return this.http.post('http://localhost:8080/register', memberLogin,{headers:headers})
    .map(res => res.json());
  }
}
