import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DeparetementComponent } from './deparetement.component';

describe('DeparetementComponent', () => {
  let component: DeparetementComponent;
  let fixture: ComponentFixture<DeparetementComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DeparetementComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DeparetementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
