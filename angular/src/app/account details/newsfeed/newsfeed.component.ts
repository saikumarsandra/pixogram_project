import { Component, OnInit } from '@angular/core';
import { NewsFeed } from 'src/app/model/NewsFeed.model';
import { UserRegistrationService } from 'src/app/services/user registration/user-registration.service';
import { AuthenticationService } from 'src/app/services/authentication.service';

@Component({
  selector: 'app-newsfeed',
  templateUrl: './newsfeed.component.html',
  styleUrls: ['./newsfeed.component.css']
})
export class NewsfeedComponent implements OnInit {
feeds:NewsFeed[];

  constructor( public auth:AuthenticationService, public userservice:UserRegistrationService) { }

  ngOnInit() {
    this.userservice.getAllFeed(this.auth.getUserId()).subscribe(data=>{
      this.feeds=data;
    })
  }

}
