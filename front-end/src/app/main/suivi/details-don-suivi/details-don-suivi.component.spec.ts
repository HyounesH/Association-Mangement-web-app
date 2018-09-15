import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailsDonSuiviComponent } from './details-don-suivi.component';

describe('DetailsDonSuiviComponent', () => {
  let component: DetailsDonSuiviComponent;
  let fixture: ComponentFixture<DetailsDonSuiviComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetailsDonSuiviComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailsDonSuiviComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
