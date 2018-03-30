import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms';
import{HttpModule} from '@angular/http';
import { ReactiveFormsModule} from '@angular/forms'
import { AppComponent } from './app.component';

import { ReactiveRegisterComponent } from './reactive-register/reactive-register.component';


@NgModule({
  declarations: [
    AppComponent,
    ReactiveRegisterComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    HttpModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
