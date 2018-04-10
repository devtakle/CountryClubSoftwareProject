import {Component} from '@angular/core';
import {ActivityService} from '../ActivityService/Activity-service.component';

@Component({
  moduleId: module.id,
  templateUrl: './Activity-list.component.html'
})
export class ActivityListComponent {

  ActivityList: any = [];
  constructor(private activityService: ActivityService) {

    activityService.getActivity()
               .subscribe(
                 Activitys => this.ActivityList = Activitys,
                 error => console.log(error)
                 );
  }
}
