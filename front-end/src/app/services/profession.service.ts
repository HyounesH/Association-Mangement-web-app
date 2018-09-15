import { Injectable } from '@angular/core';
//import {HttpClient, HttpHeaders} from '@angular/common/http';

import {Http,Response,Headers,RequestOptions} from '@angular/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import'rxjs/add/observable/throw';
import { Observable } from 'rxjs/Observable';
import { Profession } from '../entities/profession';

@Injectable()
export class ProfessionService {
  private baseUrl:string='http://localhost:8002/assocSat';
  private headers =new Headers({"Content-Type":"application/json"});
  private options=new RequestOptions({headers:this.headers});
 // private clientOptions={ headers: new HttpHeaders().set('Content-Type' , 'application/json; charset=UTF-8') };
  constructor(private _http:Http) { }

  getProfessions(){
    return this._http.get(this.baseUrl+'/professions',this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }

  getProfession(id:Number){
    return this._http.get(this.baseUrl+'/professions/'+id,this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler)
  }
  deleteProfession(id:Number){
    return this._http.delete(this.baseUrl+'/professions/'+id,this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);

  }
  saveProfession(profession:Profession){
    return this._http.post(this.baseUrl+'/professions',this.ProfessionJson(profession),this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }
  updateProfession(profession:Profession){
    return this._http.put(this.baseUrl+'/professions',JSON.stringify(profession),this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }

  errorHandler(error:Response){
     return Observable.throw(error || "SERVER ERROR");
  }
  ProfessionJson(profession:Profession){
  return {prefession_nom:profession.prefession_nom,profession_note:profession.profession_note};
  }

}
