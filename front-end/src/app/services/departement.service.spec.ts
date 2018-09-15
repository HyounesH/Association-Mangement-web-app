import { TestBed, inject } from '@angular/core/testing';

import { DepartementService } from './departement.service';

describe('DepartementService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [DepartementService]
    });
  });

  it('should be created', inject([DepartementService], (service: DepartementService) => {
    expect(service).toBeTruthy();
  }));
});
