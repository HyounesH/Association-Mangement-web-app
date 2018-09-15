import { Injectable } from '@angular/core';
import {Http,Response,Headers,RequestOptions} from '@angular/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import'rxjs/add/observable/throw';
import { Observable } from 'rxjs/Observable';
import { Activite } from '../entities/activite';
@Injectable()
export class ActiviteService {
  private baseUrl:string='http://localhost:8002/assocSat';
  private headers =new Headers({"Content-Type":"application/json"});
  private options=new RequestOptions({headers:this.headers});
  private _activite:Activite;
  constructor(private _http:Http) { }

  getActivites(){
    return this._http.get(this.baseUrl+'/actions',this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }

  getActivite(id:Number){
    return this._http.get(this.baseUrl+'/actions/'+id,this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler)
  }
  deleteActivite(id:Number){
    return this._http.delete(this.baseUrl+'/actions/'+id,this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);

  }
  saveActivite(activite:Activite){
    return this._http.post(this.baseUrl+'/actions',this.ActiviteJson(activite),this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }
  updateActivite(activite:Activite){
    return this._http.put(this.baseUrl+'/actions',this.updateJsonActivite(activite),this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }
  errorHandler(error:Response){
     return Observable.throw(error || "SERVER ERROR");
  }
  getter(){
    return this._activite;
  }
  setter(value:Activite){
  this._activite=new Activite();
  this._activite=value;
  }
  ActiviteJson(activite:Activite){
  return {action_nom:activite.action_nom,lieu:activite.lieu,dateCreation:new Date(),dateRealise:activite.dateRealise,objectif:activite.objectif};
  }
  updateJsonActivite(activite:Activite){
    return {action_id:activite.action_id,action_nom:activite.action_nom,lieu:activite.lieu,dateCreation:new Date(),dateRealise:activite.dateRealise,objectif:activite.objectif}
  }

}
