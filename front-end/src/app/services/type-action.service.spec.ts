import { TestBed, inject } from '@angular/core/testing';

import { TypeActionService } from './type-action.service';

describe('TypeActionService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [TypeActionService]
    });
  });

  it('should be created', inject([TypeActionService], (service: TypeActionService) => {
    expect(service).toBeTruthy();
  }));
});
