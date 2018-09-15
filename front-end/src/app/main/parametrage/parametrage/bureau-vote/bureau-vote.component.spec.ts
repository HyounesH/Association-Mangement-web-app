import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BureauVoteComponent } from './bureau-vote.component';

describe('BureauVoteComponent', () => {
  let component: BureauVoteComponent;
  let fixture: ComponentFixture<BureauVoteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BureauVoteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BureauVoteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
