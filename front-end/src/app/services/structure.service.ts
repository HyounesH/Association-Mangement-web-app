import { Injectable } from '@angular/core';

import {Http,Response,Headers,RequestOptions} from '@angular/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import'rxjs/add/observable/throw';
import { Observable } from 'rxjs/Observable';
import { Structure } from '../entities/structure';

@Injectable()
export class StructureService {
  private baseUrl:string='http://localhost:8002/assocSat';
  private headers =new Headers({"Content-Type":"application/json"});
  private options=new RequestOptions({headers:this.headers});
  private _structure:Structure;
  constructor(private _http:Http) { }

  getStructures(){
    return this._http.get(this.baseUrl+'/structures',this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }

  getStructure(id:Number){
    return this._http.get(this.baseUrl+'/structures/'+id,this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler)
  }
  deleteStructure(id:Number){
    return this._http.delete(this.baseUrl+'/structures/'+id,this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);

  }
  saveStructure(structure:Structure){
    return this._http.post(this.baseUrl+'/structures',this.structureJson(structure),this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }
  updateStructure(structure:Structure){
    return this._http.put(this.baseUrl+'/structures',JSON.stringify(structure),this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }
  errorHandler(error:Response){
     return Observable.throw(error || "SERVER ERROR");
  }
  getter(){
    return this._structure;
  }
  setter(value:Structure){
  this._structure=new Structure();
  this._structure=value;
  }
  structureJson(structure:Structure){
    return {nom:structure.nom,dateCreation:new Date(),email:structure.email,siteWeb:structure.siteWeb,objectif:structure.objectif,logo:"logo.png",adresse:structure.adresse,telephone:structure.telephone};
  }
}
