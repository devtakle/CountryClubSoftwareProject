import { TestBed, inject } from '@angular/core/testing';

import { DetailedActivitiesService } from './detailed-activities.service';

describe('DetailedActivitiesService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [DetailedActivitiesService]
    });
  });

  it('should be created', inject([DetailedActivitiesService], (service: DetailedActivitiesService) => {
    expect(service).toBeTruthy();
  }));
});
