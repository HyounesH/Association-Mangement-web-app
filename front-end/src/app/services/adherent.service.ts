import { Adherent } from './../entities/adherent';
import { Injectable } from '@angular/core';
import {Http,Response,Headers,RequestOptions} from '@angular/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import'rxjs/add/observable/throw';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class AdherentService {
  private baseUrl:string='http://localhost:8002/assocSat';
  private headers =new Headers({"Content-Type":"application/json"});
  private options=new RequestOptions({headers:this.headers});
  private _nbreAdherent:number;
  private _adherent:Adherent
  constructor(private _http:Http) { }

  getAdherents(){
    return this._http.get(this.baseUrl+'/adherents',this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }

  getMembres(){
    return this._http.get(this.baseUrl+'/membres',this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }

  getAdherent(id:Number){
    return this._http.get(this.baseUrl+'/adherents/'+id,this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }
  deleteAdherent(id:Number){
    return this._http.delete(this.baseUrl+'/adherents/'+id,this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);

  }
  saveAdherent(adherent:Adherent,profession_id=null,_communaute_id=null,_bureau_vote_id=null,_id_service=null,role="membre"){
    return this._http.post(this.baseUrl+'/adherents',this.addAdherentJson(adherent,profession_id,_communaute_id,_bureau_vote_id,_id_service,role),this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }
  updateAdherent(adherent:Adherent,profession_id=null,_communaute_id=null,_bureau_vote_id=null,_id_service=null,role="membre"){
    return this._http.put(this.baseUrl+'/adherents',this.addAdherentJson(adherent,profession_id,_communaute_id,_bureau_vote_id,_id_service,role),this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
    }
  saveAdherentMembre(adherent:Adherent,role="membre"){
    return this._http.post(this.baseUrl+'/adherents',this.addAdherentMembreJson(adherent,role),this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }
  login(email:string,password:string){
    return this._http.get(this.baseUrl+'/login/'+email+'/'+password,this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }
  errorHandler(error:Response){
     return Observable.throw(error || "SERVER ERROR");
  }

  addAdherentJson(adherent:Adherent,_profession_id=null,_communaute_id=null,_bureau_vote_id=null,_id_service=null,role="membre"){
return {nom_adherent:adherent.nom_adherent,prenom_adherent:adherent.prenom_adherent,cin:adherent.cin,dateDeNaissance:adherent.dateDeNaissance,
  lieuDeNaissance:adherent.lieuDeNaissance,role:role,dateAdhesion:new Date(),numeroVote:adherent.numeroVote,photo:adherent.photo,motPasse:adherent.motPasse,
  sexe:adherent.sexe,telephone:adherent.telephone,email:adherent.email,profession:{profession_id:_profession_id},communaute:{communaute_id:_communaute_id},bureauVote:{bureauVote_id:_bureau_vote_id},
  service:{id_service:_id_service} };
  }
  addAdherentMembreJson(adherent:Adherent,role="membre"){
    return {nom_adherent:adherent.nom_adherent,prenom_adherent:adherent.prenom_adherent,cin:adherent.cin,dateDeNaissance:adherent.dateDeNaissance,
      lieuDeNaissance:adherent.lieuDeNaissance,role:role,dateAdhesion:new Date(),numeroVote:adherent.numeroVote,photo:adherent.photo,motPasse:adherent.motPasse,
      sexe:adherent.sexe,telephone:adherent.telephone,email:adherent.email};
  }
  getter(){
    return this._adherent;
  }
  setter(value:Adherent){
  this._adherent=new Adherent();
  this._adherent=value;
  }

  countAdherent(){
    return this._http.get(this.baseUrl+'/adherents/count',this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }

}
