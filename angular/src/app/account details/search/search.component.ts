import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { FormGroup, FormControl, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { UserRegistrationService } from 'src/app/services/user registration/user-registration.service';
import { SearchedUser } from 'src/app/model/searchuser.model';
import { SearchedUserList } from 'src/app/model/searcheduser.model';
import { Follow } from 'src/app/model/follow.model';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  userSearchText : string;
  myFormGroup : FormGroup;
  searchedUsers : Array<SearchedUser>;
  result : string;
  follow : Follow;
  constructor(public auth : AuthenticationService, public formBuilder : FormBuilder , public userService : UserRegistrationService ) {
    console.log("in form bilder of search");
    this.myFormGroup=formBuilder.group({
      "search":new FormControl("")
    });

  }
  search(){
    console.log("Search method");
    this.userSearchText = this.myFormGroup.controls['search'].value;
    this.result = "You have Searched for : "+this.userSearchText;
    this.userService.getSearchedUsers(this.userSearchText).subscribe(
      (response : SearchedUserList) => {
        this.searchedUsers = response.userList;
        this.searchedUsers = this.searchedUsers.map(user =>{
          user.profile = "http://localhost:8765/user-service/"+user.profile;
          return user;
        });
        console.log(response);
        
      }
    );
  }
  message():void{
    
    alert("Logged out!!!");
    this.auth.logout();
  }
  doFollow(otherId : HTMLInputElement){
 
    this.follow = new Follow(Number(otherId.value),Number(sessionStorage.getItem("userid")));
    console.log(this.follow);
    this.userService.doFollow(this.follow).subscribe((response)=>{
      
    })

  }
  doUnFollow(otherId : HTMLInputElement){
    console.log(Number(otherId.value));
    this.userService.doUnFollow(Number(otherId.value)).subscribe((response)=>{
      
      //window.location.reload();
    });
  }
  ngOnInit() {
  }

}
