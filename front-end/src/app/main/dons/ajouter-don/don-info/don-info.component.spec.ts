import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DonInfoComponent } from './don-info.component';

describe('DonInfoComponent', () => {
  let component: DonInfoComponent;
  let fixture: ComponentFixture<DonInfoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DonInfoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DonInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
