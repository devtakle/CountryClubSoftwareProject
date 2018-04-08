import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import{HttpModule } from  '@angular/http';
import{FormsModule ,ReactiveFormsModule} from  '@angular/forms';
import{Routes,RouterModule } from  '@angular/router';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { MenuComponent } from './menu/menu.component';
import { ActivitiesComponent } from './activities/activities.component';
import { ReactiveRegisterComponent } from './reactive-register/reactive-register.component';
import { DetailedActvitiesComponent } from './detailed-actvities/detailed-actvities.component';

const ROUTES:Routes = [
  //{path:'',component:HomeComponent},
  {path:'',component:HomeComponent},
  {path:'login',component:LoginComponent},
  {path:'register',component:ReactiveRegisterComponent},
  {path:'menu',component:MenuComponent},
  {path:'activities',component:ActivitiesComponent},
  {path:'activities/:id',component:DetailedActvitiesComponent}
]

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    MenuComponent,
    ActivitiesComponent,
    ReactiveRegisterComponent,
    DetailedActvitiesComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forRoot(ROUTES)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
