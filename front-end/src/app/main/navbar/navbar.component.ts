import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'aside',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  assocName:string;
  assocLogo:string;
  public activeRole:string=null;
  constructor(private _router:Router) {
    this.assocName="ASSOC-SAT";
    this.assocLogo="AS";
  }

  ngOnInit() {
  this.activeRole=sessionStorage.getItem("role");
  }
  listDons(){
    this._router.navigateByUrl("/assoc/dons/list");
  }
  ajouterDon(){
    this._router.navigateByUrl("/assoc/dons/add");
  }
  naviagateToDashboard(){
    this._router.navigateByUrl("/assoc");
  }
  listMembre(){
  this._router.navigateByUrl("/assoc/membres/list");
  }
  addMembre(){
    this._router.navigateByUrl("/assoc/membres/add");
  }
  naviagateToDonnateur(){
   this._router.navigateByUrl("/assoc/donnateurs");
  }
  entrees(){
    this._router.navigateByUrl("/assoc/rapport/entrees");
  }
  sorties(){
    this._router.navigateByUrl("/assoc/rapport/sorties");
  }
  depenses(){
    this._router.navigateByUrl("/assoc/rapport/depenses");
  }

}
