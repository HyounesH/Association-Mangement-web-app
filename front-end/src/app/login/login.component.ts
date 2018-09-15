import { Router } from '@angular/router';
import { Component, OnInit, ElementRef, ViewChild } from '@angular/core';
import { Adherent } from '../entities/adherent';
import { AdherentService } from '../services/adherent.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  public email:string="";
  public password:string="";
  private adherent:Adherent[];
  @ViewChild('closeModal') closeModal: ElementRef;
  constructor(private _router:Router,private _adherentService:AdherentService) { }

  ngOnInit() {
   }
  forgotPassword(){
  this._router.navigateByUrl('forgot-password');
  }
  login(){
  this._adherentService.login(this.email,this.password).subscribe((response)=>{
  this.adherent=response;

  if(this.adherent.length !=0){
  sessionStorage.setItem("login",this.adherent[0].nom_adherent+" "+this.adherent[0].prenom_adherent);
  sessionStorage.setItem("userId",this.adherent[0].id_adherent.toString());
  sessionStorage.setItem("role",this.adherent[0].role.toString());
   this._router.navigateByUrl("/assoc");
  }
  else{
  this.closeModal.nativeElement.click();
  }

  },(error)=>{
    console.log(error);
  });
}
navigateToDonnateurAuth(){
  this._router.navigateByUrl("login/donnateur");
}


}
