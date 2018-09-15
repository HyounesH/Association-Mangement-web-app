import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InfoGComponent } from './info-g.component';

describe('InfoGComponent', () => {
  let component: InfoGComponent;
  let fixture: ComponentFixture<InfoGComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InfoGComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InfoGComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
