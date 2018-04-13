import { Component, OnInit } from '@angular/core';
import { LogoutService} from '../logout.service';
import { Router} from '@angular/router';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css'],
  providers: [ LogoutService]
})
export class LogoutComponent implements OnInit {

  constructor(private logoutservice: LogoutService, private router: Router) { }

  ngOnInit() {
    //this.logoutservice.logout();
    this.logoutservice.logout()
    .subscribe(message => { this.router.navigate(['/login']) });
    localStorage.setItem("key",null);
  }

}
