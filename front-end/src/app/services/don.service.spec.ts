import { TestBed, inject } from '@angular/core/testing';

import { DonService } from './don.service';

describe('DonService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [DonService]
    });
  });

  it('should be created', inject([DonService], (service: DonService) => {
    expect(service).toBeTruthy();
  }));
});
