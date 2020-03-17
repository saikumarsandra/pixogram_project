import { Injectable } from '@angular/core';
import { HttpClient, HttpEvent, HttpRequest } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UserRegistrationService } from './user registration/user-registration.service';
import { RetrieveMedia } from '../model/mediaretrive.model';
const BasicURL = "http://localhost:3000/mediafiles";
@Injectable({
  providedIn: 'root'
})
export class MediauploadserviceService {
  baseUrl: string = 'http://localhost:8765/media-plumbing/media';
  baseUrlForSingleImage = 'http://localhost:8765/media-plumbing/mediadetails'
  constructor(public http : HttpClient,public ur:UserRegistrationService ) { }
  
  getAllMedia():any{
    return this.http.get(this.baseUrl);
  }

 // getMediaById(id:number):any{
  //  return this.http.get(this.baseUrl+"/"+sessionStorage.getItem(this.ur.getUserId()));

 // }

  getMedia(id : number) :Observable<RetrieveMedia>{
    console.log(id);
    console.log(this.http.get(this.baseUrlForSingleImage+"/"+id));
    return this.http.get<RetrieveMedia>(this.baseUrlForSingleImage+"/"+id);
  }
 


  
  
  pushFileToStorage(file: File,title,description,tags,url,type) : Observable<HttpEvent<{}>>{
    
    const formdata: FormData = new FormData();


    formdata.append('file', file, url);
    formdata.append('title',title)
    formdata.append('description',description)
    formdata.append('type',type)
    console.log("userid in media : "+sessionStorage.getItem("userid"))
    formdata.append('userid',sessionStorage.getItem("userid"))
    formdata.append("tags",tags)
    formdata.append('url',url)
    


    const req = new HttpRequest('POST', `${this.baseUrl}`, formdata, {
      reportProgress: true,
      responseType: 'text'
    });

    return this.http.request(req);
  }
}
