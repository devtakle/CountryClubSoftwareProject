import { Component, OnInit } from '@angular/core';
import { MemberLogin} from '../MemberLogin';
import { FormGroup, FormControl,Validators} from '@angular/forms';
import {RegisterService} from '../register.service';
import { Router} from '@angular/router';

@Component({
  selector: 'app-reactive-register',
  templateUrl: './reactive-register.component.html',
  styleUrls: ['./reactive-register.component.css'],
  providers:[RegisterService]
})
export class ReactiveRegisterComponent implements OnInit {
  form:FormGroup;
  checkExists:Boolean = false;
  checkMismatch:Boolean = false;
  memberLoginReturned:MemberLogin;

  constructor(private registerService:RegisterService,private router:Router) {
   }
   addMember(){
     console.log(this.form.value);
     let memberLogin: MemberLogin={
       email : this.form.value.email,
       id: this.form.value.id,
       password:this.form.value.password
     }
     this.registerService.createAccount(memberLogin).subscribe(message =>{
       this.memberLoginReturned = message;
       if(this.memberLoginReturned.id == "-9999"){
         console.log("mismatch");
         this.checkMismatch = true;
       }
       else if(this.memberLoginReturned.id == "-99"){
         console.log("exists");
         this.checkExists = true;

       }
       else if(this.memberLoginReturned.id != "-99" && this.memberLoginReturned.id != "-999"){
         this.router.navigate(['/login']);
       }

     } );
    this.checkExists = false;
    this.checkMismatch = false;
   }
  ngOnInit() {
    this.form = new FormGroup({
      id: new FormControl('',[Validators.required]),
      email: new FormControl('',[Validators.required,Validators.required]),
      password: new FormControl('',[Validators.required])

    })
  }

}
