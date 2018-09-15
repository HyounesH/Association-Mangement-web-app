import { Component, OnInit } from '@angular/core';
import { Adherent } from '../../../entities/adherent';
import { AdherentService } from '../../../services/adherent.service';
import { AdresseService } from '../../../services/adresse.service';
import {Router} from '@angular/router';

@Component({
  selector: 'adherent-add',
  templateUrl: './adherent-add.component.html',
  styleUrls: ['./adherent-add.component.css']
})
export class AdherentAddComponent implements OnInit {
  public adherent:Adherent;
  constructor(private _serviceAdherent:AdherentService,private _serviceAdresse:AdresseService,_router:Router) { }

  ngOnInit() {
    this.adherent=this._serviceAdherent.getter();
  }

  AddAdherent(){
   console.log(this.adherent);
  }
}
