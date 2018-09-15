import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdherentAddComponent } from './adherent-add.component';

describe('AdherentAddComponent', () => {
  let component: AdherentAddComponent;
  let fixture: ComponentFixture<AdherentAddComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdherentAddComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdherentAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
