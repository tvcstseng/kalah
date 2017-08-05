import { TestBed, inject } from '@angular/core/testing';

import { KalahGameService } from './kalah-game.service';

describe('KalahGameService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [KalahGameService]
    });
  });

  it('should be created', inject([KalahGameService], (service: KalahGameService) => {
    expect(service).toBeTruthy();
  }));
});
