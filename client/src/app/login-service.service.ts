import { Injectable } from '@angular/core';
import { Http,Response,Headers } from '@angular/http';
import 'rxjs/add/operator/map';
@Injectable()
export class LoginServiceService {

  constructor(private http:Http) { }
  loginUrl: string = 'http://localhost:8080/login/';
  logoutUrl: string = 'http://localhost:8080/logout/17852';


  login(username,password){
     return this.http.get(this.loginUrl+username+'/'+password)
     .map(res => res.json());
    //return this.http.get(this.loginUrl+username+'/'+password).map(res =>res.toString());
  }

}
