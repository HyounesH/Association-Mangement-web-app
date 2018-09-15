import { Injectable } from '@angular/core';
import {Http,Response,Headers,RequestOptions} from '@angular/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import'rxjs/add/observable/throw';
import { Observable } from 'rxjs/Observable';
import { Liquide } from '../entities/liquide';

@Injectable()
export class LiquideService {
  private baseUrl:string='http://localhost:8002/assocSat';
  private headers =new Headers({"Content-Type":"application/json"});
  private options=new RequestOptions({headers:this.headers});
  constructor(private _http:Http) { }

  errorHandler(error:Response){
    return Observable.throw(error || "SERVER ERROR");
 }

  getLiquides(){
    return this._http.get(this.baseUrl+'/liquides',this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }

  getLiquide(id:Number):Observable<Liquide>{
    return this._http.get(this.baseUrl+'/liquides/'+id,this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler)
  }
  deleteLiquide(id:Number){
    return this._http.delete(this.baseUrl+'/liquides/'+id,this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);

  }
  saveLiquide(liquide:Liquide){
    return this._http.post(this.baseUrl+'/liquides',this.liquideJson(liquide),this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }
  updateLiquide(liquide:Liquide){
    return this._http.put(this.baseUrl+'/liquides',JSON.stringify(liquide),this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }

  liquideJson(liquide:Liquide){
    return {montant:liquide.montant,date_depense:liquide.date_depense,type_depense:liquide.type_depense};
  }


}
