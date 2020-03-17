export class MediaResponse {
    id:number;
     userId:number;
     title:string;
    description:string;
    tags:string;
    mimeType:string;
    fileUrl:string;
 
     constructor(title,description,tags,mimetype,fileUrl){
         
   
      this.title=title;
       this.description=description;
      this.tags=tags;
      this. mimeType=mimetype;
       this.fileUrl=fileUrl;
    

    
    }
}
