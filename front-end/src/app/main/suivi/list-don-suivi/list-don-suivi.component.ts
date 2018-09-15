import { Don } from './../../../entities/don';
import { DonService } from './../../../services/don.service';
import { Component, OnInit } from '@angular/core';
import { AdherentService } from '../../../services/adherent.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-list-don-suivi',
  templateUrl: './list-don-suivi.component.html',
  styleUrls: ['./list-don-suivi.component.css']
})
export class ListDonSuiviComponent implements OnInit {
  private donneurId:Number;
  public listDon:Don[];
  constructor(private _router:Router,private _donService:DonService,private _adherentService:AdherentService) { }

  ngOnInit() {
  this.donneurId=Number.parseInt(sessionStorage.getItem("userId"),10);
  this._donService.getListMaterielDonnateur(this.donneurId).subscribe((data)=>{
    this.listDon=data;
    for(let i=0;i<data.length;i++){
  this._adherentService.getAdherent(data[i].receveur_don.code_employe).subscribe((response)=>{
    console.log(response);
    this.listDon[i].nomComplet=response.nom_adherent+" "+response.prenom_adherent;
    this.listDon[i].role=response.role;
  });
}
  },(error)=>{
  console.log(error);
  });
  }
  navigateToDetails(id:Number){
  this._router.navigateByUrl("assoc/donnateur/suivi/list/"+id+"/details")
  }

}
