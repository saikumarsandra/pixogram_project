import { Injectable } from '@angular/core';
import { UserRegistrationService } from './user registration/user-registration.service';
import { UserRegistrationDetails } from '../model/User-registration';
import {map} from 'rxjs/operators';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Response } from 'src/app/model/Rresponse.model';

const VALIDATION_URL = "http://localhost:8765/user-service/login";


@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  Id : number ;
  userlist : Array<UserRegistrationDetails>;
  constructor(public ser : UserRegistrationService,public http : HttpClient) { 
    this.ser.getAllUsers().subscribe((responce:any)=>{this.userlist=responce;console.log(responce)});
  }
  
  authenticate(username : string, password : string) {
   // create a security token
   // create a security token
   let authenticationToken = "Basic " + window.btoa(username + ":" + password);
   console.log(authenticationToken);

   let headers = new HttpHeaders({
     Authorization : authenticationToken
   });
   console.log("calling server")
   // send the request
   return this.http.get(VALIDATION_URL, {headers}).pipe(
     // success function
     map((successData : Response )=>{
       console.log("success fun")
       sessionStorage.setItem("user", username);
       // save the token
       let response : Response =successData;
       sessionStorage.setItem("token", authenticationToken);
       sessionStorage.setItem("userid", response.userId + "");
       return successData;
     }),
     
     // failure function
     map(failureData=>{
       // console message 
       console.log("failur fur")
       return failureData;
     })
   );
  }

  getAuthenticationToken(){
    if(this.isUserLoggedIn())
      return sessionStorage.getItem("token");
    return null; 
  }

  isUserLoggedIn(): boolean{
    let user = sessionStorage.getItem('user');
    if(user == null)
      return false;
    return true;  
  }
  getId():number{
    let a = Number(sessionStorage.getItem('uid'));
    console.log("in getid"+this.Id)
    return a;
  }

  
  logout(){
    
    sessionStorage.removeItem('user');
    sessionStorage.removeItem('uid');
    sessionStorage.clear();
    
  }

  getUserDetails():string{
    let user = sessionStorage.getItem('user');
    return user;
  }
  


getUserId():string{
  let user = sessionStorage.getItem('userid');
  return user;
}
}

