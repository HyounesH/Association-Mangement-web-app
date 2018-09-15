import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SortiesComponent } from './sorties.component';

describe('SortiesComponent', () => {
  let component: SortiesComponent;
  let fixture: ComponentFixture<SortiesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SortiesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SortiesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
