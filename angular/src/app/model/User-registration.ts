export class UserRegistrationDetails{
  id:number;
    username:string;
    password:string;
   email:string;
   profile:any;
  
constructor(username,email,password,profile
              ){
                this.username =  username;
                this.email = email;
       
                this.password = password;
                this.profile = profile;
            

}

}