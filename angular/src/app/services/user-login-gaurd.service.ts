import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { AuthenticationService } from './authentication.service';

@Injectable({
  providedIn: 'root'
})
export class UserLoggedInGuardService implements CanActivate {

  constructor(public authentication: AuthenticationService,public router: Router) { }
  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot)
  {
    if(!this.authentication.isUserLoggedIn())
    {
      return true;
    }
    else
    {
      this.router.navigateByUrl('/mymedia')
    }
  }
}