import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import {DetailedActivitiesService} from '../detailed-activities.service';
import {ActivitySchedule} from '../ActivitySchedule';
import 'rxjs/add/operator/switchMap';
import {RegisterForActivity} from './RegisterForActivity';
@Component({
  selector: 'app-detailed-actvities',
  templateUrl: './detailed-actvities.component.html',
  styleUrls: ['./detailed-actvities.component.css'],
  providers: [DetailedActivitiesService]
})
export class DetailedActvitiesComponent {
  toShowRegistered:boolean = false;
  toShowAlreadyRegistered:boolean = false;
  toShowNoSpaceLeft:boolean = false;
  detailedActivities: ActivitySchedule[];
  recivedMessage:String;
  registerModel:RegisterForActivity;

  register(activityId){
    console.log("*********inside register*********"+activityId);
    this.service.registerForActivity(activityId)
    .subscribe(message => {
      this.registerModel = message;
      console.log("******"+this.registerModel.registrationMessage+"*****");
      if(this.registerModel.registrationMessage == "You are already registered for this activity"){
        this.toShowAlreadyRegistered = true;
      }
      if(this.registerModel.registrationMessage == "No space left for this activity"){
        this.toShowNoSpaceLeft = true;
      }
      if(this.registerModel.registrationMessage == "You are registered for the activity"){
        this.toShowRegistered = true;
      }
    }

    )

  }
  onSuccess(){
      this.router.navigate(['/menu'])
  }

  constructor(private route: ActivatedRoute,
              private router: Router,
              private service: DetailedActivitiesService) {

    this.route.params.subscribe(
      params => {
        service.getDetailedActivities(params['id'])
          .subscribe(
            data => this.detailedActivities = data,
            error => console.log(error)
          );
      });

  }
}
