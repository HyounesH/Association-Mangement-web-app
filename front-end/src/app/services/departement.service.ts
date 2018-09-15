import { Departement } from './../entities/departement';
import { Injectable } from '@angular/core';

import {Http,Response,Headers,RequestOptions} from '@angular/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import'rxjs/add/observable/throw';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class DepartementService {

  private baseUrl:string='http://localhost:8002/assocSat';
  private headers =new Headers({"Content-Type":"application/json"});
  private options=new RequestOptions({headers:this.headers});
  private _depart:Departement;
  constructor(private _http:Http) { }

  getDeparts(){
    return this._http.get(this.baseUrl+'/departements',this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }

  getDepart(id:Number){
    return this._http.get(this.baseUrl+'/departements/'+id,this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler)
  }
  deleteDepart(id:Number){
    return this._http.delete(this.baseUrl+'/departements/'+id,this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);

  }
  saveDepart(depart:Departement){
    return this._http.post(this.baseUrl+'/departements',this.departementJson(depart),this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }
  updateDepart(depart:Departement){
    return this._http.put(this.baseUrl+'/departements',JSON.stringify(depart),this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }
  errorHandler(error:Response){
     return Observable.throw(error || "SERVER ERROR");
  }
  getter(){
    return this._depart;
  }
  setter(value:Departement){
    this._depart=new Departement();
    this._depart=value;
  }
  departementJson(departement:Departement){
    return {nom:departement.nom,note:departement.note,adresse:departement.adresse,telephone:departement.telephone};
  }


}
