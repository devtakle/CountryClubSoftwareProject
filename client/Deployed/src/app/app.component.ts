import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';
  toShowAboutUs: boolean = true;
  alreadyLoggedIn: boolean = false;
  toggleAboutUs(){
    console.log("inside toggleAboutUs");
   this.toShowAboutUs = !this.toShowAboutUs;
      console.log("****"+this.toShowAboutUs);
  }
  // constructor() {
  //   if (localStorage.getItem("token") != null){
  //     console.log("inside constructore if");
  //     this.alreadyLoggedIn = !this.alreadyLoggedIn;
  //
  //   }


  }

}
