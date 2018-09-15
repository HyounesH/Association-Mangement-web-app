import { TestBed, inject } from '@angular/core/testing';

import { ReceveurDonService } from './receveur-don.service';

describe('ReceveurDonService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ReceveurDonService]
    });
  });

  it('should be created', inject([ReceveurDonService], (service: ReceveurDonService) => {
    expect(service).toBeTruthy();
  }));
});
