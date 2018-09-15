import { DonneurService } from './../../../../services/donneur.service';
import { Donneur } from './../../../../entities/donneur';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-donneur-info',
  templateUrl: './donneur-info.component.html',
  styleUrls: ['./donneur-info.component.css']
})
export class DonneurInfoComponent implements OnInit {
  public donneur:Donneur=new Donneur();
  public typeDonneur:string="physiq";
  public donnateurForm:FormGroup;
  constructor(private _router:Router,private _donneurService:DonneurService) { }

  ngOnInit() {
    this.donnateurForm=new FormGroup({
     "email":new FormControl(this.donneur.email,[Validators.required,Validators.pattern("^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$")]),
     "telephone":new FormControl(this.donneur.telephone,[Validators.required,Validators.pattern("^0[567][0-9]{8}$")]),
     "adresse":new FormControl(this.donneur.adresse,Validators.required),
     "ville":new FormControl(this.donneur.ville,Validators.required),
     "pays":new FormControl(this.donneur.pays,Validators.required),
     "nom":new FormControl(this.donneur.nom,Validators.required),
     "prenom":new FormControl(this.donneur.prenom,Validators.required),
     "cin":new FormControl(this.donneur.cin,Validators.required),
     "nom_moral":new FormControl(this.donneur.nom_moral,Validators.required)
    });
  }
  navigateToDonneur(){
    this._router.navigateByUrl("/assoc/dons/add");
  }
  saveDonneur(){
   this._donneurService.saveDonneur(this.donneur,this.typeDonneur).subscribe((data)=>{
   console.log(data);
   this._router.navigateByUrl("/assoc/dons/add/"+data.id_donneur+"/donData");
   },(error)=>{
     console.log(error);
   });
  }
  get emaile(){
    return this.donnateurForm.get("email");
  }
  get phone(){
    return this.donnateurForm.get("telephone");
  }
  get addresse(){
    return this.donnateurForm.get("adresse");
  }
  get city(){
    return this.donnateurForm.get("ville");
  }
  get country(){
    return this.donnateurForm.get("pays");
  }
  get lname(){
    return this.donnateurForm.get("nom");
  }
  get fname(){
    return this.donnateurForm.get("prenom");
  }
  get code(){
    return this.donnateurForm.get("cin");
  }
 get moral_name(){
   return this.donnateurForm.get("nom_moral");
 }


}
