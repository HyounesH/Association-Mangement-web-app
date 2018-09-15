import { Injectable } from '@angular/core';
import {Http,Response,Headers,RequestOptions} from '@angular/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import'rxjs/add/observable/throw';
import { Observable } from 'rxjs/Observable';
import { Don } from '../entities/don';

@Injectable()
export class DonService {

  private baseUrl:string='http://localhost:8002/assocSat';
  private headers =new Headers({"Content-Type":"application/json"});
  private options=new RequestOptions({headers:this.headers});
 // private clientOptions={ headers: new HttpHeaders().set('Content-Type' , 'application/json; charset=UTF-8') };
  constructor(private _http:Http) { }

  getDons(){
    return this._http.get(this.baseUrl+'/dons',this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }
  getListMaterielDonnateur(id:Number){
    return this._http.get(this.baseUrl+'/suivi/list/materiel/'+id,this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }
  generateEntreesReport(){
    return this._http.get(this.baseUrl+'/report/entrees',this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }
  generateSortiesReport(){
    return this._http.get(this.baseUrl+'/report/sorties',this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }

  getDon(id:Number):Observable<Don>{
    return this._http.get(this.baseUrl+'/dons/'+id,this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler)
  }
  deleteDon(id:Number){
    return this._http.delete(this.baseUrl+'/dons/'+id,this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);

  }
  saveDon(don:Don,id_donneur?:Number,id_receveur_don?:Number,type_donneur?:string,type_don?:string){
    return this._http.post(this.baseUrl+'/dons',this.JsonDon(don,id_donneur,id_receveur_don,type_donneur,type_don),this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }
  updateDon(don:Don){
    return this._http.put(this.baseUrl+'/dons',JSON.stringify(don),this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }
  unmarkDon(don:Don){
    return this._http.put(this.baseUrl+'/dons',this.unmarkDonJson(don),this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }
  errorHandler(error:Response){
     return Observable.throw(error || "SERVER ERROR");
  }

  countDon(){
    return this._http.get(this.baseUrl+'/dons/count',this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }

  //rendre l'objet don avant de l'insérer
  JsonDon(don:Don,id_donneur?:Number,id_receveur_don?:Number,type_donneur?:string,type_don?:string){
   if(don.type_don==='matr'){
     return {type_don:type_don,date_don:don.date_don,montant:0.0,description_don:don.description_don,etat:don.etat,suivi:don.suivi,dateSortie:don.dateSortie,
            lieuSortie:don.lieuSortie,donneur:{id_donneur:id_donneur,type_donneur:type_donneur},receveur_don:{id_receveur_don:id_receveur_don}};
   }
   else if(don.type_don==='espc'){
     return {type_don:type_don,date_don:don.date_don,montant:don.montant,description_don:don.description_don,donneur:{id_donneur:id_donneur,type_donneur:type_donneur},receveur_don:{id_receveur_don:id_receveur_don}};
   }
   else if(don.type_don==='cheq'){
     return {type_don:type_don,date_don:don.date_don,montant:don.montant,description_don:don.description_don,donneur:{id_donneur:id_donneur,type_donneur:type_donneur},receveur_don:{id_receveur_don:id_receveur_don},
       num_compte_banque:don.num_compte_banque,nom_banque:don.nom_banque,date_cheque:don.date_cheque};
   }
   else {
     return {type_don:type_don,date_don:don.date_don,montant:don.montant,description_don:don.description_don,donneur:{id_donneur:id_donneur,type_donneur:type_donneur},receveur_don:{id_receveur_don:id_receveur_don},
       num_compte_banque:don.num_compte_banque};
   }
  }
  unmarkDonJson(don:Don){
    return {type_don:"matr",date_don:don.date_don,montant:0,description_don:don.description_don,etat:don.etat,suivi:false,dateSortie:don.dateSortie,
      lieuSortie:don.lieuSortie,donneur:{id_donneur:don.donneur.id_donneur,type_donneur:don.donneur.type_donneur},receveur_don:{id_receveur_don:don.receveur_don.id_receveur_don}};
  }
  getMaterielEntrant(){
    return this._http.get(this.baseUrl+'/dons/materiel',this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }

  getMaterielSortant(){
    return this._http.get(this.baseUrl+'/dons/materielSortant',this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }

  getArgentEntrant(){
    return this._http.get(this.baseUrl+'/dons/argent',this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }
}
