import { BureauVote } from './../entities/bureau-vote';
import { Injectable } from '@angular/core';

import {Http,Response,Headers,RequestOptions} from '@angular/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import'rxjs/add/observable/throw';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class BureauVoteService {
  private baseUrl:string='http://localhost:8002/assocSat';
  private headers =new Headers({"Content-Type":"application/json"});
  private options=new RequestOptions({headers:this.headers});
  private _bureauVote:BureauVote;
  constructor(private _http:Http) { }

  getBureauVotes(){
    return this._http.get(this.baseUrl+'/bureauVotes',this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }

  getBureauVote(id:Number){
    return this._http.get(this.baseUrl+'/bureauVotes/'+id,this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler)
  }
  deleteBureauVote(id:Number){
    return this._http.delete(this.baseUrl+'/bureauVotes/'+id,this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);

  }
  saveBureauVote(bureauVote:BureauVote){
    return this._http.post(this.baseUrl+'/bureauVotes',this.saveBvJson(bureauVote),this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }
  updateBureauVote(bureauVote:BureauVote){
    return this._http.put(this.baseUrl+'/bureauVotes',JSON.stringify(bureauVote),this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }


  errorHandler(error:Response){
     return Observable.throw(error || "SERVER ERROR");
  }
  saveBvJson(bv:BureauVote){
    return {nom_bureauVote:bv.nom_bureauVote,adresse:bv.adresse}
  }

}
