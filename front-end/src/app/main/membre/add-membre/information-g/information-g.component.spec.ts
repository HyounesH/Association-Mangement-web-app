import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InformationGComponent } from './information-g.component';

describe('InformationGComponent', () => {
  let component: InformationGComponent;
  let fixture: ComponentFixture<InformationGComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InformationGComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InformationGComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
