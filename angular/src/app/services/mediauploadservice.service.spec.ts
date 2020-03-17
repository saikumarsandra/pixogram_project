import { TestBed } from '@angular/core/testing';

import { MediauploadserviceService } from './mediauploadservice.service';

describe('MediauploadserviceService', () => {
  let service: MediauploadserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MediauploadserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
