import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { UserRegistrationDetails } from 'src/app/model/User-registration';
import { UserRegistrationService } from 'src/app/services/user registration/user-registration.service';
import { DomSanitizer } from '@angular/platform-browser';

@Component({
  selector: 'app-navbar2',
  templateUrl: './navbar2.component.html',
  styleUrls: ['./navbar2.component.css']
})
export class Navbar2Component implements OnInit {

  user : UserRegistrationDetails;

  constructor(  public sanitizer: DomSanitizer ,public userService :UserRegistrationService, public auth:AuthenticationService) { }

  sanitize(profile:string){ 
    return this.sanitizer.bypassSecurityTrustUrl(profile);
  }

  ngOnInit() {
 
  this.userService.getOneUser(parseInt(this.auth.getUserId())).subscribe((response:UserRegistrationDetails) => {
    this.user= response;
    this.user.profile = " http://localhost:8765/user-service/" +this.user.profile;
  });

}
}