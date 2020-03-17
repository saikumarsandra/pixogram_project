import { Injectable } from '@angular/core';
import { HttpClient, HttpEvent, HttpRequest } from '@angular/common/http';
import { AuthenticationService } from './authentication.service';
import { Observable } from 'rxjs';
import {UserRegistrationDetails} from 'src/app/model/User-registration';

@Injectable({
  providedIn: 'root'
})
export class UploadFileserviceService {


  baseUrl: string = 'http://localhost:8765/user-service/register';

  constructor(private http: HttpClient, public auth : AuthenticationService) { }
  pushFileToStorage(file: File,  userName,password,email, profile) : Observable<HttpEvent<{}>>{
    const formdata: FormData = new FormData();
    formdata.append('file', file, profile);
    formdata.append('userId', this.auth.getUserId());
    formdata.append('profile', profile);
    formdata.append('userName',userName);
    formdata.append('password',password);
    formdata.append('email',email);
    const req = new HttpRequest('POST', `${this.baseUrl}`, formdata, {
      reportProgress: true,
      responseType: 'text'
    });

    return this.http.request(req);
  }

}