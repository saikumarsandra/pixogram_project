import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthenticationService } from 'src/app/services/authentication.service';

import { HttpClient } from '@angular/common/http';
import { UserRegistrationService } from 'src/app/services/user registration/user-registration.service';
import { MediauploadserviceService } from 'src/app/services/mediauploadservice.service';
import { Media } from 'src/app/model/media.model';

@Component({
  selector: 'app-single-media',
  templateUrl: './single-media.component.html',
  styleUrls: ['./single-media.component.css']
})
export class SingleMediaComponent implements OnInit {

  title1 : string;
  descpri1 : string;
  tag1 : string;
  file : any
  myFormGroup : FormGroup;
  selectedFiles: FileList;
  selectedFile : File;
  date : Date;
  public imagePath;
  imgURL: any;
 


  constructor(public formBuilder: FormBuilder, public mediaService : MediauploadserviceService,public router : Router ) {
    console.log("in form bUilder of single media");
    this.myFormGroup=formBuilder.group({
      "title":new FormControl(""),
      "description":new FormControl(""),
      "tags":new FormControl("")
    });

  }
  
onImageLoad(event){
  this.selectedFiles = event.target.files;
  this.selectedFile = this.selectedFiles.item(0);
  this.preview(this.selectedFiles);
}
preview(files){
  if (files.length === 0)
    return;

    // loop around to work on all files
  var mimeType = files[0].type;
  if (mimeType.match(/image\/*/) == null) {
    
    return;
  }

  // reads the content of file, so that it can be used for preview
  // without saving it to angular application folder
  var reader = new FileReader();
  this.imagePath = files;
  // reading file contents for preview
  reader.readAsDataURL(files[0]);
  // when images is loaded call the callback function
  reader.onload = (_event) => {
    this.imgURL = reader.result;
  }
}
Upload(){
    console.log("Single Media Details method");
    this.title1= this.myFormGroup.controls['title'].value;
    this.descpri1=this.myFormGroup.controls['description'].value;
    this.tag1=this.myFormGroup.controls['tags'].value;
    this.date=new Date();
    let dateString = `_${this.date.getTime()}_${this.date.getDate()}_${this.date.getFullYear()}`
    if (this.selectedFile.type == 'image/png') {
      this.file = `${this.title1}${dateString}.png`;
    }
    if (this.selectedFile.type == 'image/jpeg' || this.selectedFile.type == 'image/jpg') {
      this.file = `${this.title1}${dateString}.jpeg`;
    }
  
    console.log(this.file+"\n"+this.title1+"\n"+this.descpri1+"\n"+this.tag1);
    let uploadfile = new Media(this.file,this.title1,this.descpri1,this.tag1)

    this.mediaService.pushFileToStorage(this.selectedFile,this.title1,this.descpri1,this.tag1,this.file,this.selectedFile.type).subscribe(
      (responce)=>{this.router.navigate(['/mymedia/'])});
  }
message(){
  alert("you have uploaded the media & redirecting you to gallery")
}
  ngOnInit() {
  }

}







