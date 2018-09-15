import { TestBed, inject } from '@angular/core/testing';

import { DonneurService } from './donneur.service';

describe('DonneurService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [DonneurService]
    });
  });

  it('should be created', inject([DonneurService], (service: DonneurService) => {
    expect(service).toBeTruthy();
  }));
});
