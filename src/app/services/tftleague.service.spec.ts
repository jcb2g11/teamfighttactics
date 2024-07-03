import { TestBed } from '@angular/core/testing';

import { TftLeagueService } from './tftleague.service';

describe('TftleagueService', () => {
  let service: TftLeagueService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TftLeagueService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
