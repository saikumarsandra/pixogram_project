import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { UserRegistrationDetails } from 'src/app/model/User-registration';
import { Router } from '@angular/router';
import { UserRegistrationService } from 'src/app/services/user registration/user-registration.service';
import { DomSanitizer } from '@angular/platform-browser';
import { MediauploadserviceService } from 'src/app/services/mediauploadservice.service';

@Component({
  selector: 'app-followers-following',
  templateUrl: './followers-following.component.html',
  styleUrls: ['./followers-following.component.css']
})
export class FollowersFollowingComponent implements OnInit {

  mymedia:Array<UserRegistrationDetails>

  constructor(private sanitizer:DomSanitizer ,private userService: UserRegistrationService, private authService: AuthenticationService, private router: Router,public ms:MediauploadserviceService) {
  
  
   }
   userId:string;
   id:number;


  
  ngOnInit() {
    this.userId=this.authService.getUserId();
    this.userService.getAllUsers().subscribe;
    
      for(let media of this.mymedia)
      {
        media.profile="http://localhost:8765/user-service/"+media.profile;
      }
    
  }
}

