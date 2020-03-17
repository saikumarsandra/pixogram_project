import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup , FormControl, Validators} from '@angular/forms';
import { Router } from '@angular/router';
import { UserRegistrationService } from 'src/app/services/user registration/user-registration.service';
import { UserRegistrationDetails } from 'src/app/model/User-registration';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { UploadFileserviceService } from 'src/app/services/upload-fileservice.service';
import { HttpEvent, HttpEventType, HttpResponse } from '@angular/common/http';
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  public imagePath;
  imgURL: any;
  public message: string;

  selectedFiles: FileList;
  currentFileUpload: File;
  // dynamic class containing only one field 
  // anonymous class
  progress: { percentage: number } = { percentage: 0 };

  
  userId : string;
  url : string;
  date : Date;

  submitted : boolean = false;

  username : string;
  email : string;
  password : string;
  
  profile : any;
  avilable:string="";
  validate : boolean=false;
  myFormGroup : FormGroup;
  userlist : Array<UserRegistrationDetails>;
  constructor(public details : UserRegistrationService,public auth : AuthenticationService,public uploadService : UploadFileserviceService  ,public router : Router, formBuilder: FormBuilder) {
    console.log("in form bilder of reg");
    this.myFormGroup=formBuilder.group({
     
      "username" : new FormControl(""),
      "email" : new FormControl(""),
      "password" : new FormControl(""),
      "repassword" : new FormControl(""),
 
      "profile" : new FormControl("")
    });

  }
  
  get f(){return this.myFormGroup.controls;}
  
  register(){
    console.log("Registration method");
    this.submitted = true;
    if(this.myFormGroup.valid){
    
    this.password=this.myFormGroup.controls['password'].value;
    console.log(this.password);
    this.username=this.myFormGroup.controls['username'].value;
    
    this.email=this.myFormGroup.controls['email'].value;
    
    this.progress.percentage = 0;
    this.currentFileUpload = this.selectedFiles.item(0);
   
    this.date = new Date();
    let dateString = `_${this.date.getTime()}_${this.date.getDate()}_${this.date.getFullYear()}`
    if (this.currentFileUpload.type == 'image/png') {
      this.profile = `${this.username}${dateString}.png`;
    }
    if (this.currentFileUpload.type == 'image/jpeg' || this.currentFileUpload.type == 'image/jpg') {
      this.profile = `${this.username}${dateString}.jpeg`;
    }
    console.log(this.profile);
    console.log(this.username);
    this.uploadService.pushFileToStorage(this.currentFileUpload,this.username,this.password,this.email,this.profile).subscribe((event:HttpEvent<{}>) => {
  
    if (event.type === HttpEventType.UploadProgress) {
  
      this.progress.percentage = Math.round(100 * event.loaded / event.total);
    } else if (event instanceof HttpResponse) {
  
      this.router.navigate(['/login']);
      console.log('File is completely uploaded!');
    
    }
  });

   }else{
     return alert("Please enter valid details..")
   }
  
}
selectFile(event) {
  this.selectedFiles = event.target.files;
  this.preview(this.selectedFiles);
}

// list of files selected
preview(files){
  if (files.length === 0)
    return;

    // loop around to work on all files
  var mimeType = files[0].type;
  if (mimeType.match(/image\/*/) == null) {
    this.message = "Only images are supported.";
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

  ngOnInit() {
    this.userId = this.auth.getUserId();
    this.details.getAllUsers().subscribe((responce:any)=>{this.userlist=responce;console.log(responce)});
  }

}
