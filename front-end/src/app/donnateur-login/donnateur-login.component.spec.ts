import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DonnateurLoginComponent } from './donnateur-login.component';

describe('DonnateurLoginComponent', () => {
  let component: DonnateurLoginComponent;
  let fixture: ComponentFixture<DonnateurLoginComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DonnateurLoginComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DonnateurLoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
