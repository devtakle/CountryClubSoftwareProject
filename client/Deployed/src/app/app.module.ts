import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
// noinspection JSDeprecatedSymbols
import {HttpModule } from '@angular/http';
import { FormsModule , ReactiveFormsModule} from '@angular/forms';
import {Routes, RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { MenuComponent } from './menu/menu.component';
import { ReactiveRegisterComponent } from './reactive-register/reactive-register.component';
import {DetailedActvitiesComponent} from './detailed-actvities/detailed-actvities.component';
import {ActivityService} from './ActivityService/Activity-service.component';
import {ActivityListComponent} from './activities/activity-list.component';
import { LogoutComponent } from './logout/logout.component';

const ROUTES: Routes = [
  //{path:'',component:HomeComponent},
  {path: '', component: HomeComponent},
  {path: 'login', component: LoginComponent},
  {path: 'register', component: ReactiveRegisterComponent},
  {path: 'menu', component: MenuComponent},
  {path: 'activities', component: ActivityListComponent},
  {path: 'activities/:id', component: DetailedActvitiesComponent},
  {path: 'logout', component: LogoutComponent}
];

// noinspection JSDeprecatedSymbols
// noinspection JSDeprecatedSymbols
@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    MenuComponent,
    ActivityListComponent,
    ReactiveRegisterComponent,
    DetailedActvitiesComponent,
    LogoutComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forRoot(ROUTES)
  ],
  providers: [ ActivityService ],
  bootstrap: [AppComponent]
})
export class AppModule { }
