import { TestBed, inject } from '@angular/core/testing';

import { TypeAdherentService } from './type-adherent.service';

describe('TypeAdherentService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [TypeAdherentService]
    });
  });

  it('should be created', inject([TypeAdherentService], (service: TypeAdherentService) => {
    expect(service).toBeTruthy();
  }));
});
