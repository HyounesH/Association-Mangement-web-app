import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DonneurInfoComponent } from './donneur-info.component';

describe('DonneurInfoComponent', () => {
  let component: DonneurInfoComponent;
  let fixture: ComponentFixture<DonneurInfoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DonneurInfoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DonneurInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
