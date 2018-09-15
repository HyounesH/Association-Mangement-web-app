import { BureauVote } from './../../../entities/bureau-vote';
import { Adresse } from './../../../entities/adresse';
import { Profession } from './../../../entities/profession';
import { Adherent } from './../../../entities/adherent';
import { Router, ActivatedRoute } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { Serv } from '../../../entities/serv';
import { Communaute } from '../../../entities/communaute';
import { AdherentService } from '../../../services/adherent.service';
import { ExtraServiceService } from '../../../services/extra-service.service';

@Component({
  selector: 'app-membre-details',
  templateUrl: './membre-details.component.html',
  styleUrls: ['./membre-details.component.css']
})
export class MembreDetailsComponent implements OnInit {
  public adherent:Adherent=new Adherent();
  public profession:Profession=new Profession();
  public adresse:Adresse=new Adresse();
  public bv:BureauVote=new BureauVote();
  public service:Serv=new Serv();
  public communaute:Communaute=new Communaute();
  public id:Number;
  public imgData:string="../assets/images/placeholder.png";

  constructor(private _router:Router,private _adherentService:AdherentService,private _activateRouter:ActivatedRoute,private _extraService:ExtraServiceService) { }

  ngOnInit() {
  this.id=Number.parseInt(this._activateRouter.snapshot.paramMap.get('id'),10);
  this._adherentService.getAdherent(this.id).subscribe((data)=>{
    console.log(data);
   this.adherent=data;
   this.profession=data.profession;
   this.bv=data.bureauVote;
   this.service=data.service;
   this.adresse=data.adresses[0];
   this.imgData="http://localhost:8002/assocSat/files/"+this.adherent.photo;
   console.log(this.imgData);
  },(error)=>{
   console.log(error);
  });
  }

back(){
this._router.navigateByUrl("/assoc/membres/list");
}
}
