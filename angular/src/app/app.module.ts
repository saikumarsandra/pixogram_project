import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule} from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './menubar/navbar/navbar.component';
import { Navbar2Component } from './menubar/navbar2/navbar2.component';
import { LoginComponent } from './authorization/login/login.component';
import { RegisterComponent } from './authorization/register/register.component';
import { SingleMediaComponent } from './upload media/single-media/single-media.component';
import { MultipleMediaComponent } from './upload media/multiple-media/multiple-media.component';
import { MyMediaDetailsComponent } from './my media/my-media-details/my-media-details.component';
import { AccountUpdateComponent } from './account details/account-update/account-update.component';
import { NewsfeedComponent } from './account details/newsfeed/newsfeed.component';
import { BlockedUsersComponent } from './account details/blocked-users/blocked-users.component';
import { SearchComponent } from './account details/search/search.component';
import { LogoutComponent } from './account details/logout/logout.component';
import { FollowersFollowingComponent } from './following/folowers/followers-following/followers-following.component';
import { GalleryComponent } from './my media/gallery/gallery.component';
import { ErrorComponent } from './error/error.component';
import {HttpClientModule} from '@angular/common/http';


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    Navbar2Component,
    LoginComponent,
    RegisterComponent,
    SingleMediaComponent,
    MultipleMediaComponent,
    MyMediaDetailsComponent,
    AccountUpdateComponent,
    NewsfeedComponent,
    BlockedUsersComponent,
    SearchComponent,
    LogoutComponent,
    FollowersFollowingComponent,
    GalleryComponent,
    ErrorComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule, ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
