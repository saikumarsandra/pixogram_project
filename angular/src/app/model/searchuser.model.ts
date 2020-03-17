export class SearchedUser {
    userId : number ;
    username : string;
    profile : string;
    followed : boolean;
    constructor(userId,username,profile,followed){
         
        this.userId = userId;
        this.username = username;
        this.profile = profile;
        this.followed = followed;

     }
}