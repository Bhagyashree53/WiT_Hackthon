import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OccupancyTableComponent } from './occupancy-table.component';

describe('OccupancyTableComponent', () => {
  let component: OccupancyTableComponent;
  let fixture: ComponentFixture<OccupancyTableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OccupancyTableComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OccupancyTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
