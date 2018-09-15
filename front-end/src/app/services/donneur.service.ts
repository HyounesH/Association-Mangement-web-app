import { Donneur } from './../entities/donneur';
import { Injectable } from '@angular/core';
import {Http,Response,Headers,RequestOptions} from '@angular/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import'rxjs/add/observable/throw';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class DonneurService {
  private baseUrl:string='http://localhost:8002/assocSat';
  private headers =new Headers({"Content-Type":"application/json"});
  private options=new RequestOptions({headers:this.headers});
 // private clientOptions={ headers: new HttpHeaders().set('Content-Type' , 'application/json; charset=UTF-8') };
  constructor(private _http:Http) { }

  getDonneurs(){
    return this._http.get(this.baseUrl+'/donneurs',this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }
  getListDonnateurSuivi(){
    return this._http.get(this.baseUrl+'/list/donnateurs',this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }
  getDonneur(id:Number):Observable<Donneur>{
    return this._http.get(this.baseUrl+'/donneurs/'+id,this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler)
  }
  deleteDonneur(id:Number){
    return this._http.delete(this.baseUrl+'/donneurs/'+id,this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);

  }
  saveDonneur(donneur:Donneur,type_donneur:string){
    return this._http.post(this.baseUrl+'/donneurs',this.donneurJson(donneur,type_donneur),this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }
  updateDonneur(don:Donneur){
    return this._http.put(this.baseUrl+'/donneurs',this.updateDonnateurJson(don),this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }
  generatePassword(value:string){
    return this._http.get(this.baseUrl+'/donneurs/password/generate/'+value,this.options).map((response:Response)=>response)
    .catch(this.errorHandler);
  }
  login(email:string,password:string){
    return this._http.get(this.baseUrl+'/donnateur/login/'+email+'/'+password,this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }

  donneurJson(donneur:Donneur,type_donneur:string){
    if(type_donneur==='morale'){
    return {role:"donnateur",email:donneur.email,telephone:donneur.telephone,suivi:true,adresse:donneur.adresse,ville:donneur.ville,pays:donneur.pays,type_donneur:type_donneur,nom_moral:donneur.nom_moral};
    }
    else{
      return {role:"donnateur",email:donneur.email,telephone:donneur.telephone,suivi:true,adresse:donneur.adresse,ville:donneur.ville,pays:donneur.pays,type_donneur:type_donneur,nom:donneur.nom,prenom:donneur.prenom,cin:donneur.cin};
    }
  }

  errorHandler(error:Response){
     return Observable.throw(error || "SERVER ERROR");
  }
  updateDonnateurJson(donnateur:Donneur){
   if(donnateur.type_donneur==='morale'){
    return {id_donneur:donnateur.id_donneur,role:"donnateur",password:donnateur.password,suivi:donnateur.suivi,email:donnateur.email,telephone:donnateur.telephone,adresse:donnateur.adresse,ville:donnateur.ville,pays:donnateur.pays,type_donneur:donnateur.type_donneur,nom_moral:donnateur.nom_moral};
   }
   else {
    return {id_donneur:donnateur.id_donneur,role:"donnateur",password:donnateur.password,suivi:donnateur.suivi,email:donnateur.email,telephone:donnateur.telephone,adresse:donnateur.adresse,ville:donnateur.ville,pays:donnateur.pays,type_donneur:donnateur.type_donneur,nom:donnateur.nom,prenom:donnateur.prenom,cin:donnateur.cin};
   }
  }

}
