import { TestBed } from '@angular/core/testing';

import { UploadFileserviceService } from './upload-fileservice.service';

describe('UploadFileserviceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: UploadFileserviceService = TestBed.get(UploadFileserviceService);
    expect(service).toBeTruthy();
  });
});
