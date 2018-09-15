import { AdherentService } from './../../../services/adherent.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { ExtraServiceService } from './../../../services/extra-service.service';
import { AdresseService } from './../../../services/adresse.service';
import { Adresse } from './../../../entities/adresse';
import { Router, ActivatedRoute } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-adresses',
  templateUrl: './adresses.component.html',
  styleUrls: ['./adresses.component.css']
})
export class AdressesComponent implements OnInit {
  public  adresses:Adresse=new Adresse();
  public id:string;
  public adresseForm:FormGroup;
  public countries:any;
  constructor(private _router:Router,private _adresseService:AdresseService,private _extraService:ExtraServiceService,private _activateRouter:ActivatedRoute) { }

  ngOnInit(
  ) {
  this._extraService.getcountries().subscribe((data)=>{
  this.countries=data;
  },(error)=>{
    console.log(error);
  });
  this.id=this._activateRouter.snapshot.paramMap.get('id');
  this.adresseForm=new FormGroup({
   "quartier":new FormControl(this.adresses.quartier,Validators.required),
   "ville":new FormControl(this.adresses.ville,Validators.required),
   "codePostal":new FormControl(this.adresses.codePostal,[Validators.required,Validators.pattern("^[0-9]+$")]),
   "complAdresse":new FormControl(this.adresses.complAdresse,Validators.required)
  });
}
  addAdherent(){
    this._adresseService.saveAdresse(this.adresses,Number.parseInt(this.id,10)).subscribe((data)=>{
    console.log(data);
    },(error)=>{
    console.log(error);
    });
    this._router.navigateByUrl("/assoc");
  }
  get street(){
    return this.adresseForm.get("quartier");
  }
  get city(){
    return this.adresseForm.get("ville");
  }
  get postalCode(){
    return this.adresseForm.get("codePostal");
  }
  get extraAdresse(){
    return this.adresseForm.get("complAdresse");
  }
  infoStandard(){this._router.navigateByUrl("/assoc/adherent/add");}
  infoAdresses(){this._router.navigateByUrl("/assoc/adherent/add/adresses");}
}
