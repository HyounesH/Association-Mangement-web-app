import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Don } from './../../../../entities/don';
import {Adherent} from './../../../../entities/adherent';
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { AdherentService } from '../../../../services/adherent.service';
import { DonService } from '../../../../services/don.service';
import { ReceveurDonService } from '../../../../services/receveur-don.service';
import { DonneurService } from '../../../../services/donneur.service';

@Component({
  selector: 'app-don-info',
  templateUrl: './don-info.component.html',
  styleUrls: ['./don-info.component.css']
})
export class DonInfoComponent implements OnInit {
  public don:Don=new Don();
  public typeDon:string="arg";
  public typePaiment:string="espc";
  public typeDonInserer:string;
  public  UserId:string;
  public donneurId:string;
  public receveur_don_id:Number;
  public type_don:string;
  public suivi:boolean=false;
  public donForm:FormGroup;
  public type_donneur:string;
  public id_receveur_don:Number;
  constructor(private _router:Router,private _donService:DonService,private _receveurDonService:ReceveurDonService,private _activateRouter:ActivatedRoute,private _donneurService:DonneurService) { }

  ngOnInit() {
  this.UserId=sessionStorage.getItem("userId");
  this.donneurId=this._activateRouter.snapshot.paramMap.get('id');
  this.donForm=new FormGroup({
   "description_don":new FormControl(this.don.description_don,Validators.required),
   "date_don":new FormControl(this.don.date_don,Validators.required),
   "montant":new FormControl(this.don.montant,[Validators.required,Validators.pattern("^[0-9]+$")]),
   "num_compte_banque":new FormControl(this.don.num_compte_banque,[Validators.required,Validators.pattern("^[0-9]+$")]),
   "nom_banque":new FormControl(this.don.nom_banque,[Validators.required,Validators.pattern("^[a-zA-Z]+$")]),
   "date_cheque":new FormControl(this.don.date_cheque,Validators.required),
   "etat":new FormControl(this.don.etat,Validators.required)
  });
  this._receveurDonService.saveReceveurDon(Number.parseInt(this.UserId,10)).subscribe((data)=>{
    console.log(data);
    this.id_receveur_don=data.id_receveur_don;
  },(erreur)=>{
    console.log(erreur);
  });
  this._donneurService.getDonneur(Number.parseInt(this.donneurId,10)).subscribe((data)=>{
    console.log(data);
  this.type_donneur=data.type_donneur;
  },(error)=>{
    console.log(error);
  });

  }
  addDon(){
    console.log("donneur id : "+this.donneurId);
    console.log("receveur don id : "+this.id_receveur_don);
    this.typeDonInserer=this.typeDon;
    if(this.typeDon==='arg'){
      this.typeDonInserer=this.typePaiment;
    }
    console.log("type don inserer : "+this.typeDonInserer);
    console.log("type donnateur : "+this.type_donneur);
    console.log("suivi : "+this.don.suivi);
    console.log("etat : "+this.don.etat);
      this._donService.saveDon(this.don,Number.parseInt(this.donneurId,10),this.id_receveur_don,this.type_donneur,this.typeDonInserer).subscribe((donnee)=>{
        console.log(donnee);
      },(error)=>{
      console.log(error);
      });
    this._router.navigateByUrl("/assoc/dons/list");
    window.location.reload();
  }
  navigateToDonneur(){
    this._router.navigateByUrl("/assoc/dons/add");
  }
  get description(){
    return this.donForm.get("description_don");
  }
  get donDate(){
    return this.donForm.get("date_don");
  }
  get donMontant(){
    return this.donForm.get("montant");
  }
  get compteNumberBanc(){
    return this.donForm.get("num_compte_banque");
  }
  get chequeDate(){
    return this.donForm.get("date_cheque");
  }
  get state(){
    return this.donForm.get("etat");
  }
  get bancName(){
    return this.donForm.get("nom_banque");
  }

}
