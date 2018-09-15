import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListDonsComponent } from './list-dons.component';

describe('ListDonsComponent', () => {
  let component: ListDonsComponent;
  let fixture: ComponentFixture<ListDonsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListDonsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListDonsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
