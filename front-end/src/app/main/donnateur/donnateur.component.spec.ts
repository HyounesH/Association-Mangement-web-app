import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DonnateurComponent } from './donnateur.component';

describe('DonnateurComponent', () => {
  let component: DonnateurComponent;
  let fixture: ComponentFixture<DonnateurComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DonnateurComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DonnateurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
