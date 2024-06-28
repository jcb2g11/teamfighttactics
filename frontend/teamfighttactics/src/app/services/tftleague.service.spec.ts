import { TestBed } from '@angular/core/testing';

import { TftleagueService } from './tftleague.service';

describe('TftleagueService', () => {
  let service: TftleagueService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TftleagueService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
