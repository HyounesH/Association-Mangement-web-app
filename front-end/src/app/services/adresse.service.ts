import { Injectable } from '@angular/core';
import {Http,Response,Headers,RequestOptions} from '@angular/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import'rxjs/add/observable/throw';
import { Observable } from 'rxjs/Observable';
import { Adresse } from '../entities/adresse';

@Injectable()
export class AdresseService {

  private baseUrl:string='http://localhost:8002/assocSat';
  private headers =new Headers({"Content-Type":"application/json"});
  private options=new RequestOptions({headers:this.headers});
  constructor(private _http:Http) { }
saveAdresse(adresse:Adresse,_adherent_id:Number){
return this._http.post(this.baseUrl+'/adresses',this.adresseToJson(adresse,_adherent_id),this.options).map((response:Response)=>response.json())
.catch(this.errorHandler);
}
getAdresseByAdherentId(id:Number){
  return this._http.get(this.baseUrl+'/adresse/adherent/'+id,this.options).map((response:Response)=>response.json())
  .catch(this.errorHandler);
}
updateAdresse(adresse:Adresse){
  return this._http.put(this.baseUrl+'/adresses',JSON.stringify(adresse),this.options).map((response:Response)=>response.json())
  .catch(this.errorHandler);
  }
deleteAdresse(id_adresse:Number){
  return this._http.delete(this.baseUrl+'/adresses/'+id_adresse,this.options).map((response:Response)=>response.json())
  .catch(this.errorHandler);
}

errorHandler(error:Response){
  return Observable.throw(error || "SERVER ERROR");
}
adresseToJson(adresse:Adresse,_adherent_id:Number){
  return {quartier:adresse.quartier,ville:adresse.ville,codePostal:Number.parseInt(adresse.codePostal,10),pays:"maroc",complAdresse:adresse.complAdresse,adherent:{id_adherent:_adherent_id}};
}
}
