import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { AuthenticationService } from './authentication.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuardService implements CanActivate{

  // recieve authentication service injected
  constructor(public auth : AuthenticationService, public router : Router) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {

      // check from authentication service is user is logged in
      if(this.auth.isUserLoggedIn())
          return true;
      else{
        // navigate to login component
        this.router.navigate(['/login']);
        return false;
      }    
          
  }

}