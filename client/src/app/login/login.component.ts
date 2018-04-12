import { Component, OnInit } from '@angular/core';
import { LoginServiceService} from '../login-service.service';
import { Login} from './login';
import { FormGroup, FormControl , Validators} from '@angular/forms';
import { Router} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  providers: [ LoginServiceService]
})
export class LoginComponent implements OnInit {

  form: FormGroup ;
  loginmodel: Login;
  isInvalidValidEmail: Boolean = false;
  isInvalidPassword: Boolean = false;

  constructor(private loginservice: LoginServiceService, private router: Router) { }
  login() {

    // call service class for making http request
    console.log('****');
    console.log(this.form.value.email);
    console.log(this.form.value.password);
    this.loginservice.login(this.form.value.email, this.form.value.password)
    .subscribe(message => {
    this.loginmodel = message;
    console.log('*****' + this.loginmodel.authenticationMessage + '**********');
    console.log('*****' + this.loginmodel.token + '**********');
    if (this.loginmodel.authenticationMessage == 'Username Name is not registered') {
      this.isInvalidValidEmail = true;
    }
    if (this.loginmodel.authenticationMessage == 'Wrong Password Entered') {
      this.isInvalidPassword = true;
    }
    if (this.loginmodel.authenticationMessage == 'correct password') {
      localStorage.setItem('token',this.loginmodel.token);
      this.router.navigate(['/menu']);
    }
  });

  this.isInvalidValidEmail = false;
  this.isInvalidPassword = false;

  }
  ngOnInit() {

    this.form = new FormGroup({
      email: new FormControl('', [Validators.required, Validators.email]),
      password: new FormControl('', Validators.required)
    });
  }

}
