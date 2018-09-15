import { TestBed, inject } from '@angular/core/testing';

import { FonctionService } from './fonction.service';

describe('FonctionService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [FonctionService]
    });
  });

  it('should be created', inject([FonctionService], (service: FonctionService) => {
    expect(service).toBeTruthy();
  }));
});
