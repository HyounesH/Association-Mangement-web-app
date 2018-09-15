import { TestBed, inject } from '@angular/core/testing';

import { AdherentService } from './adherent.service';

describe('AdherentService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AdherentService]
    });
  });

  it('should be created', inject([AdherentService], (service: AdherentService) => {
    expect(service).toBeTruthy();
  }));
});
