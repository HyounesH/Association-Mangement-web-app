import { Communaute } from './../entities/communaute';
import { Injectable } from '@angular/core';
import {Http,Response,Headers,RequestOptions} from '@angular/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import'rxjs/add/observable/throw';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class CommunauteService {
  private baseUrl:string='http://localhost:8002/assocSat';
  private headers =new Headers({"Content-Type":"application/json"});
  private options=new RequestOptions({headers:this.headers});
  private _communaute:Communaute;
  constructor(private _http:Http) { }

  getCommunautes(){
    return this._http.get(this.baseUrl+'/communautes',this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }

  getCommunaute(id:Number){
    return this._http.get(this.baseUrl+'/communautes/'+id,this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler)
  }
  deleteCommunaute(id:Number){
    return this._http.delete(this.baseUrl+'/communautes/'+id,this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);

  }
  saveCommunaute(communaute:Communaute){
    return this._http.post(this.baseUrl+'/communautes',this.communauteSaveJson(communaute),this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }
  updateCommunaute(communaute:Communaute){
    return this._http.put(this.baseUrl+'/communautes',JSON.stringify(communaute),this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }

  errorHandler(error:Response){
     return Observable.throw(error || "SERVER ERROR");
  }
  communauteSaveJson(communaute:Communaute){
    return {nom_communaute:communaute.nom_communaute};
  }
}
