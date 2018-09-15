import { Donneur } from './../entities/donneur';
import { DonneurService } from './../services/donneur.service';
import { Router } from '@angular/router';
import { Component, OnInit, ElementRef, ViewChild } from '@angular/core';

@Component({
  selector: 'app-donnateur-login',
  templateUrl: './donnateur-login.component.html',
  styleUrls: ['./donnateur-login.component.css']
})
export class DonnateurLoginComponent implements OnInit {

  public email:string="";
  public password:string="";
  public donnateurs:Donneur[];
  @ViewChild('closeModal') closeModal: ElementRef;
  constructor(private _router:Router,private _donnateurService:DonneurService) { }

  ngOnInit() {
   }
  forgotPassword(){
  this._router.navigateByUrl('forgot-password');
  }
  login(){
  this._donnateurService.login(this.email,this.password).subscribe((response)=>{
  this.donnateurs=response;
  if(this.donnateurs.length !=0){
    if(this.donnateurs[0].type_donneur=="physiq"){
  sessionStorage.setItem("login",this.donnateurs[0].nom+" "+this.donnateurs[0].prenom);
    }
    else{
  sessionStorage.setItem("login",this.donnateurs[0].nom_moral);
    }
  sessionStorage.setItem("userId",this.donnateurs[0].id_donneur.toString());
  sessionStorage.setItem("role",this.donnateurs[0].role.toString());
   this._router.navigateByUrl("/assoc/donnateur/suivi/list");
  }
  else{
  this.closeModal.nativeElement.click();
  }

  },(error)=>{
    console.log(error);
  });
}
navigateToAdherentAuth(){
  this._router.navigateByUrl("");
}
}
