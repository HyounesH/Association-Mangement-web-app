import { TestBed, inject } from '@angular/core/testing';

import { ActiviteService } from './activite.service';

describe('ActiviteService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ActiviteService]
    });
  });

  it('should be created', inject([ActiviteService], (service: ActiviteService) => {
    expect(service).toBeTruthy();
  }));
});
