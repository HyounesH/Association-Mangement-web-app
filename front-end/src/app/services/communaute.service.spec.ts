import { TestBed, inject } from '@angular/core/testing';

import { CommunauteService } from './communaute.service';

describe('CommunauteService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [CommunauteService]
    });
  });

  it('should be created', inject([CommunauteService], (service: CommunauteService) => {
    expect(service).toBeTruthy();
  }));
});
