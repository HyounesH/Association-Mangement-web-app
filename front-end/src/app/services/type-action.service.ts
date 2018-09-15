import { TypeAction } from './../entities/type-action';
import { Injectable } from '@angular/core';
import {Http,Response,Headers,RequestOptions} from '@angular/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import'rxjs/add/observable/throw';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class TypeActionService {
  private baseUrl:string='http://localhost:8002/assocSat';
  private headers =new Headers({"Content-Type":"application/json"});
  private options=new RequestOptions({headers:this.headers});
 // private clientOptions={ headers: new HttpHeaders().set('Content-Type' , 'application/json; charset=UTF-8') };
  constructor(private _http:Http) { }

  getTypeActions(){
    return this._http.get(this.baseUrl+'/typeActions',this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }

  getTypeAction(id:Number):Observable<TypeAction>{
    return this._http.get(this.baseUrl+'/typeActions/'+id,this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler)
  }
  deleteTypeAction(id:Number){
    return this._http.delete(this.baseUrl+'/typeActions/'+id,this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);

  }
  saveTypeAction(typeAction:TypeAction){
    return this._http.post(this.baseUrl+'/typeActions',this.typeActionJson(typeAction),this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }
  updateTypeAction(typeAction:TypeAction){
    return this._http.patch(this.baseUrl+'/typeActions',JSON.stringify(typeAction),this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }

  typeActionJson(typeAction:TypeAction){
  return {typeAction_nom:typeAction.typeAction_nom,typeAction_note:typeAction.typeAction_note};
  }

  errorHandler(error:Response){
     return Observable.throw(error || "SERVER ERROR");
  }
}
