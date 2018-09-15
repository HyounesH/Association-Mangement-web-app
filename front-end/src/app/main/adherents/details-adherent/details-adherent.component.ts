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
  selector: 'app-details-adherent',
  templateUrl: './details-adherent.component.html',
  styleUrls: ['./details-adherent.component.css']
})
export class DetailsAdherentComponent implements OnInit {
  public adherent:Adherent;
  public profession:Profession;
  public adresse:Adresse;
  public bv:BureauVote;
  public service:Serv;
  public communaute:Communaute;
  public id:Number;
  public imgData:string;

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
this._router.navigateByUrl("/assoc/adherent/list");
}
}
