import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailsAdherentComponent } from './details-adherent.component';

describe('DetailsAdherentComponent', () => {
  let component: DetailsAdherentComponent;
  let fixture: ComponentFixture<DetailsAdherentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetailsAdherentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailsAdherentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
