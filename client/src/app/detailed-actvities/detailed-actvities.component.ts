import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import {DetailedActivitiesService} from '../detailed-activities.service';
import {ActivitySchedule} from '../ActivitySchedule';
import 'rxjs/add/operator/switchMap';
@Component({
  selector: 'app-detailed-actvities',
  templateUrl: './detailed-actvities.component.html',
  styleUrls: ['./detailed-actvities.component.css'],
  providers:[DetailedActivitiesService]
})
export class DetailedActvitiesComponent implements OnInit {
  detailedActivities:ActivitySchedule[];

  constructor(private route: ActivatedRoute,
    private router: Router,
    private service: DetailedActivitiesService) { }

  ngOnInit() {
       this.service.getDetailedActivities(1).subscribe(data =>{this.detailedActivities = data;
         console.log("*** activity  "+this.detailedActivities);
       });
  }
}
