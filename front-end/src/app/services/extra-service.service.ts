import { HttpHeaders,HttpClient, HttpEvent,HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Response, Headers, RequestOptions} from '@angular/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import'rxjs/add/observable/throw';
import { Observable } from 'rxjs/Observable';
@Injectable()
export class ExtraServiceService {
  private baseUrl:string="https://battuta.medunes.net/api/country/all/?key=4cff4e9e446bdcd5c1d1d97e8f6eb79a";
  private headers =new Headers({"Content-Type":"application/json"});
  private options=new RequestOptions({headers:this.headers});
  private HttpHeaders


  constructor(private _http:HttpClient) { }



 /* postFile(fileToUpload: File){
    const endpoint = '../../app/images';
    const formData: FormData = new FormData();
    formData.append('png', fileToUpload, fileToUpload.name);
    return this._http
      .post(endpoint, formData, {headers: new HttpHeaders().set('Content-Type' , 'application/json; charset=UTF-8') })
      .map(()=>true)
      .catch((e) => this.errorHandler(e));
}*/
  getcountries(){
   return   this._http.get(this.baseUrl);
  }
  pushFileToStorage(file:File):Observable<HttpEvent<{}>>{
  const formData:FormData=new FormData();
  formData.append('file',file);
  const req= new HttpRequest('POST','http://localhost:8002/assocSat/post',formData,{
    reportProgress:true,
    responseType:'text'
  });
  return this._http.request(req);
 }
 getFile(filename:string){
  return this._http.get("http://localhost:8002/assocSat/files/Roundicons-36.png");
 }
  errorHandler(error:Response){
    return Observable.throw(error || "SERVER ERROR");
 }
}
