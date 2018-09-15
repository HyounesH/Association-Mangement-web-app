import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListDonSuiviComponent } from './list-don-suivi.component';

describe('ListDonSuiviComponent', () => {
  let component: ListDonSuiviComponent;
  let fixture: ComponentFixture<ListDonSuiviComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListDonSuiviComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListDonSuiviComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
