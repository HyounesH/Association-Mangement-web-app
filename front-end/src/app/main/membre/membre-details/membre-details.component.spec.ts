import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MembreDetailsComponent } from './membre-details.component';

describe('MembreDetailsComponent', () => {
  let component: MembreDetailsComponent;
  let fixture: ComponentFixture<MembreDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MembreDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MembreDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
