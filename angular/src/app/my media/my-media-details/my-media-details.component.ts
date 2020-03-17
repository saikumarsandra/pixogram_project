import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { Media } from 'src/app/model/media.model';
import { ActivatedRoute } from '@angular/router';
import { MediauploadserviceService } from 'src/app/services/mediauploadservice.service';
import { RetrieveMedia } from 'src/app/model/mediaretrive.model';

@Component({
  selector: 'app-my-media-details',
  templateUrl: './my-media-details.component.html',
  styleUrls: ['./my-media-details.component.css']
})
export class MyMediaDetailsComponent implements OnInit {
  id : number;
  file : RetrieveMedia;
  constructor(public auth:AuthenticationService,public activatedRoute : ActivatedRoute , public mediaService: MediauploadserviceService) { }

  ngOnInit() {
    this.activatedRoute.params.subscribe((parameter) => this.id = parameter["mid"]);
    console.log(this.id);
   // this.mediaService.getMedia(this.id).subscribe((response)=>this.file=response);
    this.mediaService.getMedia(this.id).subscribe(data=>{
      data.url="http://localhost:8765/media-service/" + data.url;
      this.file=data;
      console.log(this.file);
  })
  
  }
}