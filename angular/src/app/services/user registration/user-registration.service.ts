import { Injectable } from '@angular/core';
import{ HttpClient} from '@angular/common/http';
import { UserRegistrationDetails} from 'src/app/model/User-registration';
import { Observable } from 'rxjs';
import { RetrieveMedia } from 'src/app/model/mediaretrive.model';
import { Follow } from 'src/app/model/follow.model';
import { NewsFeed } from 'src/app/model/NewsFeed.model';


const API_URL = "http://localhost:8765/user-service/users";
const REGISTER_URL = "http://localhost:8765/user-service/register";

const MISC_URL = "http://localhost:8765/misc-plumbing";
const UsernamesURL = "http://localhost:8765/user-service/username"; 
const FOLLOW_URL = "http://localhost:8765/follow-service"
@Injectable({
  providedIn: 'root'
})
export class UserRegistrationService {
  Ret_url="http://localhost:8765/media-plumbing/media/";
  News_Feed="http://localhost:9091/newsfeeds/";
  username: String="";
  id: number;
  email: String="";
  constructor(public http : HttpClient) { 

  }

  doFollow(follow : Follow):any{
    return this.http.post(FOLLOW_URL+"/follow",follow);
   }
   doUnFollow(other : number):any{
     console.log(other);
     return this.http.delete(FOLLOW_URL+"/unfollow/mine/"+sessionStorage.getItem("userid")+"/other/"+other);
   }


  getSearchedUsers(searchText : string){
    return this.http.get(MISC_URL + "/searched-users/" + searchText + "/myid/" + sessionStorage.getItem("userid"));
  }
 getAllUsernames():any{
   return this.http.get(UsernamesURL);
 }

 getAllFeed(userid:string):Observable<NewsFeed[]>{
   {
     return this.http.get<NewsFeed[]>(this.News_Feed+userid);
   }

 }

  getAllUsers(){
    // send request to server to get all products
    // this.http.post(API_URL);
    // will send a request to API_URL with http verb GET(retrieval)
    // method will wait for data to receive
    // return data back to component
    return this.http.get(API_URL);
  }

  // method to send new object(product) to server
  addNewUser(User : UserRegistrationDetails){
    // POST http verb
    return this.http.post(REGISTER_URL,User );
  }

  // methid to get single record of given id
  getOneUser(id:number):any{
    // GET http verb
    return this.http.get(API_URL + "/" + id);

  }

  // method to send updated object(product) to server
  updateUser(id:number, user : UserRegistrationDetails){
    // PUT http verb
    return this.http.put(API_URL + "/" + id, user);
  }
  getUserId():string{
    let user = sessionStorage.getItem('userid');
    return user;
  }
  getAllMedia(userid:string):Observable<RetrieveMedia[]>
  {
    return this.http.get<RetrieveMedia[]>(this.Ret_url+userid);
  }
 

  }








  

