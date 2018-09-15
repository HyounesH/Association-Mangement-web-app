import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AjouterDonComponent } from './ajouter-don.component';

describe('AjouterDonComponent', () => {
  let component: AjouterDonComponent;
  let fixture: ComponentFixture<AjouterDonComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AjouterDonComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AjouterDonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
