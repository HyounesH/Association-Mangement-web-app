import { ReceveurDon } from './../entities/receveur-don';
import { Injectable } from '@angular/core';
import {Http,Response,Headers,RequestOptions} from '@angular/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import'rxjs/add/observable/throw';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class ReceveurDonService {
  private baseUrl:string='http://localhost:8002/assocSat';
  private headers =new Headers({"Content-Type":"application/json"});
  private options=new RequestOptions({headers:this.headers});
 // private clientOptions={ headers: new HttpHeaders().set('Content-Type' , 'application/json; charset=UTF-8') };
  constructor(private _http:Http) { }

  getReceveurDons(){
    return this._http.get(this.baseUrl+'/receveurDons',this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }

  getReceveurDon(id:Number):Observable<ReceveurDon>{
    return this._http.get(this.baseUrl+'/receveurDons/'+id,this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler)
  }
  deleteReceveurDon(id:Number){
    return this._http.delete(this.baseUrl+'/receveurDons/'+id,this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);

  }
  saveReceveurDon(code_employe:Number){
    return this._http.post(this.baseUrl+'/receveurDons',this.receveurDonJson(code_employe),this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }
  updateReceveurDon(receveurDon:ReceveurDon){
    return this._http.patch(this.baseUrl+'/receveurDons',JSON.stringify(receveurDon),this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }

  receveurDonJson(_code_employee:Number){
    return {code_employe:_code_employee};
  }

  errorHandler(error:Response){
     return Observable.throw(error || "SERVER ERROR");
  }
}
