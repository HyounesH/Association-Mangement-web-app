import { Don } from './../../entities/don';
import { DonService } from './../../services/don.service';
import { Component, OnInit } from '@angular/core';
import { Donneur } from '../../entities/donneur';
import { DonneurService } from '../../services/donneur.service';
import { ExtraServiceService } from '../../services/extra-service.service';

@Component({
  selector: 'app-donnateur',
  templateUrl: './donnateur.component.html',
  styleUrls: ['./donnateur.component.css']
})
export class DonnateurComponent implements OnInit {
  public listDonnateur:Donneur[];
  public ListDon:Don[];
  constructor(private _donnateurService:DonneurService,private _donService:DonService) { }

  ngOnInit() {
    this._donnateurService.getListDonnateurSuivi().subscribe((data)=>{
    console.log(data);
    this.listDonnateur=data;
    },(error)=>{
    console.log(error);
    });
  }
  sendPassword(donnateur:Donneur){
    console.log(donnateur.id_donneur);
   donnateur.suivi=false;
  this._donnateurService.updateDonneur(donnateur).subscribe((data)=>{
    console.log(data)
  },(error)=>{
    console.log(error);
  });
  this._donnateurService.generatePassword(donnateur.telephone).subscribe((data)=>{
    donnateur.password=data._body;
    console.log(data._body);
    this._donnateurService.updateDonneur(donnateur).subscribe((dataD)=>{
     console.log(dataD);
    },(error)=>{
      console.log(error);
    });
  },(erreur)=>{
    console.log(erreur);
  });
 window.location.reload();
  }

}
