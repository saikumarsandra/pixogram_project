import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { UserRegistrationService } from 'src/app/services/user registration/user-registration.service';
import { UserRegistrationDetails } from 'src/app/model/User-registration';
import { AuthenticationService } from 'src/app/services/authentication.service';

@Component({
  selector: 'app-account-update',
  templateUrl: './account-update.component.html',
  styleUrls: ['./account-update.component.css']
})
export class AccountUpdateComponent implements OnInit {
  
 
  constructor(public formBuilder:FormBuilder, public route : Router,public service:UserRegistrationService,public auth:AuthenticationService) {
   
   }


  ngOnInit() {
    
}
}
