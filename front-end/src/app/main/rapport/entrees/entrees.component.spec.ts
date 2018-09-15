import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EntreesComponent } from './entrees.component';

describe('EntreesComponent', () => {
  let component: EntreesComponent;
  let fixture: ComponentFixture<EntreesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EntreesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EntreesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
