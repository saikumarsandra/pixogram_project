import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthenticationService } from 'src/app/services/authentication.service';
import{ UserRegistrationDetails} from 'src/app/model/User-registration';
import { UserRegistrationService } from 'src/app/services/user registration/user-registration.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginid:string;
  loginpwd:string;
  submitted = false;
  errtext : string ;
  authorized : boolean;
  myFormGroup : FormGroup;



uesrlist:Array<UserRegistrationDetails>;
  



  // recieve authentication service in constructor
  // recieve Router service in constructor

  constructor(public auth : AuthenticationService , public router : Router, formBuilder : FormBuilder, public ser :UserRegistrationService) {
    this.errtext = "Invalid Credentials...";
    this.authorized = true;
    this.myFormGroup=formBuilder.group({
      "userid" : new FormControl("",[Validators.required,Validators.pattern('^[A-Za-z0-9]{3,10}$')]),
      "userpwd" : new FormControl("", [Validators.required,Validators.minLength(6),Validators.maxLength(10)])      
      
    }); 
    console.log( " inside constructer");

  }



  get f(){
    return this.myFormGroup.controls;
  }

 

  checkLogin(){
    this.loginid = this.myFormGroup.controls['userid'].value;
    this.loginpwd = this.myFormGroup.controls['userpwd'].value;
    this.submitted = true;
    this.auth.authenticate(this.loginid, this.loginpwd).subscribe(
      // success function
      successData=>{
        console.log("SUCCESS...");
        console.log(successData);
        this.authorized = true;
        this.router.navigate(['/mymedia']);
      },
      // failure function
      failureData => {
        console.log("FAILED!!!");
        this.authorized = false;
      }
    );
  
    }


  ngOnInit() {
  }

}