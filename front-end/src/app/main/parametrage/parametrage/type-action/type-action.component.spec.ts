import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TypeActionComponent } from './type-action.component';

describe('TypeActionComponent', () => {
  let component: TypeActionComponent;
  let fixture: ComponentFixture<TypeActionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TypeActionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TypeActionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
