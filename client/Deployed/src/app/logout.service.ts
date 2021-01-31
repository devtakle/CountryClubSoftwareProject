import { Injectable } from '@angular/core';
import { Http,Response,Headers } from '@angular/http';
import 'rxjs/add/operator/map';
@Injectable()
export class LogoutService {

  constructor(private http:Http) { }
  logoutUrl: string = 'http://localhost:8080/logout/';

    logout(){
       return this.http.get(this.logoutUrl+localStorage.getItem("token"))
      // .map(res => res.json());
      //return this.http.get(this.loginUrl+username+'/'+password).map(res =>res.toString());
    }

}
