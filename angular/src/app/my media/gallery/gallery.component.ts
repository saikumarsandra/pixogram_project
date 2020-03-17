import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';


import { UserRegistrationService } from 'src/app/services/user registration/user-registration.service';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { DomSanitizer } from '@angular/platform-browser';
import { MediaResponse } from 'src/app/model/mediaResponse.model';
import { MediauploadserviceService } from 'src/app/services/mediauploadservice.service';
import { Media } from 'src/app/model/media.model';
import { RetrieveMedia } from 'src/app/model/mediaretrive.model';

@Component({
  selector: 'app-gallery',
  templateUrl: './gallery.component.html',
  styleUrls: ['./gallery.component.css']
})
export class GalleryComponent implements OnInit {
  

  mymedia:Array<RetrieveMedia>

  constructor(private sanitizer:DomSanitizer ,private userService: UserRegistrationService, private authService: AuthenticationService, private router: Router,public ms:MediauploadserviceService) {
  
  
    this.ms.getAllMedia().subscribe((responce:any)=>{this.mymedia=responce;console.log(responce)});
   // this.ms.getMediaById(parseInt(this.authService.getUserId())).subscribe((responce:any)=>{this.mymedia=responce;console.log(responce)});
  
   }
   userId:string;
  


   getDetails(id : number){
    console.log(id);
    this.router.navigate(['/aboutmedia/'+id])
   }

  ngOnInit() {
    this.userId=this.authService.getUserId();
    this.userService.getAllMedia(this.userId).subscribe(data=>{
      this.mymedia=data;
      for(let media of this.mymedia)
      {
        media.url="http://localhost:8765/media-service/"+media.type;
      }
    });
  }
}
