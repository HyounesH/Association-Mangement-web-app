import { TestBed, inject } from '@angular/core/testing';

import { LiquideService } from './liquide.service';

describe('LiquideService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [LiquideService]
    });
  });

  it('should be created', inject([LiquideService], (service: LiquideService) => {
    expect(service).toBeTruthy();
  }));
});
