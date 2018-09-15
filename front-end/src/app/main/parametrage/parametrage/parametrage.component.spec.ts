import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ParametrageComponent } from './parametrage.component';

describe('ParametrageComponent', () => {
  let component: ParametrageComponent;
  let fixture: ComponentFixture<ParametrageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ParametrageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ParametrageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
