import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailedActvitiesComponent } from './detailed-actvities.component';

describe('DetailedActvitiesComponent', () => {
  let component: DetailedActvitiesComponent;
  let fixture: ComponentFixture<DetailedActvitiesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetailedActvitiesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailedActvitiesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
