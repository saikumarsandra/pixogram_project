import { Component, OnInit } from '@angular/core';
import { UserRegistrationService } from 'src/app/services/user registration/user-registration.service';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { Router } from '@angular/router';
import { UserRegistrationDetails } from 'src/app/model/User-registration';

@Component({
  selector: 'app-blocked-users',
  templateUrl: './blocked-users.component.html',
  styleUrls: ['./blocked-users.component.css']
})
export class BlockedUsersComponent implements OnInit {

  constructor(public auth:AuthenticationService,public router:Router) { }
 
 
 

  
  ngOnInit() {
  }

}
