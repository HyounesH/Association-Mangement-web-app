import { TestBed, inject } from '@angular/core/testing';

import { BureauVoteService } from './bureau-vote.service';

describe('BureauVoteService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [BureauVoteService]
    });
  });

  it('should be created', inject([BureauVoteService], (service: BureauVoteService) => {
    expect(service).toBeTruthy();
  }));
});
