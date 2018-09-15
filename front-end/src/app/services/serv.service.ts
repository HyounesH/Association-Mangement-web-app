import { Injectable } from '@angular/core';

import {Http,Response,Headers,RequestOptions} from '@angular/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import'rxjs/add/observable/throw';
import { Observable } from 'rxjs/Observable';
import { Serv } from '../entities/serv';

@Injectable()
export class ServService {
  private baseUrl:string='http://localhost:8002/assocSat';
  private headers =new Headers({"Content-Type":"application/json"});
  private options=new RequestOptions({headers:this.headers});
  private _service:Serv;
  constructor(private _http:Http) { }

  getServices(){
    return this._http.get(this.baseUrl+'/services',this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }

  getService(id:Number){
    return this._http.get(this.baseUrl+'/services/'+id,this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler)
  }
  deleteService(id:Number){
    return this._http.delete(this.baseUrl+'/services/'+id,this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);

  }
  saveService(service:Serv){
    return this._http.post(this.baseUrl+'/services',this.serviceJson(service),this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }

  updateService(service:Serv){
    return this._http.put(this.baseUrl+'/services',this.serviceUpdateJson(service),this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }
  errorHandler(error:Response){
     return Observable.throw(error || "SERVER ERROR");
  }
  getter(){
    return this._service;
  }
  setter(value:Serv){
  this._service=new Serv();
  this._service=value;
  }
  serviceJson(service:Serv){
  return {nom:service.nom,adresse:service.adresse};
  }
  serviceUpdateJson(service:Serv){
    return {id_service:service.id_service,nom:service.nom,adresse:service.adresse};
  }

}
