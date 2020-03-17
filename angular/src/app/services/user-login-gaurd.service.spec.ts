import { TestBed } from '@angular/core/testing';

import { UserLoginGaurdService } from './user-login-gaurd.service';

describe('UserLoginGaurdService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: UserLoginGaurdService = TestBed.get(UserLoginGaurdService);
    expect(service).toBeTruthy();
  });
});
