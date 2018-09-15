import { Fonction } from './../entities/fonction';
import { Injectable } from '@angular/core';
import {Http,Response,Headers,RequestOptions} from '@angular/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import'rxjs/add/observable/throw';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class FonctionService {

  private baseUrl:string='http://localhost:8002/assocSat';
  private headers =new Headers({"Content-Type":"application/json"});
  private options=new RequestOptions({headers:this.headers});
 // private clientOptions={ headers: new HttpHeaders().set('Content-Type' , 'application/json; charset=UTF-8') };
  constructor(private _http:Http) { }

  getFonctions(){
    return this._http.get(this.baseUrl+'/fonctions',this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }

  getFonction(id:Number):Observable<Fonction>{
    return this._http.get(this.baseUrl+'/fonctions/'+id,this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler)
  }
  deleteFonction(id:Number){
    return this._http.delete(this.baseUrl+'/fonctions/'+id,this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);

  }
  saveFonction(fonction:Fonction){
    return this._http.post(this.baseUrl+'/fonctions',this.fonctionJson(fonction),this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }
  updateFonction(fonction:Fonction){
    return this._http.patch(this.baseUrl+'/fonctions',JSON.stringify(fonction),this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }

  fonctionJson(fonction:Fonction){
  return {fonction_nom:fonction.fonction_nom,fonction_note:fonction.fonction_note,dateDebut:fonction.dateDebut,dateFin:fonction.dateFin};
  }

  errorHandler(error:Response){
     return Observable.throw(error || "SERVER ERROR");
  }
}
